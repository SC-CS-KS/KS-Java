# serialVersionUID

serialVersionUID适用于java序列化机制。  
简单来说，JAVA序列化的机制是通过判断类的serialVersionUID来验证的版本一致的。  
在进行反序列化时，JVM会把传来的字节流中的serialVersionUID于本地相应实体类的serialVersionUID进行比较。  
如果相同说明是一致的，可以进行反序列化，否则会出现反序列化版本一致的异常，即是InvalidCastException。  

***强烈建议所有可序列化类显式声明serialVersionUID值***

* 具体序列化的过程

序列化操作时会把系统当前类的serialVersionUID写入到序列化文件中，当反序列化时系统会自动检测文件中的serialVersionUID，  
判断它是否与当前类中的serialVersionUID一致。  
如果一致说明序列化文件的版本与当前类的版本是一样的，可以反序列化成功，否则就失败。  

## 生成方式

一是默认的1L，比如：private static final long serialVersionUID = 1L;    

二是根据包名，类名，继承关系，非私有的方法和属性，以及参数，返回值等诸多因子计算得出的，极度复杂生成的一个64位的哈希字段。
基本上计算出来的这个值是唯一的，比如：private static final long  serialVersionUID = xxxxL;

当实现java.io.Serializable 接口中没有显示的定义serialVersionUID变量的时候，
JAVA序列化机制会根据Class自动生成一个serialVersionUID作序列化版本比较用，
这种情况下，如果Class文件(类名，方法等)没有发生变化(增加空格，换行，增加注释等等)，就算再编译多次，serialVersionUID也不会变化的。

如果我们不希望通过编译来强制划分软件版本，即实现序列化接口的实体能够兼容先前版本，
就需要显示的定义一个serialVersionUID，类型为long的变量。

不修改这个变量值的序列化实体，都可以相互进行序列化和反序列化。  
