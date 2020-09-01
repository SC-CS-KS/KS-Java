## 自定义注解  （java.lang.annotation.Annotation）
```java
定义一个注解
public @interface CustomAnnotationClass
这样创建了一个新的注解类型名为 CustomAnnotationClass。
			
@interface 说明这是一个自定义注解的定义。
之后，你需要为此注解定义一对强制性的属性，保留策略和目标。
还有一些其他属性可以定义，不过这两个是最基本和重要的。
```
```java
自定义的注解设置属性
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE )
public @interface CustomAnnotationClass implements CustomAnnotationMethod

在保留策略中 RUNTIME 告诉编译器这个注解应该被被JVM保留，并且能通过反射在运行时分析。
通过 TYPE 我们又设置该注解可以被使用到任何类的元素上。
```		
```java
定义两个注解的成员
@Retention( RetentionPolicy.RUNTIME )
@Target(ElementType.TYPE)
public @interface CustomAnnotationClass
{
 	public String author() default "danibuiza";
 	public String date();
}
```

以上仅定义了默认值为“danibuiza”的 author 属性和没有默认值的date属性。
应强调所有的方法声明都不能有参数和throw子句。
这个返回值的类型被限制为之前提过的字符串，类，枚举，注解和存储这些类型的数组。

```java
使用刚创建的自定义注解
@CustomAnnotationClass( date = "2014-05-05" )
public class AnnotatedClass
{
...
}
```
```java
在另一种类似的用法中我们可以创建一种注解方法的注解，使用Target METHOD
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
public @interface CustomAnnotationMethod
{
 public String author() default "danibuiza";
 public String date();
 public String description();
}
```
```java
注解可以使用在方法声明上
@CustomAnnotationMethod( date = "2014-06-05", description = "annotated method" )
public String annotatedMethod()
 {
 return "nothing niente";
}
 
@CustomAnnotationMethod( author = "friend of mine", date = "2014-06-05", description = "annotated method" )
public String annotatedMethodFromAFriend()
{
 return "nothing niente";
}
```

有很多其它属性可以用在自定义注解上，  
但是目标 （Target）和 保留策略（Retention Policy）是最重要的两个。  
