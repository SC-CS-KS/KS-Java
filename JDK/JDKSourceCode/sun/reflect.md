# sun.reflect

## annotation
* CallerSensitive
```java
@CallerSensitive
public static Class<?> forName(String className)
            throws ClassNotFoundException {
    return forName0(className, true,
                    ClassLoader.getClassLoader(Reflection.getCallerClass()));
}
```
```md
Reflection.getCallerClass()返回调用此方法的类，忽略关联的框架及其实现。

JVM 将跟踪注解 CallerSensitive，Reflection.getCallerClass() 只有在带有 CallerSensitive 标记的方法中调用，
才能正常返回。
只有特权代码才能使用这个注释，如果代码通过引导类装入器或扩展类装入器装入，则具有特权。
否则会抛出：
java.lang.InternalError: CallerSensitive annotation expected at frame 1
```