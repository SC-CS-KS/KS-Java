# Dependency Management
```md
groupId、artifactId、version 组成的 Coordination（坐标）唯一标识一个依赖。
任何基于Maven构建的项目自身也必须定义这三项属性，生成的包可以是Jar包，也可以是 war 包或者 ear 包。
```
## Repository
```md
远程仓库可以使用世界公用的central仓库，也可以使用Apache Nexus自建私有仓库；本地仓库则在本地计算机上。
通过 Maven 安装目录下的 settings.xml 文件可以配置本地仓库的路径，以及采用的远程仓库的地址。
```

## Config
```xml
<dependency>
 <groupId>junit</groupId>
 <artifactId>junit</artifactId>
 <version>4.12</version>
 <scope>test</scope>
</dependency>

<dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-test</artifactId>
</dependency>
```
* version
```md
可以省略掉，这样在获取依赖时会选择最新的版本。
```

## [Dependency Scope](Scope.md)
