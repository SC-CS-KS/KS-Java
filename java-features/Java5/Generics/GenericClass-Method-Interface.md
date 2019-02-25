# 泛型类 泛型方法 泛型接口
* 类型参数
```md
类型参数（又称类型变量）用作占位符，指示在运行时为类分配类型。
根据惯例，类型参数是单个大写字母，该字母用于指示所定义的参数类型。
```
```
推荐的标准类型参数：
E：元素
K：键
N：数字
T：类型
V：值
S、U、V 等：多参数情况中的第 2、3、4 个类型
```

* ***泛型类*** 
```java
public class Test<T> {
   T field1;
}
```
> * 多个类型参数
```java
public class MultiType <E,T>{
   E value1;
   T value2;

   public E getValue1(){
       return value1;
   }

   public T getValue2(){
       return value2;
   }
}
```
* ***泛型方法***
```java
public class Test1 {
   public <T> void testMethod(T t){
   }
}
```
```md
<T> 中的 T 被称为类型参数，而方法中的 T 被称为参数化类型
返回值类型 是 明确的 void 类型
```
> * 声明的类型参数，其实也是可以当作返回值的类型的
```java
public  <T> T testMethod1(T t){
       return null;
}
```
```md
连续的两个 T 容易让人困惑，<T> 是为了说明类型参数，是声明，
而后面的不带尖括号的 T 是方法的返回值类型，这里返回值类型 和 方法参数的类型是一样的。
```
> * 泛型类与泛型方法的共存
```java
public class Test1<T>{
   public  void testMethod(T t){
       System.out.println(t.getClass().getName());
   }
   public  <T> T testMethod1(T t){
       return t;
   }
}
```
```md
Test1<T> 是泛型类，testMethod 是泛型类中的普通方法，而 testMethod1 是一个泛型方法。
而泛型类中的类型参数 与泛型方法中的类型参数 是没有相应的联系的。
```
***泛型方法始终以自己定义的类型参数为准***
```java
Test1<String> t = new Test1();
t.testMethod("generic");
Integer i = t.testMethod1(new Integer(1));
```
```md
以上测试代码中，泛型类的实际类型参数是 String，而传递给泛型方法的类型参数是 Integer，两者不相干。
```
```md
但是，为了避免混淆，如果在一个泛型类中存在泛型方法，那么两者的类型参数最好不要同名。
```
```java
public class Test1<T>{

   public  void testMethod(T t){
       System.out.println(t.getClass().getName());
   }
   public  <E> E testMethod1(E e){
       return e;
   }
}
```
* ***泛型接口***
```md
泛型接口和泛型类比较相似。
```
```java
public interface Iterable<T> {
}
```
