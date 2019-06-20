# java.lang.Class

![](../../pic/java.lang.Class.jpg)

```java
public final class Class<T> implements java.io.Serializable,
                              GenericDeclaration,
                              Type,
                              AnnotatedElement {}
```

## Class 类
```md
类的抽象，即对“类”做描述，是反射机制的基础。
```

# Class 对象
```md
Class 对象是对类的描述，事实上，Class 对象就是用来创建类的实例对象的。
Class对象被保存在了.class文件中，类加载器会检查这个Class对象是否已经加载。
```
* 获取Class对象
```md
1. 调用Class类的静态方法forName
  比如 Class.forName("java.lang.String")
2. 使用类的.class语法
  比如 : Class cls = String.class
3. 调用对象的getClass方法
  比如:String str = "123"; Class cls = str.getClass();
```

## Methods
* 获取类中的属性:
```md
- getFields(): 获取类中public类型的属性
- getField(String name)： 获取类特定的方法，name参数指定了属性的名称
- getDeclaredFields(): 获取类中所有的属性(public、protected、default、private),但不包括继承的属性。
- getDeclaredField(String name): 获取类特定的方法，name参数指定了属性的名称
```
* 获取类中的构造函数:
```md
- getConstructors()：获取类中的公共方法
- getConstructor(Class[] params): 获取类的特定构造方法,params参数指定构造方法的参数类型
- getDeclaredConstructors(): 获取类中所有的构造方法(public、protected、default、private)
- getDeclaredConstructor(Class[] params): 获取类的特定构造方法，params参数指定构造方法的参数类型
```
* 获取类中的方法:
```md
- getMethods(): 获得类的public类型的方法
- getMethod(String name, Class[] params): 获得类的特定方法,name参数指定方法的名字,params参数指定方法的参数类型
- getDeclaredMethods(): 获取类中所有的方法(public、protected、default、private)
- getDeclaredMethod(String name, Class[] params): 获得类的特定方法,name参数指定方法的名字,params参数指定方法的参数类型
```
```md
- newInstance(): 通过类的不带参数 的构造方法创建这个类的一个对象
- forName(String className): 获取className参数指定的类的class对象
- forName(String className, boolean initialize, ClassLoader): 使用指定的类加载器获取className参数指定的类的class对象
- getClassLoader(): 获取类加载器
- getName(): 获取类名
- getPackage(): 获取类所在的包名
```
