# Java Array
```md
是Object的直接子类。

但是它又与普通的Java对象存在很大的不同，从它的类名就可以看出：[I。
可以简单的说数组的类名由若干个’[‘和数组元素类型的内部名称组成。

数组是对象
	数组对象并不是从某个类实例化来的，而是由JVM直接创建的。
	父类就是Object，所以可以调用Object中的所有方法。
```
* [数组的协变](array_Covariance.md)
* 数组不支持泛型

## 类库
* java.util.Arrays - 类包含一个静态的工厂，允许数组被视为列表
* java.util.ArrayList - 提供了可调整大小的数组，并实现了List接口
* org.apache.commons.lang3.ArrayUtils - ArrayUtils是专门用来处理数组的工具类


* java.util.ArrayDeque
* java.util.concurrent.ArrayBlockingQueue
