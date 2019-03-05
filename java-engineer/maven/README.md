# Maven

* [pom.xml](pom/README.md)

* [plugins](plugins/README.md)

## [Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
![](pic/build-life-cycle.png)

* validate
```md
验证项目是否正确，并提供所有必要信息。
```

* compile 编译项目的源代码

> * maven-compiler-plugin

* test
```md
使用合适的单元测试框架测试编译的源代码，这些测试不应要求打包或部署代码。
```
> * maven-surefire-plugin
```md
是maven里执行测试用例的插件，不显示配置就会用默认配置。
插件的surefire:test命令会默认绑定maven执行的test阶段。
```
* [package](package.md)
```md
获取已编译的代码并将其打包为可分发的格式，例如JAR。
```
* verify
```md
对集成测试结果进行任何检查，以确保满足质量标准。
```
* install
```md
将软件包安装到本地存储库中，以便在本地用作其他项目的依赖项。
```
* deploy
```md
将最终包复制到远程存储库以与其他开发人员和项目共享。
```
## Maven CMD
```shell
$ mvn -Dmaven.test.skip=true package

```

## Reference

* [Maven Tutorial](https://howtodoinjava.com/maven/)