# [Matcher Class](https://docs.oracle.com/javase/tutorial/essential/regex/matcher.html)


## Index Methods
```md
索引方法提供有用的索引值，可以精确显示在输入字符串中找到匹配的位置
```
```java
public int start(): Returns the start index of the previous match.
public int start(int group): Returns the start index of the subsequence captured by the given group during the previous match operation.
public int end(): Returns the offset after the last character matched.
public int end(int group): Returns the offset after the last character of the subsequence captured by the given group during the previous match operation.
```

## Study Methods
```md
检查输入字符串并返回指示是否找到模式。
```
```java
public boolean lookingAt(): Attempts to match the input sequence, starting at the beginning of the region, against the pattern.
public boolean find(): Attempts to find the next subsequence of the input sequence that matches the pattern.
public boolean find(int start): Resets this matcher and then attempts to find the next subsequence of the input sequence that matches the pattern, starting at the specified index.
public boolean matches(): Attempts to match the entire region against the pattern.
```

## Replacement Methods
```java
public Matcher appendReplacement(StringBuffer sb, String replacement): Implements a non-terminal append-and-replace step.
public StringBuffer appendTail(StringBuffer sb): Implements a terminal append-and-replace step.
public String replaceAll(String replacement): Replaces every subsequence of the input sequence that matches the pattern with the given replacement string.
public String replaceFirst(String replacement): Replaces the first subsequence of the input sequence that matches the pattern with the given replacement string.
public static String quoteReplacement(String s): Returns a literal replacement String for the specified String. This method produces a String that will work as a literal replacement s in the appendReplacement method of the Matcher class. The String produced will match the sequence of characters in s treated as a literal sequence. Slashes ('\') and dollar signs ('$') will be given no special meaning.
```
