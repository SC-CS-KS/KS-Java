# [java.util.regex](https://docs.oracle.com/javase/tutorial/essential/regex/index.html)
## 类分层结构
```md
java.lang.Object
  java.util.regex.Matcher (implements java.util.regex.MatchResult)
  java.util.regex.Pattern (implements java.io.Serializable)
  java.lang.Throwable (implements java.io.Serializable)
    java.lang.Exception
      java.lang.RuntimeException
        java.lang.IllegalArgumentException
          java.util.regex.PatternSyntaxException
```
## [Pattern](Pattern.md)
```md
Pattern 对象是一个正则表达式的编译表示。
Pattern 类没有公共构造方法。
要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。
该方法接受一个正则表达式作为它的第一个参数。
```
* [Flags](Flags.md)

## [Matcher](Matcher.md)
```md
Matcher 对象是对输入字符串进行解释和匹配操作的引擎。
与Pattern 类一样，Matcher 也没有公共构造方法。
你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
```
## [PatternSyntaxException](https://docs.oracle.com/javase/tutorial/essential/regex/pse.html)
```md
PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
```

## [Capturing Groups 捕获组](https://docs.oracle.com/javase/tutorial/essential/regex/groups.html)

## [Unicode Support](https://docs.oracle.com/javase/tutorial/essential/regex/unicode.html)

## Develop
* [Java Tutorials Code Sample – RegexTestHarness.java](https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/essential/regex/examples/RegexTestHarness.java)
```java
public class RegexTestHarness {
 
    public static void main(String[] args){
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {
 
            Pattern pattern = 
            Pattern.compile(console.readLine("%nEnter your regex: "));
 
            Matcher matcher = 
            pattern.matcher(console.readLine("Enter input string to search: "));
 
            boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if(!found){
                console.format("No match found.%n");
            }
        }
    }
}

```

## Resources
* [Java 正则表达式](http://www.runoob.com/java/java-regular-expressions.html)