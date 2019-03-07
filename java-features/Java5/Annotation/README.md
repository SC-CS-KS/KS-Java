# Annotation (java.lang.annotation.Annotation)

## [What Is](WhatIs.md)

## Design
* [注解的属性](Property.md)
* APT
```md
Annotation 不会自己生效
	必须由开发者提供相应的代码来提取并处理 Annotation 信息
处理提取和处理 Annotation 的代码统称为 APT（Annotation Processing Tool)。
```
* [内置的注解](Buildin-annotation.md)

* [元注解 meta-annotation]( meta-annotation.md)

## Develop
* 创建
```java
@interface
public @interface TestAnnotation {}
```
* 提取
```md
首先可以通过 Class 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解
然后通过 getAnnotation() 方法来获取 Annotation 对象
	或者是 getAnnotations() 方法
如果获取到的 Annotation 如果不为 null，则就可以调用它们的属性方法了
```
```java
@TestAnnotation()
public class Test {
    public static void main(String[] args) {
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        if ( hasAnnotation ) {
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);

            System.out.println("id:"+testAnnotation.id());
            System.out.println("msg:"+testAnnotation.msg());
        }
    }
}
```
* 实现
```md
Java使用了动态代理对我们定义的注解接口生成了一个代理类
反射比较慢，所以注解使用时也需要谨慎计较时间成本
```

* 自定义注解
```md
	定义一个注解
		public @interface CustomAnnotationClass
			这样创建了一个新的注解类型名为 CustomAnnotationClass。
			关键字：@interface说明这是一个自定义注解的定义。
	之后，你需要为此注解定义一对强制性的属性，保留策略和目标。
		还有一些其他属性可以定义，不过这两个是最基本和重要的。
		自定义的注解设置属性
			@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE )
public @interface CustomAnnotationClass implements CustomAnnotationMethod
				在保留策略中 RUNTIME 告诉编译器这个注解应该被被JVM保留，并且能通过反射在运行时分析。通过 TYPE 我们又设置该注解可以被使用到任何类的元素上。
		定义两个注解的成员
			@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE )
public @interface CustomAnnotationClass
{
 
 public String author() default "danibuiza";
 
 public String date();
 
}
				以上我们仅定义了默认值为“danibuiza”的 author 属性和没有默认值的date属性。
				我们应强调所有的方法声明都不能有参数和throw子句。
				这个返回值的类型被限制为之前提过的字符串，类，枚举，注解和存储这些类型的数组。
		使用刚创建的自定义注解
			@CustomAnnotationClass( date = "2014-05-05" )
public class AnnotatedClass
{
...
}
	在另一种类似的用法中我们可以创建一种注解方法的注解，使用Target METHOD
		@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
public @interface CustomAnnotationMethod
{
 
 public String author() default "danibuiza";
 
 public String date();
 
 public String description();
 
}
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
有很多其它属性可以用在自定义注解上，但是 目标 （Target）和 保留策略（Retention Policy）是最重要的两个。
```

## Utility
* 场景
```md
提供信息给编译器
	编译器可以利用注解来探测错误和警告信息 
编译阶段时的处理
	软件工具可以用来利用注解信息来生成代码、Html文档或者做其它相应处理
运行时的处理
	某些注解可以在程序运行的时候接受代码的提取
```
* 使用注解的知名类库
```md
Junit
	自JUnit4开始，注解被广泛应用，成为Junit的设计的主干之一。
	
		JUnit处理程序通过反射读取类和测试套件，按照在方法上，类上的注解顺序地执行它们
		当然还有一些用来修改测试执行的注解。
		其它注解都用来执行测试，阻止执行，改变执行顺序等等
	
		public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}
			@Test 标记了要进行测试的方法 addition_isCorrect()
 Hibernate ORM
Spring MVC
	Spring是个被广泛使用的Java企业级应用框架。其一项重要的特性就是在Java程序使用依赖注入。
	Spring使用注解作为XML（Spring的早期版本使用的基于XML配置）的一种替代方式。现在两者都是可行的。你可以使用XML文件或者注解配置你的项目。在我看来两者都各有优势。
Findbugs
	这是一个用来测量代码质量，并提供一系列可能提高它的工具。它会根据预定义（或者自定义）的违反规则来检查代码。Findbugs提供一系列注解来允许开发者来改变默认行为。
	它主要使用反射读取代码（和包含的注解）并决定基于它们，应该采取什么行为。
JAXB
	JAXB是一个用来相互转换和映射XML文件与Java对象的类库。实际上，这个类库与标准JRE一起提供，不需要任何额外的下载和配置。可以直接通过引入 java.xml.bind.annotation 包下的类直接使用。
	JAXB使用注解来告知处理程序（或者是JVM）XML文件与代码的相互转化。例如，注解可以用来在代码上标记XML节点，XMl属性，值等等。
```