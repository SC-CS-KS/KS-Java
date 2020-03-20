# jar

JAR文件实际上就是ZIP文件，所以可以使用一些常见的解压缩工具来解压缩JAR文件。

Jar文件（扩展名为. Jar，Java Application Archive）包含Java类的普通库、资源（resources）、辅助文件（auxiliary files）等
可以使用WinRAR来创建jar包，这是需要手动添加清单文件。即需要手动建立META-INF/MANIFEST.MF文件，该文件至少包含两行：
```java
Manifest-Version: 1.0
Created-By: 1.6.0_25 (Sun Microsystems Inc.)
```

### META-INF
由1个 main-section 和0到N个 individual-section 组成，而每个section中含有多个attribute组成，  
其中 main-section 中的attribute命名为 main-attribute ,而 individual-section 中的attribute命名为 perentry-attribute 。

各个attribute间使用<CR><LF>作为分隔符（Unix下则使用<LF>作为分隔符，Mac下则使用<CR>作为分隔符）。

individual-section 以名为 Name 的 perentry-attribute 来标识该区域，且作为该区域的起始行。

示例：
```java
	Manifest-Version: 1.0
	Created-By: 1.2 (Sun Microsystems Inc.)
	Sealed: true
	Name: foo/bar/
	Sealed: false
```
main-section 用于描述JAR包的安全、配置信息，和对JAR包内所有包和文件的默认信息。

每个 individual-section 用于描述JAR包中单个包或文件，但不是JAR包中的每个包和文件都必须配置 individual-section ，  
但对于需要被签名的文件就必须配置对应的 individual-section 了。