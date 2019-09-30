# @RequestBody
```md
@RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据)

```
```md
@ResponseBody表示该方法的返回结果直接写入HTTP response body中。
当方法上面没有标注ResponseBody时，底层会将方法的返回值封装为ModelAndView对象。
```