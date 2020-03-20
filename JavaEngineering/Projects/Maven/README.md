# Maven

```md
依赖管理
多模块构建
一致的项目结构
一致的构建模型
插件机制
```

## Design
* [mvn CMD](design/Cli/README.md)
* [pom.xml](design/Pom/README.md)
* [plugins](design/Plugins/README.md)
* [repository](design/Repository/README.md)

## Features
* [项目管理](F_Project/README.md)
* [依赖管理 Dependency Management](F_Dependency/README.md)
* [构建管理 Build](F_Build/README.md)

## [Nexus](https://blog.sonatype.com/)
```md
Nexus 是 Maven仓库管理器，如果你使用Maven，你可以从Maven中央仓库 下载所需要的构件（artifact），
但这通常不是一个好的做法，你应该在本地架设一个Maven仓库服务器，
在代理远程仓库的同时维护本地仓库，以节省带宽和时间，Nexus就可以满足这样的需要。
此外，他还提供了强大的仓库管理功能，构件搜索功能，它基于REST，
友好的 UI 是一个 extjs 的 REST客户端，它占用较少的内存，基于简单文件系统而非数据库。
这些优点使其日趋成为最流行的Maven仓库管理器。
```

## Reference
* [Maven Tutorial](https://howtodoinjava.com/maven/)