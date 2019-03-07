* @Override
```md
第一个 J2SE 标准批注 @Override 使您能够在代码中增加新的可选的编译器检查。
OverrideExample.java:3: method does not override a method from its superclass
	
它在方法中存在表示该方法用于覆盖父类中的方法，如果编译器检测到该方法实际上没有覆盖任何东西，那么将出现编译错误。
经常使用， @Override 可以帮助您避免当方法标记没有完全匹配时  
当多态变为（您可以称之为）“单态” ("unimorphism") 时 — 将得到的细微的 bug。
```
```md	
@Override 批注在实际中有用吗？

只有当您是一个愿意用 @Override 来标记每一个覆盖方法的非常严谨的编程人员时才有用。
我们中有多少人能声称可以达到这种严谨程度？我认为我不能。
可能 IDE 将找到一种方式来鼓励或强制使用 @Override 。
```
* @Deprecated
```md
The @Deprecated 批注看起来非常像 @deprecated 标记，
除了它出现在注释外面的方法或类声明的前面，并且有一个大写字母 "D"。
如果您试图编译带有@Deprecated 批注的代码，javac 将产生警
Note:DeprecatedUser.java uses or overrides a deprecated API.

@Deprecated 批注比 @Override 更有用吗？
我不这么认为。该批注不支持任何参数，因此与 Javadoc 标记不同，
您不能提供一个字符串来说明不赞成使用该方法并推荐一个替代的方法进行使用。 
@Deprecated 批注提供的价值实际上比 @deprecated 标记少。
该批注唯一的优势是您可以通过编程的方式在运行时检测不赞成使用的项目。

因此，传统观点认为应当同时使用 @deprecated 标记和 @Deprecated 标记，一个用于文档，另一个用于运行时反射。

我觉得很不幸 JSR-175 没有选择对 @Deprecated 做更多的工作。至少该批注应当复制 @deprecated 标记的功能，
包含一个字符串说明，从而编译器可以将其与“不赞成使用” (Deprecation) 警告一起输出。

利用额外的参数， @Deprecated 还可以接收 "isError" 布尔类型参数，
以指示是否完全不鼓励使用该方法或者使用它将被认为是编译错误（利用解释错误原因的清楚的自定义说明来进行完善）。
查看 C# 的示例 1 找到属性 [Obsolete] ，该属性正好实现了这一点，它被证明非常有用。
```
* @SuppressWarnings
```md
该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默。
	
一点背景：
J2SE 5.0 为 Java 语言增加了几个新的特性，并且和它们一起增加了许多新的警告并承诺在将来增加更多的警告。
您可以为 "javac" 增加 -Xlint 参数来控制是否报告这些警告（如上面的 @Deprecated 部分所示）。

@SuppressWarnings 批注允许您选择性地取消特定代码段（即，类或方法）中的警告。
其中的想法是当您看到警告时，您将调查它，如果您确定它不是问题，
您就可以添加一个 @SuppressWarnings 批注，以使您不会再看到警告。
虽然它听起来似乎会屏蔽潜在的错误，但实际上它将提高代码安全性，
因为它将防止您对警告无动于衷  您看到的每一个警告都将值得注意。
```
```md
应用

@SuppressWarnings(value={"deprecation"})
	@SuppressWarnings 批注接收一个 "value" 变量，该变量是一个字符串数组，它指示将取消的警告。
  合法字符串的集合随编译器而变化，但在 JDK 上，可以传递给 -Xlint 的是相同的关键字集合（非常方便）。
  并且要求编译器忽略任何它们不能识别的关键字，这在您使用一些不同的编译器时非常方便。
	
  因为 @SuppressWarnings 批注仅接收一个参数，并为该参数使用了特殊的名称 "value"，
  所以您可以选择省略 value=，作为一种方便的缩写：

@SuppressWarnings({"deprecation"})
	您可以将单个数组参数中的任意数量的字符串值传递给批注，并在任何级别上放置批注
	例如，以下示例代码指示将取消整个类的 deprecation 警告，
  而仅在 main() 方法代码内取消 unchecked 和 fallthrough 警告：
	@SuppressWarnings 是否比前两个批注更有用？绝对是这样。
	
  不过，在 JDK 1.5.0 版本中还没有完全支持该批注，如果您用 1.5.0 来尝试它，那么它将类似无操作指令。
  调用 -Xlint:-deprecation 也没有任何效果。
  Sun 没有声明什么时候将增加支持，但它暗示这将在即将推出的一个 dot 版本中实现。
```
* @SafeVarargs
```md
提醒开发者不要用参数做一些不安全的操作，
它是在 Java 1.7 的版本中加入的，它的存在会阻止编译器产生 unchecked 这样的警告。
```
```md
* @FunctionalInterface
```md
这个注解表示一个函数式接口元素，函数式接口是一种只有一个抽象方法（非默认）的接口。
编译器会检查被注解元素，如果不符，就会产生错误。
```