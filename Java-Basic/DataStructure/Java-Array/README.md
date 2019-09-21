# Java Array

## [WhatIs](WhatIs.md)

## Design
* 数组声明
```java
String[] aArray = new String[5];
String[] bArray = {"a","b","c", "d", "e"};
String[] cArray = new String[]{"a","b","c","d","e"};
```
* 数组长度
```md
在数组编译之后生成的字节码中，没有length这个成员变量。
获取数组长度是由一条特定的指令 Array Length 实现。
对于 HotSpot VM，在数组对象的对象头里有一个 _length 字段，记录数组长度。 
Array Length 字节码的实现只要去读那个 _length 字段即可。
```
* [数组方法](array_methods.md)
* [数组 Cookbook](array_cookbook.md)

## 
* [数组的协变](array_Covariance.md)
* 数组不支持泛型

## 类库
* java.util.Arrays - 类包含一个静态的工厂，允许数组被视为列表
* java.util.ArrayList - 提供了可调整大小的数组，并实现了List接口
* org.apache.commons.lang3.ArrayUtils - ArrayUtils是专门用来处理数组的工具类


* java.util.ArrayDeque
* java.util.concurrent.ArrayBlockingQueue
