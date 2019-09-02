# What Is Java Array?

```md
是Object的直接子类。

但是它又与普通的Java对象存在很大的不同，从它的类名就可以看出：[I。
可以简单的说数组的类名由若干个’[‘和数组元素类型的内部名称组成。

‘[‘的数目代表了数组的维度。
```
* 数组是对象
```md
数组对象并不是从某个类实例化来的，而是由JVM直接创建的。
父类就是Object，所以可以调用Object中的所有方法。
```
```md
每个数组都有一个相关联的 Class 对象，也就可以进行运行时的类型检查。
```
```java
int[] arr = new int[5];
System.out.println(arr.getClass().getName());
System.out.println(arr.getClass().getSuperclass().getName());
```
```md
[I
java.lang.Object
```
```md
具有相同类型元素和相同维度的数组，属于同一个相关联的类对象。
如果两个数组的元素类型相同，但维度不同，那么它们属于不同的相关联的类对象。
如果两个数组的元素类型和维度均相同，但长度不同，那么它们还是属于同一个相关联的类对象。
```
```java
int[] arr = new int[5];                                    
Class<? extends int[]> clazz = arr.getClass();             
System.out.println(clazz.getDeclaredFields().length);      
System.out.println(clazz.getDeclaredMethods().length);     
System.out.println(clazz.getDeclaredConstructors().length);
System.out.println(clazz.getDeclaredAnnotations().length); 
System.out.println(clazz.getDeclaredClasses().length);     
System.out.println(clazz.getSuperclass());
System.out.println(Arrays.toString(clazz.getInterfaces()));       
```
```md
0
0
0
0
0
class java.lang.Object
[interface java.lang.Cloneable, interface java.io.Serializable]
```
```md
[I这个类是java.lang.Object的直接子类，自身没有声明任何成员变量、成员方法、构造函数和注解。 
可以说，[I就是个空类。 
```
