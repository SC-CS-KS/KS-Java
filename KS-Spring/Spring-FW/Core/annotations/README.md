# annotations

## Spring DI注解
* @DependsOn
```md
@DependsOn注解可以配置Spring IoC容器在初始化一个Bean之前，先初始化其他的Bean对象。
```
* [@Bean](@Bean.md)
```md
@Bean注解主要的作用是告知Spring，被此注解所标注的类将需要纳入到Bean管理工厂中。
```
* @Scope
```md
@Scope注解可以用来定义@Component标注的类的作用范围以及@Bean所标记的类的作用范围。
@Scope所限定的作用范围有：singleton、prototype、request、session、globalSession或者其他的自定义范围。
这里以prototype为例子进行讲解。
当一个Spring Bean被声明为prototype（原型模式）时，在每次需要使用到该类的时候，Spring IoC容器都会初始化一个新的改类的实例。
在定义一个Bean时，可以设置Bean的scope属性为prototype：scope=“prototype”,也可以使用@Scope注解设置：
@Scope(value=ConfigurableBeanFactory.SCOPE_PROPTOTYPE)
```
```md
@Scope 单例模式
当@Scope的作用范围设置成Singleton时，被此注解所标注的类只会被Spring IoC容器初始化一次。
在默认情况下，Spring IoC容器所初始化的类实例都为singleton。
同样的原理，此情形也有两种配置方式。
```
## 容器配置注解
* @Autowired
* @Primary
* @PostConstruct与@PreDestroy
* @Qualifier

## Reference
* [Spring 注解：全家桶](https://www.toutiao.com/i6696955994666172940/)
