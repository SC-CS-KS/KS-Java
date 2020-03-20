# JDK
## JDK1.8目录结构
```sh
$ ls -l jdk
bin
COPYRIGHT
db
include
javafx-src.zip
jre
lib
LICENSE
man
README.html
release
src.zip
THIRDPARTYLICENSEREADME-JAVAFX.txt
THIRDPARTYLICENSEREADME.txt
```
```md
bin目录：
  Java工具的可执行文件，包括: java、Java编译器javac、反编译.class文件javap、密钥管理工具keytool、Java文档工具javadoc等。
COPYRIGHT文件：版权信息。
db目录：Java实现的数据库。
include目录：.h头文件，C语言开发时用到的头文件。比如jni.h是开发jni程序时必须引用的头文件。
lib目录： Java类库，我们经常看到的dt.jar和tools.jar就在这个目录下。
src.zip文件：Java类库源码，包括了rt.jar库中的关键部分；除了Java类库，还包含了启动器（launcher）的源码（C语言实现）。
jre目录：Java运行环境。
```
* dt.jar
```md
包含了Swing包，是运行环境的类库。目前的发展趋势是Java越来越少的用作GUI开发，所以这个类库基本不会用到了。
```
* tools.jar
```md
是工具类库，bin目录下的可执行程序，好多都会用到这个类库。比如javac[.exe]，javadoc[.exe]等。
```
```md
平时我们经常会将这两个文件配置到CLASSPATH的当前目录（.）后面。
CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

原因就是有些可执行程序在运行时是依赖这些类库的，比如javac[.exe]就依赖tools.jar类库的javac包。
```
### JRE目录结构
```sh
$ ls -l jre
bin
COPYRIGHT
lib
LICENSE
plugin
README
THIRDPARTYLICENSEREADME-JAVAFX.txt
THIRDPARTYLICENSEREADME.txt
Welcome.html
```
```md
bin目录：包含了java运行所需要的可执行文件，比如java[.exe]
lib目录：包含了运行时依赖的java类库和动态链接库（.so或.dll或.dylib）。
```

#### jre/lib
* amd64目录
```md
包含了程序运行所需的动态链接库，在amd64/server目录下，可以找到JVM库：libjvm.so。
```
* rt.jar
```md
是java运行时类库，是我们用到最多的基础类库，包括java.lang，java.io，java.net，java.util等。
```
```md
java.lang：
  Java语言包，这个包下的文件不需要显式import。
  包括：Object类，数据类型相关的类（String，Long，Byte），Class类，线程相关类Thread，异常类Throwable，等。
java.io：
  I/O操作相关的类。包括：文件类File，FileReader，FileWriter，输入输出流InputStream/OutputStream，等。
java.net：
  网络相关类。包括：http连接类HttpURLConnection，socket类，等。
java.util：
  工具类。包括：数据结构相关的类ArrayList、Hashmap，日期类Date，随机数类Random，等。
```