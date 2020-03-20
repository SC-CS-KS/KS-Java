# Pattern Class


## Method
* matches(String, CharSequence) 
* split(String) 
```java
public class SplitDemo {
 
    private static final String REGEX = ":";
    private static final String INPUT =
        "one:two:three:four:five";
     
    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        String[] items = p.split(INPUT);
        for(String s : items) {
            System.out.println(s);
        }
    }
}
```
* public static String quote(String s) 返回指定String的文字模式String。
* public String toString() 返回此模式的String表示形式。

## Pattern Method Equivalents in java.lang.String
* public boolean matches(String regex):
* public String[] split(String regex, int limit)
* public String[] split(String regex)
* public String replace(CharSequence target,CharSequence replacement)
