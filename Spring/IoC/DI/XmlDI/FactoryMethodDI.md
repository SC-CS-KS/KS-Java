# 工厂方法注入

工厂方法是被经常使用到的设计模式，它也是控制反转与单实例设计思想的主要实现方式。  
它已经成为 Spring 框架的底层基础设施的一部分。  

## 非静态工厂方法

非静态，即必须实例化工厂类之后，才能调用其方法。
```java
public class BookFactory {

    public Book create() {
        return new Book("面纱", "重庆出版社");
    }
}
```
工厂类负责创建目标类实例，它对外屏蔽了目标类的实例化细节，返回的类型一般是接口或抽象类的形式。
```xml
<bean id="bookFactory" class="net.deniro.spring4.bean.BookFactory"/>
<!-- factory-bean：指定工厂类；factory-method：指定工厂方法-->
<bean id="book11" factory-bean="bookFactory" factory-method="create"/>
```

## 静态工厂方法

很多工厂方法是以静态的方式实现的，因为更易使用，直接调用方法就可以啦。

```xml
<!--class：指定工厂类； factory-method：指定静态工厂方法 -->
<bean id="book12" class="net.deniro.spring4.bean.BookFactory" factory-method="createBook"/>
```

