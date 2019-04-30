# Plugins

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

* maven-assembly-plugin
```md
此插件将所有依赖项JAR提取到原始类中并将它们组合在一起。
它还可以通过指定主类来构建可执行JAR。
它适用于仅具有较少依赖性的项目，对于具有许多依赖项的大型项目，它将导致Java类名冲突。
```

* maven-source-plugin
```md
插件打出的包包含源码，在eclipse等 IDE 中查看源文件时可以更易读些。
```