# Flags
```md
Pattern类定义了一个备用编译方法，它接受一组影响模式匹配方式的标志。
flags参数是一个位掩码，可能包含以下任何公共静态字段。
```
```java
public static final int UNIX_LINES = 0x01; // Enables Unix lines mode
启用UNIX行模式。
在此模式下，只有'\n'行终止符在 . ，^和$的行为中被识别。
UNIX行模式也可以通过嵌入式标志表达式（？d）启用。

public static final int CASE_INSENSITIVE = 0x02;
启用不区分大小写的匹配。而默认情况下，不区分大小写的匹配假定只匹配US-ASCII字符集中的字符。
通过将 UNICODE_CASE 标志与此标志一起指定，可以启用 Unicode 感知的不区分大小写的匹配。
也可以通过嵌入式标志表达式（？i）启用不区分大小写的匹配。
指定此标志可能会略微降低性能。

public static final int COMMENTS = 0x04; //Permits whitespace and comments in pattern.
允许模式中的空格和注释。
在此模式下，将忽略空格，并忽略以＃开头的嵌入式注释，直到行结束。
也可以通过嵌入式标志表达式（？x）启用注释模式。

public static final int MULTILINE = 0x08;//Enables multiline mode.
在多行模式中，表达式^和$分别在行终止符之后或之前或输入序列的末尾匹配。
而默认情况下，这些表达式仅在整个输入序列的开头和结尾处匹配。
也可以通过嵌入式标志表达式（？m）启用多行模式。

public static final int LITERAL = 0x10; //Enables literal parsing of the pattern.
启用模式的文字解析。
指定此标志后，指定模式的输入字符串将被视为文字字符序列。
输入序列中的元字符或转义序列将没有特殊含义。
当与此标志一起使用时，标志 CASE_INSENSITIVE 和 UNICODE_CASE保 持对匹配的影响。其他标志变得多余。
没有用于启用文字解析的嵌入标志字符。

public static final int DOTALL = 0x20; //Enables dotall mode.
在dotall模式中，表达式 . 匹配任何字符，包括行终止符。而默认情况下，此表达式与行终止符不匹配。
也可以通过嵌入式标志表达式（？s）启用Dotall模式。（s是“单行”模式的助记符，这是在Perl中调用的。）

public static final int UNICODE_CASE = 0x40; //Enables Unicode-aware case folding.
启用支持 Unicode 的案例折叠。
指定此标志后，由 CASE_INSENSITIVE 标志启用时，不区分大小写的匹配将以与 Unicode 标准一致的方式完成。
默认情况下，不区分大小写的匹配假定只匹配US-ASCII字符集中的字符。
也可以通过嵌入式标志表达式（？u）启用支持Unicode的案例折叠。
指定此标志可能会导致性能下降。

public static final int CANON_EQ = 0x80; //Enables canonical equivalence.
启用规范等效。
指定此标志时，如果且仅当它们的完整规范分解匹配时，将认为两个字符匹配。
例如，当指定此标志时，表达式“a \ u030A”将匹配字符串“\ u00E5”。
默认情况下，匹配不会将规范等效考虑在内。
指定此标志可能会导致性能下降。

public static final int UNICODE_CHARACTER_CLASS = 0x100; //Enables the Unicode version of <i>Predefined character classes</i> and <i>POSIX character classes</i>.
```
```md
Constant	Equivalent Embedded Flag Expression
Pattern.CANON_EQ	None
Pattern.CASE_INSENSITIVE	(?i)
Pattern.COMMENTS	(?x)
Pattern.MULTILINE	(?m)
Pattern.DOTALL	(?s)
Pattern.LITERAL	None
Pattern.UNICODE_CASE	(?u)
Pattern.UNIX_LINES	(?d)
```
* MULTILINE vs. DOTALL
```md
使用DOTALL，整个String被视为一个正则表达式字符串。^仅匹配String的开头，$仅匹配String的最后一端。
使用MULTILINE，每行都有自己的^和$。
```



