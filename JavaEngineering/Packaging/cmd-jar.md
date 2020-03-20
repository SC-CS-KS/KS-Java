# jar命令

用法：jar {ctxu}[vfm0Mi] [jar-文件] [manifest-文件] [-C 目录] 文件名 ... 　
选项
	　　-c 创建新的存档
	　　-t 列出存档内容的列表
	　　-x 展开存档中的命名的（或所有的〕文件
	　　-u 更新已存在的存档
	　　-v 生成详细输出到标准输出上
	　　-f 指定存档文件名
	　　-m 包含来自标明文件的标明信息
	　　-0 只存储方式；未用zip压缩格式
	　　-M 不产生所有项的清单（manifest〕文件
	　　-i 为指定的jar文件产生索引信息
	　　-C 改变到指定的目录，并且包含下列文件：　　
		　　如果一个文件名是一个目录，它将被递归处理。 　　
		　　清单（manifest〕文件名和存档文件名都需要被指定，按'm' 和 'f'标志指定的相同顺序。 　　
实例
	将两个class文件存档到一个名为 'classes.jar' 的存档文件中
		jar cvf classes.jar Foo.class Bar.class 　
	用一个存在的清单（manifest）文件 'mymanifest' 将 foo/ 目录下的所有文件存档到一个名为 'classes.jar' 的存档文件中：
		　　jar cvfm classes.jar mymanifest -C foo/ . 　
应用
	创建
		创建JAR文件：jar -cf First.jar -C classes/ .
		使用自定义清单内容创建JAR包：jar -cvfm First.jar a.txt -C classes/ .
	查看
		查看JAR包内容：jar -tf AntTest.jar
	解压缩
		该命令将First.jar解压缩到当前目录下。
			jar xf First.jar