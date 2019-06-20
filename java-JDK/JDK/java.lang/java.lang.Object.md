# java.lang.Object

```java
public class Object {}
```

* private static native void registerNatives();
```java
    static {
        registerNatives();
    }
```
```md
使用 registerNatives 方式来注册本地函数。
```

* public final native Class<?> getClass();
```md
获取该类运行时的类对象。
```
* public native int hashCode();
```md
返回对象的散列码。

* hashCode 要求
1. 在程序运行时期间，只要对象的（字段的）变化不会影响equals方法的决策结果，
  那么，在这个期间，无论调用多少次hashCode，都必须返回同一个散列码。
2. 通过equals调用返回true 的2个对象的hashCode一定一样。
3. 通过equasl返回false 的2个对象的散列码不需要不同，
  也就是他们的hashCode方法的返回值允许出现相同的情况。

* 推论
1. 两个对象相等，其 hashCode 一定相同
2. 两个对象不相等，其 hashCode 有可能相同
3. hashCode 相同的两个对象，不一定相等
4. hashCode 不相同的两个对象，一定不相等

* hashCode 编写指导
1. 不同对象的hash码应该尽量不同，避免hash冲突，也就是算法获得的元素要尽量均匀分布。
2. hash 值是一个 int 类型，在Java中占用 4 个字节，也就是 232 次方，要避免溢出。
3. 在 JDK 的 Integer类，Float 类，String 类等都重写了 hashCode 方法，
  我们自定义对象也可以参考这些类来写。

* 注意
对于 Map 集合，我们可以选取Java中的基本类型 和 String 作为 key，
因为它们都按照规范重写了 equals 方法和 hashCode 方法。
但是如果你用自定义对象作为 key，那么一定要覆写 equals 方法和 hashCode 方法，不然会有意想不到的错误产生。
```
* public boolean equals(Object obj) {}
```java
public boolean equals(Object obj) {
        return (this == obj);
}
```
* Java规范
```md
对于任何非空引用，equals() 必须满足：
1. 自反性
  x.equals(x) 都应返回 true。
2. 对称性
  当且仅当 y.equals(x) 返回 true 时，x.equals(y) 才应返回 true。 
3. 传递性
  如果 x.equals(y) 返回 true，并且 y.equals(z) 返回 true，
  那么 x.equals(z) 应返回 true。
4. 一致性
  多次调用 x.equals(y) 始终返回 true 或始终返回 false，
  前提是对象上 equals 比较中所用的信息没有被修改。
5. x.equals(null) 都应返回 false。
```

* protected native Object clone() throws CloneNotSupportedException;
```md
实现了浅拷贝。
```
* public String toString() {}
```java
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```
```md
getClass().getName()是返回对象的全类名（包含包名）
Integer.toHexString(hashCode()) 是以16进制无符号整数形式返回此哈希码的字符串表示形式。

打印某个对象时，默认是调用 toString 方法。
```

* public final native void notify();
* public final native void notifyAll();
* public final native void wait(long timeout) throws InterruptedException;
*  public final void wait(long timeout, int nanos) throws InterruptedException {}
```java
    public final void wait(long timeout, int nanos) throws InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException(
                                "nanosecond timeout value out of range");
        }

        if (nanos > 0) {
            timeout++;
        }

        wait(timeout);
    }
```
* public final void wait() throws InterruptedException {}
```java
    public final void wait() throws InterruptedException {
        wait(0);
    }
```
```md
notify()/notifyAll()/wait() 用于多线程之间的通信方法。
```
* protected void finalize() throws Throwable { }