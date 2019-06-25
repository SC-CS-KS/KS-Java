# Spring-WebMVC 注解
* @Controller 定义一个 Controller 控制器
```md
 @Controller是@Component注解的一个延伸，Spring会自动扫描并配置被该注解标注的类。此注解用于标注Spring MVC的控制器。
```
* [@RequestMapping 来映射 Request 请求与处理器](@RequestMapping.md)
* @RequestBody
```md
​ @RequestBody在处理请求方法的参数列表中使用，它可以将请求主体中的参数绑定到一个对象中，
请求主体参数是通过HttpMessageConverter传递的，根据请求主体中的参数名与对象的属性名进行匹配并绑定值。
此外，还可以通过@Valid注解对请求主体中的参数进行校验。
```
* @GetMapping
```md
@GetMapping注解用于处理HTTP GET请求，并将请求映射到具体的处理方法中。
具体来说，@GetMapping是一个组合注解，它相当于是@RequestMapping(method=RequestMethod.GET)的快捷方式。
```
* @PostMapping
* @PutMapping
* @DeleteMapping
* @PatchMapping

* @ResponseBody
```md
@ResponseBody会自动将控制器中方法的返回值写入到HTTP响应中。
特别的，@ResponseBody注解只能用在被@Controller注解标记的类中。
如果在被@RestController标记的类中，则方法不需要使用@ResponseBody注解进行标注。
@RestController相当于是@Controller和@ResponseBody的组合注解。
```

* [@ControllerAdvice](@ControllerAdvice.md)

* @ExceptionHandler
```md
@ExceptionHandler注解用于标注处理特定类型异常类所抛出异常的方法。当控制器中的方法抛出异常时，
Spring会自动捕获异常，并将捕获的异常信息传递给被@ExceptionHandler标注的方法。
```

* @ResponseStatus
```md
@ResponseStatus注解可以标注请求处理方法。使用此注解，可以指定响应所需要的HTTP STATUS。
特别地，我们可以使用HttpStatus类对该注解的value属性进行赋值。
```
* @PathVariable
```md
@PathVariable注解是将方法中的参数绑定到请求URI中的模板变量上。
可以通过@RequestMapping注解来指定URI的模板变量，然后使用@PathVariable注解将方法中的参数绑定到模板变量上。
特别地，@PathVariable注解允许我们使用value或name属性来给参数取一个别名。
```
```md
模板变量名需要使用“{ }”进行包裹，如果方法的参数名与URI模板变量名一致，则在@PathVariable中就可以省略别名的定义。
```
```md
提示：如果参数是一个非必须的，可选的项，则可以在@PathVariable中设置require = false
```
* @RequestParam
```md
@RequestParam注解用于将方法的参数与Web请求的传递的参数进行绑定。
使用@RequestParam可以轻松的访问HTTP请求参数的值。
```
```md
该注解的其他属性配置与@PathVariable的配置相同，特别的，如果传递的参数为空，还可以通过defaultValue设置一个默认值。
```
* @ModelAttribute
```md
通过此注解，可以通过模型索引名称来访问已经存在于控制器中的model。
与@PathVariable和@RequestParam注解一样，如果参数名与模型具有相同的名字，则不必指定索引名称
特别地，如果使用@ModelAttribute对方法进行标注，Spring会将方法的返回值绑定到具体的Model上。
```
* @CrossOrigin
```md
 @CrossOrigin注解将为请求处理类或请求处理方法提供跨域调用支持。
 如果我们将此注解标注类，那么类中的所有方法都将获得支持跨域的能力。
 使用此注解的好处是可以微调跨域行为。
```
* @InitBinder
```md
@InitBinder注解用于标注初始化WebDataBinider的方法，该方法用于对Http请求传递的表单数据进行处理，如时间格式化、字符串处理等。
```