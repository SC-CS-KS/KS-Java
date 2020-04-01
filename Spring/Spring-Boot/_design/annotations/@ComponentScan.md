# @ComponentScan

@ComponentScan注解用于配置Spring需要扫描的被组件注解注释的类所在的包。
可以通过配置其basePackages属性或者value属性来配置需要扫描的包路径。
value属性是basePackages的别名。

@Service,@Repository,@Component,@Controller用来定义一个bean
@ComponentScan注解就是用来自动扫描被这些注解标识的类，最终生成ioc容器里的bean。

可以通过设置@ComponentScan　basePackages，includeFilters，excludeFilters 属性
来动态确定自动扫描范围，类型已经不扫描的类型

默认情况下:它扫描所有类型，并且扫描范围是@ComponentScan注解所在配置类包及子包的类


