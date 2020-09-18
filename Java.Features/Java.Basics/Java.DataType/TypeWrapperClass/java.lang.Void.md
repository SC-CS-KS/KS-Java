# java.lang.Void

```java
package java.lang;

/**
 * The {@code Void} class is an uninstantiable placeholder class to hold a
 * reference to the {@code Class} object representing the Java keyword
 * void.
 *
 * @author  unascribed
 * @since   JDK1.1
 */
public final
class Void {

    /**
     * The {@code Class} object representing the pseudo-type corresponding to
     * the keyword {@code void}.
     */
    @SuppressWarnings("unchecked")
    public static final Class<Void> TYPE = (Class<Void>) Class.getPrimitiveClass("void");

    /*
     * The Void class cannot be instantiated.
     */
    private Void() {}
}
```

Void类是一个不可实例化的占位符类，如果方法返回值是Void类型，那么该方法只能返回null类型。


## 场景

### 泛型

```java
Future<Void> f = pool.submit(new Callable() {
    @Override
    public Void call() throws Exception {
        ......
        return null;
    }
        
});
```

比如使用 Callable接口，该接口必须返回一个值，但实际执行后没有需要返回的数据。 
这时可以使用Void类型作为返回类型。

### 反射

```java
public class Test {
    public void hello() { }
    public static void main(String args[]) {
        for (Method method : Test.class.getMethods()) {
            if (method.getReturnType().equals(Void.TYPE)) {
                System.out.println(method.getName());
            }
        }
    }
}
```

通过反射获取所有返回值为void的方法。


***在泛型出现之前，Void一般用于反射之中。***

##  vs void 关键字

java.lang.Void 是 void 关键字的包装类。

Void作为函数的返回结果表示函数返回null(除了null不能返回其它类型)。
void是Java中的一个关键字，表示函数没有返回结果。


