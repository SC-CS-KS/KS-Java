# java.security


* [SecureRandom](http://www.javaweb.cc/help/JavaAPI1.6/java/security/class-use/SecureRandom.html)
```java
public class SecureRandom extends java.util.Random {}
```
```md
操作系统收集了一些随机事件，比如鼠标点击，键盘点击等等，SecureRandom 使用这些随机事件作为种子。

提供加密的强随机数生成器 (RNG)，要求种子必须是不可预知的，产生非确定性输出。
也提供了与实现无关的算法，因此，调用方（应用程序代码）会请求特定的 RNG 算法并将它传回到该算法的 SecureRandom 对象中。
```