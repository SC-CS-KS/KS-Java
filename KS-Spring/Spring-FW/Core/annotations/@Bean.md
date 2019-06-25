# @Bean
```md
@Bean注解告诉 Spring这个方法将会返回一个对象，这个对象要注册为 Spring应用上下文中的 bean。
通常方法体中包含了最终产生bean实例的逻辑。

@Bean注解 通常是在标有该注解的方法中定义产生这个bean的逻辑。

相比于@Component， @Bean的用途则更加灵活。
Bean 比 Component的自定义性更强。可以实现一些Component实现不了的自定义加载类。
```
```java
public class WireThirdLibClass {
    @Bean
    public ThirdLibClass getThirdLibClass() {
        return new ThirdLibClass();
    }
}
```
