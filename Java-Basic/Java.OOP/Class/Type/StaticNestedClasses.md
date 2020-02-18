# 静态嵌套类

* 静态嵌套类
```text
如果一个类要被声明为static，在Java中，只有一种情况，就是静态嵌套类。
```
```text
就是用static修饰的成员嵌套类。

目的
	为了降低包的深度，方便类的使用
	静态内部类适用于包含类当中
		但又不依赖与外在的类
		不用使用外在类的非静态属性和方法，只是为了方便管理类结构而定义

	静态内部类可以单独初始化
	静态成员类可以使用访问控制符，可以使用static修饰，可以是abstract抽象类
	在创建静态内部类的时候，不需要外部类对象的引用
```
## 访问规则

静态内部类跟静态方法一样
	只能访问静态的成员变量和方法
对于public 的 Static Nested Classes 可以用 “new 外部类.内部类()” 的方式直接创建

## 静态嵌套类和内部类

```text
inner class是一个语法糖
	在创建的时候会自动link到outer class，static nested classes则不会

理论上只需要static nested classes就够了，并不需要inner class
	问题的根源在于：C#有委托，而Java没有
```

```text
从字面上看
	一个被称为静态嵌套类，一个被称为内部类
	嵌套就是我跟你没关系，自己可以完全独立存在
	内部就是我是你的一部分，我了解你，我知道你的全部，没有你就没有我
```

## 场景

当外部类需要使用内部类
	而内部类无需外部类资源，并且内部类可以单独创建的时候会考虑采用静态内部类的设计

在进行代码程序测试的时候
	如果在每一个Java源文件中 都设置一个主方法
		那么会出现很多额外的代码
	可以将主方法写入到静态内部类中
		从而不用为每个Java源文件都设置一个类似的主方法

创建线程安全的单例模式
```java
public class Singleton {  
    private static class SingletonHolder {  
        private static final Singleton INSTANCE = new Singleton();  
    }  

    private Singleton (){}  

    public static final Singleton getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
```

## 使用
《Effective Java》第二章所描述的静态内部类builder阐述了如何使用静态内部类，
静态内部类调用外部类的构造函数，来构造外部类。

由于静态内部类可以被单独初始化说有在外部就有以下实现：
```java
public class Outer {
    private String name;
    private int age;

    public static class Builder {
        private String name;
        private int age;

        public Builder(int age) {
            this.age = age;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Outer build() {
            return new Outer(this);
        }
    }

    private Outer(Builder b) {
        this.age = b.age;
        this.name = b.name;
    }
}
```

```java
public Outer getOuter()
{
    Outer outer = new Outer.Builder(2).withName("Yang Liu").build();
    return outer;
}
```

### 总结

如果类的构造器或静态工厂中有多个参数，设计这样类时，最好使用Builder模式，特别是当大多数参数都是可选的时候
如果现在不能确定参数的个数，最好一开始就使用构建器即Builder模式。
