# Ear

Ear文件（扩展名为.Ear,Enterprise Application Archive）包含全部企业应用程序。
在这种情形下，一个企业应用程序被定义为多个jar文件、资源、类和Web应用程序的集合。

EAR文件包括整个项目，内含多个ejb module（jar文件）和web module（war文件）

EAR文件的生成可以使用winrar zip压缩方式或者jar命令。
先打包成war和jar,并写好application.xml，放到META-INF目录下，
然后 jar   cf   your_application.ear   your_war.war   your_jar.jar   META-INF/application.xml，  
打包，我这假设都在当前目录下     可以用    jar   xf   your_application.ear解压  

