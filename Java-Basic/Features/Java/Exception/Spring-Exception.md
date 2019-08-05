# Spring 统一异常处理

## @ControllerAdvice & @ExceptionHandler
```md
Spring3.2版本提供了新注解@controllerAdvice，意为控制器增强。
配合@ExceptionHandler注解可以统一处理异常。
```
```md
抽象级别应该是用于对Controller进行“切面”环绕的，而具体的业务织入方式则是通过结合其他的注解来实现的。
```

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