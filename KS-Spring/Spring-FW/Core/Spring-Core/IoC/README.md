# IoC - Inverse of Control（控制反转）
```md
是一种设计思想，就是将原本在程序中手动创建对象的控制权，交由Spring框架来管理。
```
* 正控 若要使用某个对象，需要自己去负责对象的创建
* 反控 若要使用某个对象，只需要从 Spring 容器中获取需要使用的对象
```md
不关心对象的创建过程，也就是把创建对象的控制权反转给了Spring框架
```
* 好莱坞法则 - Don’t call me ,I’ll call you

## 实现
```md
Spring不仅提供了一个已经成为业界标准的Java IoC框架
读取标注或者配置文件，看看JuiceMaker依赖的是哪个Source，拿到类名
使用反射的API，基于类名实例化对应的对象实例，将对象实例，通过构造函数或者 setter，传递给 JuiceMaker
```

## 注入方式
### 构造器注入
### Setter注入


