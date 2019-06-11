# Plugins
```md
Maven 本质上是一个插件框架，它的核心并不执行任何具体的构建任务，所有这些任务都交给插件来完成，
例如编译源代码是由maven- compiler-plugin完成的。
进一步说，每个任务对应了一个插件目标（goal），每个插件会有一个或者多个目标，
例如: maven- compiler-plugin的compile目标用来编译位于src/main/java/目录下的主源码，
testCompile目标用来编译位于src/test/java/目录下的测试源码。
```
* 用户可以通过两种方式调用Maven插件目标
```md
1. 将插件目标与生命周期阶段（  lifecycle phase ）绑定，这样用户在命令行只是输入生命周期阶段而已，
    例如 Maven 默认将maven-compiler-plugin的 compile目标与 compile 生命周期阶段绑定，
    因此命令mvn compile实际上是先定位到compile这一生命周期阶段，
    然后再根据绑定关系调用maven-compiler-plugin的compile目标。
2. 直接在命令行指定要执行的插件目标
    例如 mvn archetype:generate 就表示调用 maven-archetype-plugin 的 generate 目标，
    这种带冒号的调用方式与生命周期无关。
```
* Maven官方有两个插件列表

[1. GroupId为 org.apache.maven.plugins，这里的插件最为成熟。](http://maven.apache.org/plugins/index.html) 
[2. GroupId为org.codehaus.mojo ，这里的插件没有那么核心，但也有不少十分有用。](http://www.mojohaus.org/plugins.html)

## Plugins
* maven-jar-plugin
```md
编译src/main/java 和src/main/resources 下的java文件。
使用 maven-jar-plugin 打包出来的可执行 jar 是不包含依赖的，
需要使用 maven-dependency-plugin 同时打包依赖。
```

* maven-shade-plugin
```md
它将所有依赖项打包到一个uber-JAR中。
它还可以通过指定主类来构建可执行JAR。
此插件特别有用，因为它合并特定文件的内容，而不是通过重定位类来覆盖它们。
当存在跨JAR具有相同名称的资源文件并且插件尝试将所有资源文件打包在一起时，则需要这样做。

shade插件绑定在 maven 的 package 阶段，他会将项目依赖的jar包解压并融合到项目自身编译文件中。
```

* [maven-assembly-plugin](http://maven.apache.org/plugins/maven-assembly-plugin)
```md
用途是制作项目分发包，该分发包可能包含了项目的可执行文件、源代码、readme、平台脚本等等。

支持各种主流的格式如zip、tar.gz、jar和war等，具体打包哪些文件是高度可控的，
例如用户可以 按文件级别的粒度、文件集级别的粒度、模块级别的粒度、以及依赖级别的粒度控制打包，
此外，包含和排除配置也是支持的。

要求用户使用一个名为assembly.xml的元数据文件来表述打包，它的single目标可以直接在命令行调用，也可以被绑定至生命周期。

此插件将所有依赖项JAR提取到原始类中并将它们组合在一起。
它还可以通过指定主类来构建可执行JAR。
它适用于仅具有较少依赖性的项目，对于具有许多依赖项的大型项目，它将导致Java类名冲突。
```

* maven-dependency-plugin
```md
最大的用途是帮助分析项目依赖，
dependency:list能够列出项目最终解析到的依赖列表，
dependency:tree能进一步的描绘项目依赖树，
dependency:analyze可以告诉你项目依赖潜在的问题，如果你有直接使用到的却未声明的依赖，该目标就会发出警告。m

maven-dependency-plugin还有很多目标帮助你操作依赖文件，
例如dependency:copy-dependencies能将项目依赖从本地Maven仓库复制到某个特定的文件夹下面。
```

* maven-source-plugin
```md
插件打出的包包含源码，在eclipse等 IDE 中查看源文件时可以更易读些。
```

* [maven-archetype-plugin](http://maven.apache.org/archetype/maven-archetype-plugin)
```md
生成一个很简单的项目骨架，帮助开发者快速上手。
maven-archetype-plugin还有一些其他目标帮助用户自己定义项目原型，
例如你由一个产品需要交付给很多客户进行二次开发，你就可以为 他们提供一个 archetype，帮助他们快速上手。
```


## Reference
* [常用Maven插件介绍TOP13](https://www.toutiao.com/i6696230513847304718/)
