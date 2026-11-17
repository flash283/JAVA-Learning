# 图书管理系统（Spring Boot 后端接口）

## 项目简介
基于 Spring Boot 3 开发的前后端分离后端接口，提供图书管理、用户管理功能，并集成了 JWT 权限认证、Redis 高级缓存防护以及 Docker 容器化部署。

## 技术栈
- **核心框架**：Spring Boot 3.3.5
- **持久层**：MyBatis 3.0.3
- **数据库**：MySQL 8.0
- **缓存**：Redis
- **认证**：JWT (JSON Web Token)
- **构建工具**：Maven
- **部署运维**：Docker, Linux

## 项目核心亮点
1. **安全的接口鉴权**：基于 JWT 生成 Token，结合 Spring 拦截器实现无状态登录校验。
2. **高并发缓存保护**：针对热点图书数据引入 Redis 缓存，并使用 **互斥锁 (setnx)** 解决缓存击穿，**缓存空值**解决穿透，**随机过期时间**防止雪崩。
3. **统一响应与异常处理**：自定义泛型 `Result` 类，结合 `@RestControllerAdvice` 实现全局异常统一 JSON 格式返回。
4. **容器化部署**：编写 `Dockerfile` 实现项目专属镜像构建，隔离环境实现标准部署。

## 快速启动 (Docker 方式)
1. 在本地执行 `mvn package` 打包生成 jar 包。
2. 执行 `docker build -t my-book-app:v1 .` 构建项目专属镜像。
3. 使用 `docker run` 启动 MySQL 与 Redis 容器，并创建 `my-net` 网络。
4. 运行 `docker run -d --name book-app -p 8080:8080 --network my-net my-book-app:v1` 启动服务。

---

## 接口文档

### 图书接口（/api/books）
| 接口 | 方法 | 说明 |
|------|------|------|
| /api/books | GET | 查询所有图书 |
| /api/books/{id} | GET | 按编号查询 |
| /api/books/search?title=xxx | GET | 按书名模糊查询 |
| /api/books/page?page=1&size=5 | GET | 分页查询 |
| /api/books/filter?author=xxx | GET | 条件查询 |
| /api/books | POST | 添加图书 |
| /api/books/{id} | PUT | 修改图书 |
| /api/books/{id} | DELETE | 删除图书 |
| /api/books/{id}/borrow | PUT | 借书 |
| /api/books/{id}/return | PUT | 还书 |

*(注：/api/books/** 接口需在 Header 中携带 `Authorization: Bearer <Token>`)*

### 用户接口（/api/user）
| 接口 | 方法 | 说明 |
|------|------|------|
| /api/user/register | POST | 注册 |
| /api/user/login | POST | 登录（返回 JWT Token） |
| /api/user | GET | 查询所有用户 |
| /api/user/{id} | GET | 按编号查询 |
| /api/user/{id} | PUT | 修改用户 |
| /api/user/{id} | DELETE | 删除用户 |

## 数据库表结构
```sql
CREATE DATABASE mydb;

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(20),
    isbn VARCHAR(30),
    is_borrowed BOOLEAN DEFAULT FALSE
);

CREATE TABLE `user` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);