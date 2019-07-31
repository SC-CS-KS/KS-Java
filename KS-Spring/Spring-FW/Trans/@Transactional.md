# @Transactional 

```xml
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>4.3.17.RELEASE</version>
    </dependency>
```
第一步，在 xml 配置文件中添加事务配置信息。
第二步，将@Transactional 注解添加到合适的方法上，并设置合适的属性信息。
## 属性
name	当在配置文件中有多个 TransactionManager , 可以用该属性指定选择哪个事务管理器。
propagation	事务的传播行为，默认值为 REQUIRED。
isolation	事务的隔离度，默认值采用 DEFAULT。
timeout	事务的超时时间，默认值为-1。如果超过该时间限制但事务还没有完成，则自动回滚事务。
read-only	指定事务是否为只读事务，默认值为 false；为了忽略那些不需要事务的方法，比如读取数据，可以设置 read-only 为 true。
rollback-for	用于指定能够触发事务回滚的异常类型，如果有多个异常类型需要指定，各类型之间可以通过逗号分隔。
no-rollback- for	抛出 no-rollback-for 指定的异常类型，不回滚事务。



## Reference
* [透彻的掌握 Spring 中@transactional 的使用](https://www.cnblogs.com/xd502djj/p/10940627.html)
