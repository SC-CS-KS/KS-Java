# Array Covariance
***数组为什么要设计为协变的？***
```java
Number[] num = new Integer[10]; 
num[0] = 2.1; 
```
```md
在Java中，Integer 是 Number 的子类型，可以通过编译，而在运行时会错误。
```
***那为何不禁止数组协变，在编译期间就指出错误呢?***
```md
因为 Java 5 之前还没有泛型，但很多代码迫切需要泛型来解决问题。
```
```md
例如 比较两个数组是否“值相等“的 Arrays.equals( ) 方法，
  因为底层实现调用的是Object.equals( )方法，和数组中元素的具体类型无关。
```
```java
for (int i=0; i<length; i++) {
    Object o1 = a[i];
    Object o2 = a2[i];
    if (!(o1==null ? o2==null : o1.equals(o2)))
        return false;
}
```
```java
所以不想让每个类型都要重新定义Arrays.equals( )方法，而是”泛化“地接受任何元素类型的数组为参数。
就像现在这样:
	public static boolean equals(Object[] a, Object[] a2) {
    ... ...
}
要让Object[]能接受所有数组类型，那个时候又没有泛型，最简单的办法就是让数组接受协变。
把String[]，Integer[]都定义成Object[]的派生类，然后多态就起作用了。
```
***但为什么数组设计成”协变“不会有大问题呢？***
```md
这是基于数组的一个独有特性：
数组记得它内部元素的具体类型，并且会在运行时做类型检查。
```
```md
这就是上面的代码能通过编译，但运行时报错的原因，
num 变量记得它内部元素是 Integer，所以运行时给它插入double型的时候不让执行。
```
```md
这反而是数组的优点，也是当初”敢于“把数组设计成协变的原因，虽然向上转型以后，编译期类型检查放松了。
但因为数组运行时对内部元素类型看得紧，不匹配的类型还是插不进去的。
```
```md
这也是为什么容器Collection不能设计成协变的原因，Collection不做运行时类型检查，比较耿直。
在引入了通配符（Wildcard）之后，协变的功能也已经被实现。
```
***总的来说***
```md
协变数组类型是类型不安全的，处理不当会抛出异常。

协变数组类型虽然类型不安全，但是数组类型能够协变是一个合理的选择，
因为早期C#和Java都缺乏泛型，如果数组不允许协变，将无法使用多态。
```
```md
虽然数组的协变不是一个完美的设计，但也不能算非常烂。起码还能用，没有捅出大篓子。
而且数组又不支持泛型，底层类库到处是Object[]，现在也不可能改了。
```