# @RequestMapping
```md
在使用@RequestMapping之前，请求处理类还需要使用@Controller或@RestController进行标记
```

## 使用 URI 模板

## @RequestParam 绑定 HttpServletRequest 请求参数到控制器方法参数

## @CookieValue 绑定 cookie 的值到 Controller 方法参数

## @RequestHeader 注解绑定 HttpServletRequest 头信息到Controller 方法参数

## @RequestMapping 属性
```md
value:映射的请求URL或者其别名
method:兼容HTTP的方法名
params:根据HTTP参数的存在、缺省或值对请求进行过滤
header:根据HTTP Header的存在、缺省或值对请求进行过滤
consume:设定在HTTP请求正文中允许使用的媒体类型
product:在HTTP响应体中允许使用的媒体类型
```
* method
```md
If you do not specify any mapping this method will resolve all the http request i.e. 
you can send GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE request to the specified url and it will be resolved.
如果没有指定method，此方法将解析所有http请求，即可以将GET，POST，HEAD，OPTIONS，PUT，PATCH，DELETE，TRACE请求发送到指定的URL，它将被解析。
```
## @RequestMapping 标记的处理器方法支持的方法参数和返回类型
## @ModelAttribute 和 @SessionAttributes 传递和保存数据
## 定制自己的类型转换器

