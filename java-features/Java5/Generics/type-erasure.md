# 类型擦除 （type erasure)
```md
类型擦除不是泛型的全部，但是它却能很好地检测我们对于泛型这个概念的理解程度。
```
```java
List<String> l1 = new ArrayList<String>();
List<Integer> l2 = new ArrayList<Integer>();
 
System.out.println(l1.getClass() == l2.getClass());
```
```md
打印的结果为 true 是因为 List<String> 和 List<Integer> 在 jvm 中的 Class 都是 List.class。
使用泛型的时候加上的类型参数，会在编译的时候去掉，这个过程就称为类型擦除。
```
```md
泛型附加的类型信息对JVM来说是不可见的。
Java编译器会在编译时尽可能的发现可能出错的地方，但是仍然无法避免在运行时出现类型转换异常的情况。
```
```md
类型擦除也是 Java的泛型实现方法 与 C++模版机制实现方式 之间的重要区别。
```
***泛型转译***
```java
public class Erasure <T>{
   T object;
 
   public Erasure(T object) {
       this.object = object;
   }
}
```
```java
Erasure<String> erasure = new Erasure<String>("hello");
Class eclz = erasure.getClass();
System.out.println("erasure class is:"+eclz.getName());
```
```md
Erasure 是一个泛型类，查看它在运行时的状态信息可以通过反射:
erasure class is:com.frank.test.Erasure
```
```java
Field[] fs = eclz.getDeclaredFields();
for ( Field f:fs) {
   System.out.println("Field name "+f.getName()+" type:"+f.getType().getName());
}
```
```md
泛型类中 T 的类型在 JVM 中的具体类型
Field name object type:java.lang.Object
```
```java
public class Erasure <T extends String>{
   T object;
   public Erasure(T object) {
       this.object = object;
   }
}
```
```md
Field name object type:java.lang.String
```
```md
在泛型类被类型擦除的时候，之前泛型类中的类型参数部分如果没有指定上限，如 <T> 则会被转译成普通的 Object 类型，
如果指定了上限如 <T extends String> 则类型参数就被替换成类型上限。
```
```java
public class Erasure <T>{
   T object;
 
   public Erasure(T object) {
       this.object = object;
   }
 
   public void add(T object){
   }
}
```
```java
Erasure<String> erasure = new Erasure<String>("hello");
Class eclz = erasure.getClass();
System.out.println("erasure class is:"+eclz.getName());
 
Method[] methods = eclz.getDeclaredMethods();
for ( Method m:methods ){
   System.out.println(" method:"+m.toString());
}
```
```md
add() 这个方法对应的 Method 的签名应该是 Object.class
method:public void com.frank.test.Erasure.add(java.lang.Object)
```
```md
也就是说，如果你要在反射中找到 add 对应的 Method，你应该调用 getDeclaredMethod("add",Object.class) 
否则程序会报错，提示没有这么一个方法，原因就是类型擦除的时候，T 被替换成 Object 类型了。
```
***很多泛型的奇怪特性都与类型擦除的存在有关***
```md
1. 静态变量是被泛型类的所有实例所共享的
  对于声明为 MyClass<T> 的类，访问其中的静态变量的方法仍然是 MyClass.myStaticVar。
  不管是通过 new MyClass<String> 还是 new MyClass<Integer> 创建的对象，都是共享一个静态变量。
2. 泛型的类型参数不能用在 Java 异常处理的 catch 语句中，因为异常处理是由 JVM 在运行时刻来进行的。
  由于类型信息被擦除，JVM 是无法区分两个异常类型 MyException<String> 和 MyException<Integer> 的。
```
***类型擦除带来的局限性***
```md
类型擦除，是泛型能够与之前的 java 版本代码兼容共存的原因。
但也因为类型擦除，它会抹掉很多继承相关的特性，这是它带来的局限性。
```
```java
public class ToolTest {
  public static void main(String[] args) {
    List<Integer> ls = new ArrayList<>();
    ls.add("text");
  }
}
```
```md
正常情况下，因为泛型的限制，编译器不让最后一行代码编译通过，因为类似不匹配，
但是，基于对类型擦除的了解，利用反射，我们可以绕过这个限制。
```
```java
public interface List<E> extends Collection<E>{
    boolean add(E e);
}
```
```java
因为 E 代表任意的类型，所以类型擦除时，add 方法其实等同于
boolean add(Object obj);
```
```java
那么，利用反射，我们绕过编译器去调用 add 方法
public class ToolTest {
   public static void main(String[] args) {
       List<Integer> ls = new ArrayList<>();
       ls.add(23);
//     ls.add("text");
       try {
           Method method = ls.getClass().getDeclaredMethod("add",Object.class);
           method.invoke(ls, "text");
           method.invoke(ls, 42.9f);
       } catch (NoSuchMethodException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (SecurityException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (IllegalArgumentException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       for ( Object o: ls){
           System.out.println(o);
       }
   }
}
```
```md
输出：
23
test
42.9

可以看到，利用类型擦除的原理，用反射的手段就绕过了正常开发中编译器不允许的操作限制。
```
## vs. 原始类型（raw type）
```md
原始类型是擦除泛型信息，最后在字节码中的类型变量的真正类型。

无论何时定义一个泛型类型，相应的原始类型都会被自动地提供。
类型变量被擦除，并使用其限定类型（无限定的变量用Object）替换。
```