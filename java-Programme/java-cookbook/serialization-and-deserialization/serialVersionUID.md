# serialVersionUID

```md
强烈建议所有可序列化类显式声明serialVersionUID值，
因为默认的serialVersionUID计算对类详细信息高度敏感，
这些详细信息可能因编译器实现而异，并且可以在不同环境中生成不同的serialVersionUID。

在反序列化期间，这可能导致意外的InvalidClassException。
```
* 注意
```md
serialVersionUID字段不适用于继承成员。
```

## 参考
*  [Java serialVersionUID – How to generate serialVersionUID](https://howtodoinjava.com/java/serialization/serialversionuid/)