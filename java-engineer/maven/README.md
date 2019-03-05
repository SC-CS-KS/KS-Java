# Maven

## Build Lifecycle
![](pic/build-life-cycle.png)

* validate

* compile
> * maven-compiler-plugin

* test
> * maven-surefire-plugin
```md
是maven里执行测试用例的插件，不显示配置就会用默认配置。
插件的surefire:test命令会默认绑定maven执行的test阶段。
```
* [package](package.md)

* verify

* install

* deploy


## Reference
* [Maven Tutorial](https://howtodoinjava.com/maven/)