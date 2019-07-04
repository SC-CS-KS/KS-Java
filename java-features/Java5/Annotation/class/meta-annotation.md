#  meta-annotation
```md
J2SE5.0版本在 java.lang.annotation提供了四种元注解，专门注解其他的注解（注解的注解）
```
## @Documented
```md
作用是能够将注解中的元素包含到 Javadoc 中去
```
## @Retention 
```md
表明什么时候使用该注解，定义注解的生命周期。
```
### RetentionPolicy.SOURCE
```md
在编译阶段丢弃，这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。
@Override, @SuppressWarnings都属于这类注解。
```
### RetentionPolicy.CLASS
```md
在类加载的时候丢弃，在字节码文件的处理中有用，注解默认使用这种方式。
```	
### RetentionPolicy.RUNTIME
```md
始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。
我们自定义的注解通常使用这种方式
```
## @Target
```md
注解用于什么地方，类比到标签，原本标签是你想张贴到哪个地方就到哪个地方。
但是因为 @Target 的存在，它张贴的地方就非常具体了，
当一个注解被 @Target 注解时，这个注解就被限定了运用的场景。
```
```md
可用的参数
ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
ElementType.FIELD 可以给属性进行注解
ElementType.METHOD 可以给方法进行注解
ElementType.PARAMETER 可以给一个方法内的参数进行注解
ElementType.CONSTRUCTOR 可以给构造方法进行注解
ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
ElementType.PACKAGE 可以给一个包进行注解
```
## @Inherited
```md
但是它并不是说注解本身可以继承，而是说如果一个超类被 @Inherited 注解过的注解进行注解的话
那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解。
```
```java
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Test {}

@Test
public class A {}

public class B extends A {}
```
```md
解 Test 被 @Inherited 修饰，之后类 A 被 Test 注解，类 B 继承 A,类 B 也拥有 Test 这个注解。
```
## @Repeatable
```md
@Repeatable 是 Java 1.8 才加进来的，是可重复的意思。
什么样的注解会多次应用呢？通常是注解的值可以同时取多个。
```
```java
@interface Persons {
    Person[]  value();
}

@Repeatable(Persons.class)
@interface Person{
    String role default "";
}

@Person(role="artist")
@Person(role="coder")
@Person(role="PM")
public class SuperMan{

}
```
```md
@Repeatable 注解了 Person，而 @Repeatable 后面括号中的类相当于一个容器注解。
什么是容器注解呢？就是用来存放其它注解的地方。
```