# Annotation (java.lang.annotation.Annotation)

## [What Is](WhatIs.md)

## Design

```md
Java 使用了动态代理对我们定义的注解接口生成了一个代理类。
反射比较慢，所以注解使用时也需要谨慎计较时间成本。
```
* 提取
```md
首先可以通过 Class 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解。
然后通过 getAnnotation() 方法来获取 Annotation 对象或者是 getAnnotations() 方法。
如果获取到的 Annotation 如果不为 null，则就可以调用它们的属性方法了。
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

* [注解的属性](Property.md)

* APT
```md
Annotation 不会自己生效，必须由开发者提供相应的代码来提取并处理 Annotation 信息。
处理提取和处理 Annotation 的代码统称为 APT（Annotation Processing Tool)。
```
* [内置注解](Buildin-annotation.md)

* [元注解 meta-annotation](meta-annotation.md)

## Develop
* [自定义注解](UD-annotation.md)

## Utility
### 场景
```md
提供信息给编译器
	编译器可以利用注解来探测错误和警告信息 
编译阶段时的处理
	软件工具可以用来利用注解信息来生成代码、Html文档或者做其它相应处理
运行时的处理
	某些注解可以在程序运行的时候接受代码的提取
```
### 使用注解的知名类库
* Junit
```md
自JUnit4开始，注解被广泛应用，成为Junit的设计的主干之一。
JUnit处理程序通过反射读取类和测试套件，按照在方法上，类上的注解顺序地执行它们
当然还有一些用来修改测试执行的注解。
其它注解都用来执行测试，阻止执行，改变执行顺序等等
```
```java	
public class ExampleUnitTest {
  @Test
  public void addition_isCorrect() throws Exception {
    assertEquals(4, 2 + 2);
  }
}
```
```md
@Test 标记了要进行测试的方法 addition_isCorrect()
```
* Hibernate ORM
* Spring MVC
```md
Spring使用注解作为XML（Spring的早期版本使用的基于XML配置）的一种替代方式。
现在两者都是可行的，可以使用XML文件或者注解配置你的项目，在我看来两者都各有优势。
```
* Findbugs
```md
Findbugs提供一系列注解来允许开发者来改变默认行为。
它主要使用反射读取代码（和包含的注解）并决定基于它们，应该采取什么行为。
```
* JAXB
```md
JAXB是一个用来相互转换和映射XML文件与Java对象的类库。
实际上，这个类库与标准JRE一起提供，不需要任何额外的下载和配置。
可以直接通过引入 java.xml.bind.annotation 包下的类直接使用。

JAXB使用注解来告知处理程序（或者是JVM）XML文件与代码的相互转化。
例如，注解可以用来在代码上标记XML节点，XMl属性，值等等。
```