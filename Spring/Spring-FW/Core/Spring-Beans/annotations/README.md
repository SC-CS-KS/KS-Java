# Spring Bean 注解
* @ComponentScan
```md
@ComponentScan注解用于配置Spring需要扫描的被组件注解注释的类所在的包。
可以通过配置其basePackages属性或者value属性来配置需要扫描的包路径。
value属性是basePackages的别名。
```
* [@Component - 泛指组件，告知 Spring 要为这个类创建 bean](@Component.md)
```md
@Component注解用于标注一个普通的组件类，
它没有明确的业务范围，只是通知Spring被此注解的类需要被纳入到Spring Bean容器中并进行管理。
```
* @Service
```md
@Service注解是@Component的一个延伸（特例），它用于标注业务逻辑类。
与@Component注解一样，被此注解标注的类，会自动被Spring所管理。
```
* @Repository
```md
@Repository注解也是@Component注解的延伸，与@Component注解一样，
被此注解标注的类会被 Spring 自动管理起来，@Repository注解用于标注DAO层的数据持久化类。
```
