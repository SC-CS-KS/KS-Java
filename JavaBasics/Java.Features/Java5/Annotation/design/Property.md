```md
注解只有成员变量(属性)，没有方法
```
## 定义
```md
成员变量在注解的定义中以“无形参的方法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
```
## 类型
```md
属性类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组。
```
## 初始化
```md
注解中属性可以有默认值，默认值需要用 default 关键值指定
```
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    public int id() default -1;
    public String msg() default "Hi";
}

	@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

    int id();

    String msg();

}
```
```md
		定义了 TestAnnotation 这个注解中拥有 id 和 msg 两个属性
		在使用的时候，我们应该给它们进行赋值。
```
## 赋值
```md
方式是在注解的括号内以 value=”” 形式，多个属性之前用 ，隔开。
@TestAnnotation(id=3,msg="hello annotation")
public class Test {

}
```
```md
注解内仅仅只有一个名字为 value 的属性时，应用这个注解时可以直接接属性值填写到括号内。
public @interface Check {
    String value();
}
@Check("hi")
int a;
@Check(value="hi")
int a;
```
```md
一个注解没有任何属性 public @interface Perform {}，
那么在应用这个注解的时候，括号都可以省略 @Perform。
public void testMethod(){}
```