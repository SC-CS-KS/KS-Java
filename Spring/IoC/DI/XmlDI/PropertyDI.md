# 属性注入


属性注入即通过 setXxx() 方法注入 Bean 的属性值或者依赖对象，  
由于属性注入方式具有可选择性和灵活性高的优点，因此属性注入是实际项目中最常采用的注入方式 。

属性注入要求 Bean 提供一个默认的构造函数，并为需要注入的属性提供对应的 Setter 方法 。  
Spring 先调用 Bean 的默认构造函数实例化 Bean 对象，然后通过反射来调用 Setter 方法注入属性值 。  

## 案例

```java
public class Book {

    /**
     * 书名
     */
    private String name;

    /**
     * 定价
     */
    private double price;

    /**
     * 字数
     */
    private int wordNum;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWordNum(int wordNum) {
        this.wordNum = wordNum;
    }
   ...
}
```
注意：默认构造函数是不带参数的构造函数 。  
Java 语言规定，如果类中没有定义任何构造函数，则 JVM 会自动为其生成一个默认的构造函数。  
反之，如果类中显式定义了构造函数，那么 JVM 就不会为其生成默认的构造函数 。

```xml
<bean id="book" class="net.deniro.spring4.bean.Book">
    <property name="name">
        <value>面纱</value>
    </property>
    <property name="price">
        <value>25.5</value>
    </property>
    <property name="wordNum">
        <value>80000</value>
    </property>
</bean>
```  

注意： Spring 只会检查 Bean 中是否有对应的 Setter 方法，  
至于 Bean 中是否有对应的属性变量则不做要求，因为它底层是采用 Java 的反射方法来设置值的。

* 单元测试
```java
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
Book book= (Book) context.getBean("book");
Assert.assertEquals(book.getName(),"面纱");
```  

## Bean 属性命名规范

Java Bean 属性命名规范是 xxx 的属性，它对应着的是 setXxx() 方法。

一般情况下，Java 的属性变量名都以小写字母起头。但也存在特殊情况 , 比如一些具有特定意义的大写英文缩略词（如 JSON、AJAX等）。 
Java Bean 也允许大写字母起头的属性变量名 , 不过必须满足 " 变量的前两个字母要么全部大写 , 要么全部小写 " 的要求 。  
如 : IDCard 的属性名就是合法的，但 iDCard 属性名则是非法的，虽然 Spring 框架仍然可以正确注入，但不推荐。