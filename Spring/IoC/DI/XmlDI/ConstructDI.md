# 构造函数注入

使用构造函数注入的前提是 Bean 必须提供带参的构造函数。

## 案例

为 “书” 这个类，添加一个带参的构造函数：
```java
public Book(String name, double price) {
    this.name = name;
    this.price = price;
}
```

```xml
<bean id="book2" class="net.deniro.spring4.bean.Book">
    <constructor-arg type="java.lang.String">
        <value>人生的枷锁</value>
    </constructor-arg>
    <constructor-arg type="double">
        <value>35</value>
    </constructor-arg>
</bean>
```

在 <constructor-arg> 的元素中有一个 type 属性，它表示构造函数中参数的类型，  
这是 spring 用来判断配置项与构造函数入参对应关系的 “桥梁”。  

注意：Spring 的配置采用了与元素标签顺序有关的策略，所以上面的多个 <constructor-arg> 位置并会对配置效果产生影响。

### 按索引匹配入参

如果 Book 类定义的构造函数具有多个类型相同入参，那么就需要依赖配置顺序咯，  
如果想定义的更加灵活，那么就可以使用 “ 按索引匹配入参”。  

注意： Spring 底层是采用 Java 反射能力来实现依赖注入的，但 Java 反射无法获知构造函数的参数名，  
所以只能通过入参类型与索引信息来间接地确定构造函数的配置项与入参之间的对应关系。  

假设 Book 类中新增了 “出版社” 属性：
```java
/**
 * 出版社
 */
private String press;

 public Book(String name, String press) {
    this.name = name;
    this.press = press;
}
```

```xml
<bean id="book3" class="net.deniro.spring4.bean.Book">
    <constructor-arg index="0">
        <value>人生的枷锁</value>
    </constructor-arg>
    <constructor-arg index="1">
        <value>上海译文出版社</value>
    </constructor-arg>
</bean>
```

构造函数的第一个参数索引为 0，第二个为 1，以此类推。

## 联合使用类型匹配入参与索引匹配入参

有时需要联合使用 type 和 index 属性才能确定匹配项和构造函数入参的对应关系：

```java
public Book(String name, String press, double price) {
    this.name = name;
    this.press = press;
    this.price = price;
}

public Book(String name, String press, int wordNum) {
    this.name = name;
    this.press = press;
    this.wordNum = wordNum;
}
```

```xml
<bean id="book4" class="net.deniro.spring4.bean.Book">
    <constructor-arg index="0" >
        <value>人生的枷锁</value>
    </constructor-arg>
    <constructor-arg index="1" >
        <value>上海译文出版社</value>
    </constructor-arg>
    <constructor-arg index="2" type="double">
        <value>22.5</value>
    </constructor-arg>
</bean>
```

注意：
对于由于参数数目相同而类型不同所引起的潜在配置歧义问题， Spring 容器可以正确启动但不会给出报错信息，
它将随机采用一个匹配的构造函数来实例化 Bean ，而被选择的构造函数可能并不是我们所希望的 。 
因此，在配置时必须小心谨慎，以避免发生意外。

建议显式地指定 index 与 type，因为这样可以明确指定 Bean 中的一个构造函数。

## 通过自身类型反射匹配入参

如果 Bean 构造函数的入参类型不是基础数据类型，而且入参类型各异，那么可以通过 Java 反射机制获取构造函数的入参类型。

假设在 “书” 中加入了作者实体类：
```java
public Book(String name, Author author) {
    this.name = name;
    this.author = author;
}

/**
 * 作者
 */
private Author author;
```

Author.java：
```java
public class Author {

    public Author(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

```xml
<bean id="author" class="net.deniro.spring4.bean.Author">
    <constructor-arg value="毛姆"/>
</bean>
<bean id="book5" class="net.deniro.spring4.bean.Book">
    <constructor-arg>
        <value>人生的枷锁</value>
    </constructor-arg>
    <constructor-arg>
        <ref bean="author"/>
    </constructor-arg>
</bean>
```

### 循环依赖

实例化构造函数配置的 Bean 的前提条件是：这个 Bean 构造函数的入参对象必须已准备就绪（已实例化）。  
如果存在两个 Bean，它们都使用构造函数的注入方式，并且它们的入参互相引用的话，就会发生循环依赖的问题。

假设 Book 中拥有 Author
```java
public class Book {

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    /**
     * 作者
     */
    private Author author;
...
}
```
而 Author 中拥有 Book：
```java
public class Author {

    public Author(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    private Book book;
...
}
```
```xml
<bean id="author10" class="net.deniro.spring4.bean.Author">
    <constructor-arg index="0" value="毛姆"/>
    <constructor-arg index="1" ref="book10"/>

</bean>
<bean id="book10" class="net.deniro.spring4.bean.Book">
    <constructor-arg index="0" value="人生的枷锁"/>
    <constructor-arg index="1" ref="author10"/>
</bean>
```
这时，启动 Spring 容器，就会抛出以下错误：
```text
Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'author10': Requested bean is currently in creation: Is there an unresolvable circular reference?
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.beforeSingletonCreation(DefaultSingletonBeanRegistry.java:347)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:223)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
    at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveReference(BeanDefinitionValueResolver.java:351)
    ... 62 more
```
因为存在循环依赖的问题。

我们可以把它们的注入方式都改为属性注入方式，就可以解析上述的问题啦。

