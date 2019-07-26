# Spring Boot注解

* [@SpringBootApplication](@SpringBootApplication.md)
* [@SpringBootConfiguration](@SpringBootConfiguration.md)
* [@EnableAutoConfiguration](@EnableAutoConfiguration.md)

* @ConditionalOnClass与@ConditionalOnMissingClass
* @ConditionalOnBean与@ConditionalOnMissingBean
* @ConditionalOnProperty
* @ConditionalOnResource
* @ConditionalOnWebApplication与@ConditionalOnNotWebApplication
* @ConditionalExpression
* @Conditional

* [@Configuration](@Configuration.md)
* [@ConfigurationProperties](@ConfigurationProperties.md)
* [@RestController - 用于标注控制层组件]()

* @Import 
* @Profile

* @Mapper
* @MapperScan
```md
@MapperScan注解，指定basePackages，扫描mybatis Mapper接口类，
另外一种方式是用@Mapper注解，其实这两种方法扫描配置用的是一个地方，只是扫描入口不同。
```
```md
@MapperScan是根据其注解上MapperScannerRegistrar进行自动配置的，最终调用的自动配置代码和下面的代码一致
```
```md
@Mapper自动配置的程序入口是 MybatisAutoConfiguration类的最下面，
位置在mybatis-spring-boot-starter包下面的mybatis-spring-boot-autoconfigure，
根据名字可以看出，这个是自动配置，这个地方用到了spring-boot的自动配置相关注解
```