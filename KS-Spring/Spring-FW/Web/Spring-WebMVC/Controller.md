# Controller

## Controller 加载
* Application 启动类的位置
```md
要将Application类放在最外侧，即包含所有子包。
原因: spring-boot 会自动加载启动类所在包下以及其子包下的所有组件。
```
* 注解使用
```md
在 Controller 层类上面使用的注解是 @RestController 而并非是 @Controller，或者是 @Controller + @ResponseBody；
详解：如果返回 String 或者 json 的话就直接类上用 @RestController；
　　　如果想要页面跳转的话，就使用 @Controller；
　　　如果只有在某方法上返回 json，其他方法跳转页面，则在类上添加 @Controller，
        在需要返回 String 和 json 的方法上添加 @ResponseBody 注解；
```

## Reference
* [SpringMVC Controller 介绍](https://www.cnblogs.com/pophope/p/5619504.html)
