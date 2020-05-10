# Annotation (java.lang.annotation.Annotation)

## [What Is](WhatIs.md)

## [规范](Std.md)

## Design

* [注解的属性](Property.md)

* APT

Annotation 不会自己生效，必须由开发者提供相应的代码来提取并处理 Annotation 信息。
处理提取和处理 Annotation 的代码统称为 APT（Annotation Processing Tool)。

### 创建

```java
@interface
public @interface TestAnnotation {
}
```

### 实现

Java 使用了动态代理对我们定义的注解接口生成了一个代理类。  
反射比较慢，所以注解使用时也需要谨慎计较时间成本。  

### 提取

首先可以通过 Class 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解。
然后通过 getAnnotation() 方法来获取 Annotation 对象或者是 getAnnotations() 方法。
如果获取到的 Annotation 如果不为 null，则就可以调用它们的属性方法了。

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

## 分类
* 标识注解

注解类可以没有成员，没有成员的注解称为标识注解  

### 按照运行机制分为 

* 源码注解 注解只在源码中存在，编译成.class文件就不存在了 
* 编译时注解 注解在源码和.class文件中都存在（如：JDK内置系统注解） 
* 运行时注解 在运行阶段还起作用，甚至会影响运行逻辑的注解（如：Spring中@Autowried） 

### 按照来源分为   

* [内置注解](Buildin-annotation.md)
* [元注解 meta-annotation](meta-annotation.md)
* [自定义注解](UD-annotation.md)
* 第三方注解


## 场景

提供信息给编译器
	编译器可以利用注解来探测错误和警告信息 
编译阶段时的处理
	软件工具可以用来利用注解信息来生成代码、Html文档或者做其它相应处理
运行时的处理
	某些注解可以在程序运行的时候接受代码的提取
  