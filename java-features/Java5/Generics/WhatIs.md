# What Is Java Generic?
```md
简单讲，泛型就是能广泛适用的类型。是将类型参数化，其在编译时才确定具体的参数。
是一种编译器机制，会得到方便代码重用的代码模板。
```
```md
泛型只存在于编译阶段，而不存在于运行阶段，在编译后的 class 文件中，是没有泛型这个概念的。
```
* 优势
```md
1. 对比普通的 Object 代替一切类型的简单粗暴
  泛型使得数据的类别可以像参数一样由外部传递进来。
  它减少了代码的复杂性，且提供了一种扩展能力。它更符合面向抽象开发的软件编程宗旨。

2. 当具体的类型确定后，泛型又提供了一种类型检测的机制
  只有相匹配的数据才能正常的赋值，否则编译器就不通过，将运行时异常“ClassCastException”转到了编译时检测异常。
  所以说，它是一种类型安全检测机制，一定程度上提高了软件的安全性防止出现低级的失误。

3. 泛型提高了程序代码的可读性
  不必要等到运行的时候才去强制转换，在定义或者实例化阶段，
  因为 Cache<String> 这个类型显化的效果，能够一目了然看出代码要操作的数据类型。
```
## Compare 
* vs. C++ 泛型
```md
泛型思想最早在C++语言的模板（Templates）中产生，Java后来也借用了这种思想。
虽然思想一致，但是他们的实现存在着本质的不同。

C++中的模板是真正意义上的泛型，在编译时就将不同模板类型参数编译成对应不同的目标代码，
ClassName<String>和ClassName<Integer>是两种不同的类型，这种泛型被称为真正的泛型。
这种泛型实现方式，会导致类型膨胀，因为要为不同具体参数生成不同的类。

Java中的ClassName<String>和ClassName<Integer>虽然在源代码中属于不同的类，
但是编译后的字节码中，他们都被替换成原始类型ClassName，而两者的原始类型是一样的，
所以在运行环境中，ClassName<String>和ClassName<Integer>就是同一个类。

Java中的泛型是一种特殊的语法糖，通过类型擦除实现，这种泛型称为伪泛型。
由于Java中有这么一个障眼法，如果没有深入研究，就会产生莫名其妙的问题。
```
* vs. 继承
```md
引用的参数类型与实际对象的参数类型要保持一致（通配符除外），就算两个参数类型是继承关系也是不允许的。

看看下面两行代码，它们均不能通过编译:
ArrayList<String> arraylist1 = new ArrayList<Object>();
ArrayList<Object> arrayList2 = new ArrayList<String>();
```
* vs. 多态
```md
普通类型的多态是通过继承并重写父类的方法来实现的，泛型也不例外。
```
```java
public class Father<T> {
    public void set(T t) {
        System.out.println("I am father, t = " + t);
    }

    public T get() {
        return null;
    }
}

public class Son extends Father<String> {
    @Override
    public void set(String s) {
        super.set(s);
        System.out.println("I am son");
    }

    @Override
    public String get() {
        return super.get();
    }

    public static void main(String[] args) {
        Father<String> father = new Son();
        father.set("hello world");
    }
}
```
```md
从字节码中可以看到，除了void set(String)和String get()两个方法以外，
还出现了void set(Object)和Object get()两个方法，这两个方法在Son源代码里并不存在，
这是编译器为了解决泛型的多态问题而自动生成的方法，称为”桥方法”。

这两个方法的签名与Father类中的两个方法的签名完全一致，这才是真正的方法重写。
也就是说，子类真正重写的是我们看不到的桥方法。
```
