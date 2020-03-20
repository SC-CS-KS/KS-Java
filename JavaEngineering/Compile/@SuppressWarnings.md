# @SuppressWarnings
@SuppressWarnings 批注允许您选择性地取消特定代码段（即，类或方法）中的警告
	其中的想法是当您看到警告时，您将调查它
		如果您确定它不是问题，您就可以添加一个 @SuppressWarnings 批注，以使您不会再看到警告
	虽然它听起来似乎会屏蔽潜在的错误，但实际上它将提高代码安全性
		因为它将防止您对警告无动于衷 — 您看到的每一个警告都将值得注意。 

## 背景
	J2SE 5.0 为 Java 语言增加了几个新的特性
		，并且和它们一起增加了许多新的警告并承诺在将来增加更多的警告
	您可以为 "javac" 增加 -Xlint 参数来控制是否报告这些警告（如@Deprecated）。 

## -Xlint
默认情况下，Sun 编译器以简单的两行的形式输出警告。
通过添加 -Xlint:keyword 标记（例如 -Xlint:finally），您可以获得关键字类型错误的完整说明。
通过在关键字前面添加一个破折号，写为 -Xlint:-keyword，您可以取消警告。

关键字         用途 
deprecation   使用了不赞成使用的类或方法时的警告 
unchecked     执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型。 
fallthrough   当 Switch 程序块直接通往下一种情况而没有 Break 时的警告。 
path          在类路径、源文件路径等中有不存在的路径时的警告。  
serial        当在可序列化的类上缺少 serialVersionUID 定义时的警告。  
finally       任何 finally 子句不能正常完成时的警告。 
all           关于以上所有情况的警告。 


## 参数
仅接收一个参数，并为该参数使用了特殊的名称 "value"，所以您可以选择省略 value=，作为一种方便的缩写