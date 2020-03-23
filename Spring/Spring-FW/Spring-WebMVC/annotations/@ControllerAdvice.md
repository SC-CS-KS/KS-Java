# @ControllerAdvice
```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ControllerAdvice {
    @AliasFor("basePackages")
    String[] value() default {};

    @AliasFor("value")
    String[] basePackages() default {};

    Class<?>[] basePackageClasses() default {};

    Class<?>[] assignableTypes() default {};

    Class<? extends Annotation>[] annotations() default {};
}
```

@ControllerAdvice是@Component注解的一个延伸注解，
因为@ControllerAdvice被元注解@Component标记，所以它也是可以被组件扫描扫到并放入Spring容器的。

@ControllerAdvice抽象级别是用于对Controller进行“切面”环绕的，而具体的业务织入方式则是通过结合其他的注解来实现的。
不过@ControllerAdvice并不是使用AOP的方式来织入业务逻辑的，而是Spring内置对其各个逻辑的织入方式进行了内置支持。

## 用法

@ControllerAdvice的用法基本是将其声明在某个bean上，然后在该bean的方法上使用其他的注解来指定不同的织入逻辑。

* 是一个增强的 Controller，可以实现三个方面的功能：

全局异常处理
全局数据绑定
全局数据预处理


结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常，从而达到不同类型的异常区别处理的目的
结合方法型注解@InitBinder，用于request中自定义参数解析方式进行注册，从而达到自定义指定格式参数的目的
结合方法型注解@ModelAttribute，表示其标注的方法将会在目标Controller方法执行之前执行

@ModelAttribute方法会先于控制器里执行，@ExceptionHandler方法优先级会低于控制器里的。
仔细想想就能明白，局部的要优先于全局的。

首先，我们需要定义一个被@ControllerAdvice所标注的类，在该类中，
定义一个用于处理具体异常的方法，并使用@ExceptionHandler注解进行标记。

此外，在有必要的时候，可以使用@InitBinder在类中进行全局的配置，还可以使用@ModelAttribute配置与视图相关的参数。
使用@ControllerAdvice注解，就可以快速的创建统一的，自定义的异常处理类。

## 全局异常处理 @ExceptionHandler
> 参考 Java 基础 - 异常

## 全局数据绑定

全局数据绑定功能可以用来做一些初始化的数据操作，可以将一些公共的数据定义在添加了 @ControllerAdvice 注解的类中，
这样，在每一个 Controller 的接口中，就都能够访问导致这些数据。

```java
@ControllerAdvice
public class MyGlobalExceptionHandler {
    @ModelAttribute(name = "md")
    public Map<String,Object> myData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 99);
        map.put("gender", "男");
        return map;
    }
}
```

使用 @ModelAttribute 注解标记该方法的返回数据是一个全局数据，
默认情况下，这个全局数据的 key 就是返回的变量名，value 就是方法返回值，
当然开发者可以通过 @ModelAttribute 注解的 name 属性去重新指定 key。

```java
在任何一个Controller 的接口中，都可以获取到这里定义的数据：
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        Map<String, Object> map = model.asMap();
        System.out.println(map);
        int i = 1 / 0;
        return "hello controller advice";
}
```

@ModelAttribute：在Model上设置的值，对于所有被 @RequestMapping 注解的方法中，都可以通过 ModelMap 获取

## 全局数据预处理
```java
考虑有两个实体类，Book 和 Author，分别定义如下：
public class Book {
    private String name;
    private Long price;
    //getter/setter
}

public class Author {
    private String name;
    private Integer age;
    //getter/setter
}
```
```java
此时，如果我定义一个数据添加接口，如下：
@PostMapping("/book")
public void addBook(Book book, Author author) {
    System.out.println(book);
    System.out.println(author);
}
```
```md
这个时候，添加操作就会有问题，因为两个实体类都有一个 name 属性，从前端传递时 ，无法区分。
此时，通过 @ControllerAdvice 的全局数据预处理可以解决这个问题
```
```java
1. 给接口中的变量取别名
@PostMapping("/book")
public void addBook(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author) {
    System.out.println(book);
    System.out.println(author);
}
```
```java
2. 进行请求数据预处理
在 @ControllerAdvice 标记的类中添加如下代码:
@InitBinder("b")
public void b(WebDataBinder binder) {
    binder.setFieldDefaultPrefix("b.");
}

@InitBinder("a")
public void a(WebDataBinder binder) {
    binder.setFieldDefaultPrefix("a.");
}
```
```md
@InitBinder(“b”) 注解表示该方法用来处理和Book和相关的参数,
在方法中,给参数添加一个 b 前缀,即请求参数要有b前缀。
```
```md
请求发送时,通过给不同对象的参数添加不同的前缀,可以实现参数的区分。
http://127.0.0.1:8080?b.name="handbook"&a.name="sunny"
```

* 如果你只想对一部分控制器添加
```java
某个包下的控制器
@ControllerAdvice(basePackages = "me.sunny.demo.spring.boot.web")
```
```java
如果你不想把包名写死，不如把包里的某个类传进去，这样包名重构了也不怕：
@ControllerAdvice(basePackageClasses = Controller.class)
```
```java
如果你只想对某几个控制器添加通知:
@ControllerAdvice(assignableTypes = {MainController.class, UserController.class})
```
