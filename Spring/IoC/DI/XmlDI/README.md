# XML DI

### ref

```xml
<bean id="stu" class="com.cn.pojo.Student" init-method="init" destroy-method="destroy">
    <property name="name" value="XXX"></property>
    <property name="phone" ref="iphone"></property>
</bean>
    
<bean id="iphone" class="com.cn.pojo.Phone">
    <property name="name" value="iphongX"></property>
</bean>
```
