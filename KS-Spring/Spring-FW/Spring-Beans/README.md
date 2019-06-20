# Spring-Beans - org.springframework.beans

```md
Spring 使用工厂模式来管理程序中使用的对象（Bean），Bean 工厂最上层的接口为 BeanFactory，
简单来看，工厂就是根据需要返回相应的 Bean 实例。
```
```java
public interface BeanFactory {
 //... 
 Object getBean(String name);
}
```
```md
在工厂模式中，在工厂的实现类中生成 Bean 返回给调用客户端，
这就要求客户端提供生成自己所需类实例的工厂类，增加客户负担。
Spring 结合控制反转和依赖注入为客户端提供所需的实例，简化了客户端的操作。
```
```java
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
  implements ConfigurableListableBeanFactory, BeanDefinitionRegistry, Serializable {
    /** Map of bean definition objects, keyed by bean name */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>;
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition){ 
    //...
  }
}
```
```md
beanDefinitionMap 作为具体的 Bean 容器，Spring 创建的对象实例保存其中。
客户端需要时，使用工厂的 getBean 方法去试图得到相应的实例，如果实例已存在，则返回该实例；
如果实例不存在，则首先产生相应实例并通过 registerBeanDefinition 方法将其保存在 
beanDefinitionMap 中（Lazy Initialization)，然后返回该实例给客户端。
```
```md
beanDefinitionMap 并不直接保存实例本身，而是将实例封装在 BeanDefinition 对象后进行保存。
BeanDefinition 包含了实例的所有信息。
```
```java
public class BeanDefinition {
 private Object bean;
 private Class<?> beanClass;
 private String beanClassName;
 // Bean 属性字段的初始化值
 private BeanPropertyValues beanPropertyValues;
 //...
}
```
* Spring Bean 工厂生产 Bean 时
```md
1. 先将实例的类型参数保存到 beanClass 和 beanClassName，
    将需要初始化的字段名和值保存到 beanPropertyValues 中，这个过程 Spring 通过控制反转来实现。
2. 生成 bean 实例，并利用反射机制将需要初始化的字段值写入 bean 实例，
    将实例保存在 bean 中，完成 BeanDefinition 的构建。
```
