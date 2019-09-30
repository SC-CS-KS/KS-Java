# @RestControllerAdvice
```md
错误处理方法的返回值不会表示用的哪个视图，而是会作为HTTP body处理，
即相当于错误处理方法加了@ResponseBody注解。
```
```md
如果全部异常处理返回json，那么可以使用 @RestControllerAdvice 代替 @ControllerAdvice ，
这样在方法上就可以不需要添加 @ResponseBody。
```
