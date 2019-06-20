# Spring MVC
```md
提供了一种分离式的方法来开发 Web 应用。
是以请求为驱动，围绕 Servlet 设计，将请求发给控制器，然后通过模型对象，分派器来展示请求结果视图。
其中核心类是 DispatcherServlet，它是一个 Servlet，顶层是实现的Servlet接口。
```

## 工作原理
```md
客户端发送请求
-> 前端控制器 DispatcherServlet 接受客户端请求 
-> 找到处理器映射 HandlerMapping 解析请求对应的 Handler
-> HandlerAdapter 会根据 Handler 来调用真正的处理器开处理请求，并处理相应的业务逻辑 
-> 处理器返回一个模型视图 ModelAndView 
-> 视图解析器进行解析 
-> 返回一个视图对象
-> 前端控制器 DispatcherServlet 渲染数据（Moder）
-> 将得到视图对象返回给用户
```

## 
* [Controller](Controller.md)
## 组件
* [前端控制器 DispatcherServlet](component/DispatcherServlet.md)
* 处理器映射器 HandlerMapping
* 处理器适配器 HandlerAdapter
* 处理器 Handler
* 视图解析器 View resolver
* 视图 View

## References
* [全程手写Spring MVC](https://www.jianshu.com/p/537ec419b45f)