# Java Generics  

## Terms  

* 参数化的类型 List<String>  
* 实际数据类型 String  
* 泛型 List<E>  
* 形式类型参数 E  
* 无限制通配符类型 List<?>  
* 原生类型 List  
* 有限制类型参数 <E extends Number>  
* 递归类型限制 <T extends Comparable<T>>  
* 有限制通配符类型 List<? extends Number>  
* 泛型方法 static <E> List<E> asList(E[] a)  
* 类型令牌 String.class  

## [What Is ?](WhatIs.md)  

抽离了数据类型与代码逻辑，本意是提高程序代码的简洁性和可读性，并提供可能的编译时类型转换安全检测功能。  

## 原理 

* [类型擦除 （type erasure)](type-erasure.md)

* [泛型类 泛型方法 泛型接口](GenericClass-Method-Interface.md)  

* [泛型通配符](Generic_wildcard.md)

* [泛型 vs 数组](vs.Array.md)  
  
## CookBook  

***泛型中值得注意的地方***  

* 泛型类或者泛型方法中，不接受 8 种基本数据类型  
  
* 不能创建具体类型的泛型数组  
  
```java
List<Integer>[] li2 = new ArrayList<Integer>[];
List<Boolean> li3 = new ArrayList<Boolean>[];
```
```
这两行代码是无法在编译器中编译通过的，原因还是类型擦除带来的影响。
List<Integer> 和 List<Boolean> 在 JVM 中等同于List<Object>。  
```

## 应用 

* [示例代码](Generic.java)