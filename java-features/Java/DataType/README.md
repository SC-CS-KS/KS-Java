# Java Data Type


## 类型转换 （Type Cast）
***Covariance vs. Contravariance （协变 vs. 逆变）***
```md
用来描述类型转换（type transformation）后的继承关系。
Liskov替换原则，可以创建一个子类对象赋值给其父类
例如：Number num = new Float(1.2);
```
* 协变
```md
能在使用父类型的场景中改用子类型的被称为协变，可以用一个子类对象去替换相应的一个父类对象，
这是完全符合里氏替换原则的，和协（谐）的变。
```
* 逆变
```md
能在使用子类型的场景中改用父类型的被称为逆变。
用一个父类对象去替换相应的一个父类对象，这貌似不符合里氏替原则的，不和协（谐）的逆变。
```
```md
场景通常包括数组，继承和泛型。
```
```md
如果 A 和 B 是类型，f 表示类型转换，≤ 表示子类型关系，例如A ≤ B，表示A是B的子类。

协变性（covariance）
	如果A ≤ B 则f(A) ≤ f(B) 那么 f是协变的。
逆变性(contravariance)
	如果 A ≤ B 则f(B) ≤ f(A) 那么 f 是逆变的。
无关性（invariant）
	如果上面两种都不成立，那么f是无关的。
```