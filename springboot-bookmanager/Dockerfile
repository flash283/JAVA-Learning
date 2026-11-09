# 1. 基础镜像：使用官方的 Eclipse Temurin JDK 25（轻量版）
FROM eclipse-temurin:25-jre-alpine

# 2. 设置工作目录（在容器内创建一个文件夹）
WORKDIR /app

# 3. 把你的 jar 包复制到容器的 /app 目录下，并重命名为 app.jar
# 注意：这里的 xxx.jar 必须和你实际打包出来的名字一模一样
COPY target/springboot-bookmanager-0.0.1-SNAPSHOT.jar app.jar

# 4. 声明容器运行时暴露的端口（和你的项目端口一致）
EXPOSE 8080

# 5. 启动容器时执行的命令
ENTRYPOINT ["java", "-jar", "app.jar"]