# @ControllerAdvice
```md
@ControllerAdvice是@Component注解的一个延伸注解，Spring会自动扫描并检测被@ControllerAdvice所标注的类。
@ControllerAdvice需要和@ExceptionHandler、@InitBinder以及@ModelAttribute注解搭配使用，主要是用来处理控制器所抛出的异常信息。

首先，我们需要定义一个被@ControllerAdvice所标注的类，在该类中，定义一个用于处理具体异常的方法，并使用@ExceptionHandler注解进行标记。
此外，在有必要的时候，可以使用@InitBinder在类中进行全局的配置，还可以使用@ModelAttribute配置与视图相关的参数。
使用@ControllerAdvice注解，就可以快速的创建统一的，自定义的异常处理类。
```
```md
是一个增强的 Controller，可以实现三个方面的功能：
全局异常处理
全局数据绑定
全局数据预处理
```
## 全局异常处理
```java
@ControllerAdvice
public class MyGlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView customException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
```
```md
在该类中，可以定义多个方法，不同的方法处理不同的异常，例如专门处理空指针的方法、专门处理数组越界的方法…，
也可以直接向上面代码一样，在一个方法中处理所有的异常信息。
```
```md
@ExceptionHandler 注解用来指明异常的处理类型，
即如果这里指定为 NullPointerException，则数组越界异常就不会进到这个方法中来。
```
## 全局数据绑定
```md
全局数据绑定功能可以用来做一些初始化的数据操作，可以将一些公共的数据定义在添加了 @ControllerAdvice 注解的类中，
这样，在每一个 Controller 的接口中，就都能够访问导致这些数据。
```
```java
@ControllerAdvice
public class MyGlobalExceptionHandler {
    @ModelAttribute(name = "md")
    public Map<String,Object> mydata() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 99);
        map.put("gender", "男");
        return map;
    }
}
```
```md
使用 @ModelAttribute 注解标记该方法的返回数据是一个全局数据，
默认情况下，这个全局数据的 key 就是返回的变量名，value 就是方法返回值，
当然开发者可以通过 @ModelAttribute 注解的 name 属性去重新指定 key。
```
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
## 全局数据预处理
```java
考虑我有两个实体类，Book 和 Author，分别定义如下：
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
