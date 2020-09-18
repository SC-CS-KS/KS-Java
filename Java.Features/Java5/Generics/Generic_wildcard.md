# 泛型通配符

## 背景

```java
List<Sub> lsub = new ArrayList<>();
List<Base> lbase = lsub;
```
```md
第二行代码 编译器不会让它通过的。
Sub 是 Base 的子类，不代表 List<Sub> 和 List<Base> 有继承关系。

但是，在现实编码中，确实有这样的需求，希望泛型能够处理某一范围内的数据类型，
比如某个类和它的子类，对此 Java 引入了通配符这个概念。
```
***通配符的出现是为了指定泛型中的类型范围***
```md
所以，所谓泛型通配，是指在声明泛型类型变量时，可以不必直接指定具体的泛型，而可以使用通配符来表示一系列类型。
```

Java 泛型通配符的出现是为了使 Java 泛型也支持向上转型，从而保持 Java 语言向上转型概念的统一。  
但与此同时，也导致 Java 通配符出现了一些缺陷，使得其有特定的使用场景。  

* 无限定通配符 <?>

<?> 代表着类型未知

```java
List<?> list1 = new ArrayList<String>();    // 合法
List<?> list2 = new ArrayList<?>();         // 不合法
List<String> list3 = new ArrayList<?>();    // 不合法
```
```java
public void testWildCards(Collection<?> collection){
}
```
```md
方法内的参数是被无限定通配符修饰的 Collection 对象，它隐略地表达了一个意图或者可以说是限定，
那就是 testWidlCards() 这个方法内部无需关注 Collection 中的真实类型，因为它是未知的。
```
***只能调用 Collection 中与类型无关的方法***
```java
List<?> list1 = new ArrayList<String>();
list1.add(1);   // 编译不通过
list1.get(0);   // 编译通过
int size = list1.size();    // 由于size()方法中不含泛型参数，所以可以再通配符变量中调用
```
```md
有人说，<?> 提供了只读的功能，也就是它删减了增加具体类型元素的能力，只保留与具体类型无关的功能
它不管装载在这个容器内的元素是什么类型，它只关心元素的数量、容器是否为空
```
```md
<?> 既然作用这么渺小，那么为什么还要引用它呢？
个人认为，提高了代码的可读性，程序员看到这段代码时，就能够迅速对此建立极简洁的印象，能够快速推断源码作者的意图。
```
* 上界限定通配符 <? extends E>
```md
<?> 代表着类型未知，但是我们的确需要对于类型的描述再精确一点，
我们希望在一个范围内确定类别，比如类型 A 及 类型 A 的子类都可以。
```
```java
public void testSub(Collection<? extends Base> para){
}
```
```md
para 这个 Collection 接受 Base 及 Base 的子类的类型。
但是，它仍然丧失了写操作的能力。
```
```java
para.add(new Sub());
para.add(new Base());
```
```md
仍然编译不通过。
没有关系，我们不知道具体类型，但是我们至少清楚了类型的范围。
```
* 下界限定通配符 (超类型) <? super E>
```java
public void testSuper(Collection<? super Sub> para){
}
```
```md
<? super T> 神奇的地方在于，它拥有一定程度的写操作的能力。
```
```md
public void testSuper(Collection<? super Sub> para){
   para.add(new Sub());//编译通过
   para.add(new Base());//编译不通过
}
```
***可以为一个泛型指定上边界或下边界, 但是不能同时指定上下边界。***

* 通配符 vs. 与类型参数

```java
一般而言，通配符能干的事情都可以用类型参数替换。 
比如
public void testWildCards(Collection<?> collection){}
可以被
public <T> void test(Collection<T> collection){}
取代。
```
```md
值得注意的是，如果用泛型方法来取代通配符，那么上面代码中 collection 是能够进行写操作的。
只不过要进行强制转换。
```
```java
public <T> void test(Collection<T> collection){
   collection.add((T)new Integer(12));
   collection.add((T)"123");
}
```
```md
需要特别注意的是，类型参数适用于参数之间的类别依赖关系
```
```java
public class Test2 <T,E extends T>{
   T value1;
   E value2;
}
```md
E 类型是 T 类型的子类，显然这种情况类型参数更适合。 
```
```java
public <D,S extends D> void test(D d,S s){
}
```
> * 通配符和类型参数一起使用
```md
public <T> void test(T t,Collection<? extends T> collection){
}
```
```md
如果一个方法的返回类型依赖于参数的类型，那么通配符也无能为力
```
```java
public T test1(T t){
   return value1;
}
```
* vs. 协变逆变
```md
泛型没有内建的协变类型，泛型中利用通配符实现的协变和逆变:
// 协变
List<? extends Fruit> flist = new ArrayList<Apple>();
// 逆变
List<? super Apple> alist = new ArrayList<Fruit>();
```

* 那么到底什么时候使用下边界通配，什么时候使用上边界通配呢？
```md
首先考虑一下怎样才能保证不会发生运行时异常，这是泛型要解决的首要问题，
通过前面的内容可以看到，任何可能导致类型转换异常的操作都无法编译通过。

* 上边界通配
可以保证存放的实际对象至多是上边界指定的类型，那么在读取对象时，我们总是可以放心地将对象赋予上边界类型的引用。

* 下边界通配
可以保证存放的实际对象至少是下边界指定的类型，那么在存入对象时，我们总是可以放心地将下边界类型的对象存入泛型对象中。
```

* PECS 法则
```md
如果你想从一个数据类型里获取数据，使用? extends通配符
如果你想把对象写入一个数据结构里，使用? super通配符
如果你既想存，又想取，那就别用通配符

这就是《Effective Java》书中所说的PECS法则（Producer Extends, Consumer Super）
```
```md
Collections工具类中的copy方法就完美地诠释了这个法则
public static <T> void copy(List<? super T> dest, List<? extends T> src) {}

这个方法的作用是将src列表完整地拷贝到dest列表中，
src是原始列表，我们需要读取其中的元素，所以它是生产者，需要使用extends通配；
dest是目标列表，需要将读取出来的元素存入这个列表中，所以他是消费者，使用super通配。
```
