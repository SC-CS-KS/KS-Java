# Array Cookbook

* 根据数组创建ArrayList
```java
String[] stringArray = { "a", "b", "c", "d", "e" };
ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
```
* 判断数组内部是否包含某个值
```java
String[] stringArray = { "a", "b", "c", "d", "e" };
boolean b = Arrays.asList(stringArray).contains("a");
```
* 连接两个数组
```java
int[] combinedIntArray = ArrayUtils.addAll(intArray1, intArray2);
```
* 声明一个内联数组（array inline）
```java
method(new String[]{"a", "b", "c", "d", "e"});
```
* 根据分隔符拼接数组元素（去掉最后一个分隔符）
```md
String j = StringUtils.join(new String[] { "a", "b", "c" }, ", ");
```
* ArrayList转数组
```java
String[] stringArray = { "a", "b", "c", "d", "e" };
ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
String[] stringArr = new String[arrayList.size()];
```
* Array 转 Set
```java
Set<String> set = new HashSet<String>(Arrays.asList(stringArray));
```
* 反转数组
```java
int[] intArray = { 1, 2, 3, 4, 5 };
ArrayUtils.reverse(intArray);
```
* 删除数组元素
```java
int[] intArray = { 1, 2, 3, 4, 5 };
int[] removed = ArrayUtils.removeElement(intArray, 3);//create a new array
```
* 整形转字节数组
```java
byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();
```
