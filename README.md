
# Gilded Rose 项目

这是一套基于TDD、持续集成的极限编程实践项目。本项目用于学习和练习TDD。  
特性：  
- 前端是基于React、TypeScript框架，并集成了测试工具。
- 后端是基于Spring Boot搭建的Web框架，使用checkstyle检查代码风格，使用jacoco检查测试覆盖率，目前配置100%覆盖。  
- 方便做持续集成和持续发布


## 准备环境
### 容器技术
本项目的开发依赖容器技术，需要开发环境有Docker环境。如您尚未配置Docker环境，请先自行配置Docker环境。Mac OS X和Windows请安装Docker Desktop，Linux系统直接安装Docker CE.以下信息供参考：
- Mac OS X: https://www.docker.com/products/docker-desktop
- Windows: https://www.docker.com/products/docker-desktop
- Ubuntu: https://docs.docker.com/engine/install/ubuntu/
- CentOS: https://docs.docker.com/engine/install/centos/

### 开发平台
本项目使用Java平台开发，严重依赖Java生态环境。请先安装OpenJDK 11：
- OpenJDK 11 for Windows: https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_windows-x64_bin.zip
- OpenJDK 11 for Mac: https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_osx-x64_bin.tar.gz
- OpenJDK 11 for Linux: https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz

### 前端工具链
本项目前端库和工具链相关版本：
- Node: 12.22.1
  - Windows x64: https://npm.taobao.org/mirrors/node/latest-v12.x/node-v12.22.1-x64.msi
- NPM: 6.14.12
- TypeScript: 4.2.4
- React: 17.0.2

### 开发工具
为了更好的开发体验以及更高的开发效率，请使用IntelliJ IDEA作为默认开发工具：
- IntelliJ IDEA: https://www.jetbrains.com/idea/

## 使用手册

### 1.安装所有前端依赖
```shell script
./scripts/prepare-npm
```

### 2.运行前端项目
```shell script
./scripts/run-webui
```

### 3.运行主项目
```shell script
./scripts/run-server
```
### 4.快速检查代码风格
```shell script
./scripts/check-static
```

### 5.提交前代码检查
```shell script
./scripts/check-all
```

## 联系
上海瀚诚软件科技有限公司  
email：develop@highsoft.ltd
