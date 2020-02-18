# 嵌套类
```text
Java 语言允许我们在一个类中定义另一个类。
类中的类我们称之为嵌套类。而包含嵌套类的类，我们则称之为 包装类（enclosing class)或者外部类。
```
```java
public class EnclosingClass {
 
    public static final class NestedMemberClass {
 
    }
 
    public void nestedLocalClass() {
 
        final class NestedLocalClass {
 
        }
    }
 
    public void nestedAnonymousClass() {
 
        new Runnable() {
 
            @Override
            public void run() {
            }
        };
    }
}
```

## 成员嵌套类

成员嵌套类 作为外部类的成员定义的，成员嵌套类有外部类属性。
可以使用public,private,protected访问控制符，也可以用static,final关键字。

## 局部嵌套类

局部嵌套类定义在外部类的方法里面，局部嵌套类有外部类属性和enclosing method 属性。
可以使用final关键字。

## 匿名嵌套类
匿名嵌套类没有显示的定义一个类，直接通过new 的方法创建类的实例，一般回调模式情况下使用的比较多。
不使用任何关键字和访问控制符。

## 层次
嵌套类是可以有层次的，也就是说嵌套类里面还是定义类，成为嵌套类中的嵌套类。

```java
public class NestedClassLevel {
 
    class A {
        // 编译器会报错,A里面不能在定义名为A的nested classes
        // class A{}
        public void test() {
            class B {
            }
        }
    }
 
    //可以在继续定义B
    class B {
        public void test(){
            //可以无限定义匿名类
            new Runnable() {
                public void run() {
                    //可以无限定义匿名类
                    new Runnable() {            
                        public void run() {         
                        }
                    };
                }
            };
        }
    }
 
    // 只能定义一个B
    // class B{}
 
    public void test() {
        // 可以定义A
        class A {
            public void test() {
                //可以有同名的局部类B和成员类B
                class B {
                    public void test() {
                         
                    }
                }
                //局部类A里面不能在定义A
                //class A{}
            }
        }
        //可以有同名的局部类B和成员类B
        class B {
 
        }
    }
 
}
```

* 对于merber class
```text
	内部嵌套类的可以表示为 A$B 其中A为外部类，B为内部成员类
	
		如果B里面又有成员为C的嵌套类
			那么C就可以表示为A$B$C
		如果A定义了两个同名member class，那么编译器就会报错
		如果B里面又包含了为名B的nested class，则编译器会报错.
```

* 对于local inner Class
```text
	局部类可以表示为A$1B的方式
		其中A为外部类，B为第一个局部类
	
		如果在不同的方法里面定义了同名的局部类B
			编译器是可以编译通过的
			那么定义的第二个局部类B可以表示为A$2B
		如果在同一个方法里面同定义两个相同的局部类B，那么编译错是要报错的
		如果B里面又定义了同名的成员类，则可以表示为A$1B$B。
```

* 对于anonymous inner classes
```text
	匿名类可以表示为A$1的方式，代表程序里面有一个匿名类
	如果有N个，可以表示为A$N的方式(N为自然数)
```

* 对于定义在非static上下文里面的nested类层次
```text
	比如A$B$1C，则最内层的嵌套类C有一个指向B实例的引用
	B有一个指向A实例的引用，最终最内层的嵌套类可以访问A中的属性可以方法
		一般把B成为A的直接嵌套类
	但是A不可以访问B或者C中属性或者方法。
```

## nested interface

由于interface默认是定义为一个 public static的特殊类
所以interface可以直接作为 static member class
可以通过A.B的方式进行访问。

## 应用

在Java提供的基本类库里面，大量使用nested classes。

比如Map类里面有一个定义了Entry类abstract inner class。
在遍历map的时候：
```java
for (Map.Entry entry : map.entrySet()){
}
```