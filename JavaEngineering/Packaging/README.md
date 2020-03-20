# 打包

# 类型

## [jar 包](jar.md)

## [war 包](war.md)

War文件（扩展名为.War,Web Application Archive）包含全部Web应用程序。
在这种情形下，一个Web应用程序被定义为单独的一组文件、类和资源，用户可以对jar文件进行封装，并把它作为小型服务程序（servlet）来访问。

## [Ear 包](Ear)

## 场景
* 何时使用war或者jar文件：
当你的项目在没有完全竣工的时候，不适合使用war文件，因为你的类会由于调试之类的经常改，  
这样来回删除、创建war文件很不爽，最好是你的项目已经完成了，不改了，  
那么就打个war包吧，这个时候一个war文件就相当于一个web应用程序鸟；

而jar文件就是把类和一些相关的资源封装到一个包中，便于程序中引用。

## 总结
Jar、war、EAR、在文件结构上，三者并没有什么不同，它们都采用zip或jar档案文件压缩格式。

但是它们的使用目的有所区别
每一种文件（.jar, .war, .ear）只能由应用服务器（application servers）、  
小型服务程序容器（servlet containers）、EJB容器（EJB containers）等进行处理。  

# [jar命令](cmd-jar.md)

