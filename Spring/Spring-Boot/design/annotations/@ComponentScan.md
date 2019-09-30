# @ComponentScan
```md
@Service,@Repository,@Component,@Controller用来定义一个bean
@ComponentScan注解就是用来自动扫描被这些注解标识的类，最终生成ioc容器里的bean。
```
```md
可以通过设置@ComponentScan　basePackages，includeFilters，excludeFilters 属性
来动态确定自动扫描范围，类型已经不扫描的类型
```
```md
默认情况下:它扫描所有类型，并且扫描范围是@ComponentScan注解所在配置类包及子包的类
```