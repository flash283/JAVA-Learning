README 直接复制我这个，按你实际密码修改一下说明即可：

```markdown
# 图书管理系统（Spring Boot 版）

## 项目简介
基于 Spring Boot + MyBatis + MySQL 的图书管理系统后端接口，提供图书管理和用户管理功能。

## 技术栈
- Spring Boot 3.3.5
- MyBatis 3.0.3
- MySQL 8.0
- Maven

## 功能
### 图书模块
- 图书增删改查
- 按编号查询、按书名模糊查询
- 分页查询
- 条件查询（按作者、按借阅状态）
- 借书、还书

### 用户模块
- 用户注册
- 用户登录
- 用户增删改查

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

### 用户接口（/api/user）
| 接口 | 方法 | 说明 |
|------|------|------|
| /api/user/register | POST | 注册 |
| /api/user/login | POST | 登录 |
| /api/user | GET | 查询所有用户 |
| /api/user/{id} | GET | 按编号查询 |
| /api/user/{id} | PUT | 修改用户 |
| /api/user/{id} | DELETE | 删除用户 |

## 数据库
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
```

## 运行方式
1. 创建数据库并建表
2. 修改 `application.properties` 里的数据库密码
3. 运行 `SpringbootBookmanagerApplication`
4. 用 Postman/Apifox 测试接口
```