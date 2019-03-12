# Enums

## [WhatIs](WhatIs.md)

## Design
```md
通过关键字enum创建枚举类型，在编译后事实上是一个类类型，而且该类继承自java.lang.Enum类。
```
```md
从反编译的代码可以看出，编译器确实生成了一个Day类，注意该类是final类型的，将无法被继承。
final class Day extends Enum

编译器还生成了7个Day类型的实例对象分别对应枚举中定义的7个日期。
	
编译器还生成了两个静态方法 values()和 valueOf()。
```
* Enum抽象类
```md
是所有 Java 语言枚举类型的公共基本类
构造函数
	只能编译器调用
		毕竟我们只能使用enum关键字定义枚举，其他事情就放心交给编译器
```
```md
常见方法
	ordinal()
		返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）
		如日期中的MONDAY在第一个位置，那么MONDAY的ordinal值就是0
			如果MONDAY的声明位置发生变化，那么ordinal方法获取到的值也随之变化
		注意在大多数情况下我们都不应该首先使用该方法，毕竟它总是变幻莫测的
	compareTo(E o)
		内部实现是根据每个枚举的ordinal值大小进行比较的
		Enum实现了Comparable接口
	name()方法与toString()
		几乎是等同的，都是输出变量的字符串形式
	valueOf(Class<T> enumType, String name)
		根据枚举类的Class对象和枚举名称获取枚举常量
			注意该方法是静态的
		
			Enum.valueOf(Day.class,days[0].name());
			Day.valueOf(Day.class,days[0].name());
```
* values()和valueOf(String name)
```md
		是编译器生成的static方法
			values()
				获取枚举类中的所有变量，并作为数组返回
			valueOf(String name)
				与Enum类中的valueOf方法的作用类似根据名称获取枚举变量
					更简洁些只需传递一个参数
		在Enum类中并没出现values()方法，但valueOf()方法还是有出现的
			只不过编译器生成的valueOf()方法需传递一个name参数
			而Enum自带的静态方法valueOf()则需要传递两个方法
		编译器生成的valueOf方法最终还是调用了Enum类的valueOf方法
```md
```md
	注意
		如果我们将枚举实例向上转型为Enum
			那么values()方法将无法被调用
				因为Enum类中并没有values()方法，valueOf()方法也是同样的道理
```
* 枚举与Class对象
```md
由于Class对象的存在
		即使不使用values()方法，还是有可能一次获取到所有枚举实例变量的
		通过Enum的class对象的getEnumConstants方法，仍能一次性获取所有的枚举实例常量
	
		getEnumConstants()
			返回该枚举类型的所有元素，如果Class对象不是枚举类型，则返回null。
		isEnum()
			当且仅当该类声明为源代码中的枚举时返回 true
				Enum e = Day.MONDAY;
				Class<?> clasz = e.getDeclaringClass();
					//获取class对象引用
				if (clasz.isEnum()) {
    Day[] dsz = (Day[]) clasz.getEnumConstants();
}
```
## Utility
* 定义
```java
	enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```
```md
值一般是大写的字母，多个值之间以逗号分隔
可以像类(class)类型一样，定义为一个单独的文件，当然也可以定义在其他类内部
枚举表示的类型其取值是必须有限的
```
* 自定义
```java
		enum Color{
    RED(1),GREEN(2),BLUE(3);
    private int code;
    Color(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }
}
```
* 引用
```md
	Day day =Day.MONDAY;
```
* 遍历
```java
	for (Day day : Day.values())
```

* 枚举实现单例模式
```md
能避免多线程同步问题
如果用枚举去实现一个单例，这样的加载有点类似于饿汉模式，并没有起到lazy-loading的作用
```
## Extend
* java.util.EnumSet
```md
		是一个用来操作Enum的集合，是一个抽象类
			两个继承类：JumboEnumSet和RegularEnumSet
		EnumSet的元素不允许为null；EnumSet非线程安全。
	EnumSet<Color> colorSet = EnumSet.allOf(Color.class);
```

* java.util.EnumMap
```md	
		EnumMap是Map的实现类
			EnumMap内部使用数组来实现。
		EnumMap的key不允许为null，value可以为null
			按照key在enum中的顺序进行保存，非线程安全
		《Effective JAVA》中作者建议用EnumMap代替叙述 索引
			最好不要用序数来索引数组，而要使用EnumMap。
	
		EnumMap<Color, String> enumMap =  new EnumMap<Color, String>(Color.class);
		 enumMap.put(Color.RED, "red");
		for (Map.Entry<Color, String> entry: enumMap.entrySet())
```
