# RMI (Remote Method Invocation)
```md
RMI看作是用Java语言实现了RPC协议
由于RPC不支持对象通信，这也是RMI比RPC的优越之处，支持对象传输。
```
* 特性
```md
它遵循的不是SOAP协议，而是JRMP（java remote message protocol）
	转为java对象所制定的一个协议，
	可以运行在任何用java语言写的系统上，具有跨平台特性，它不能跨语言。
RMI 采用stubs (客户机)和 skeletons (框架)来进行远程对象(remote object)的通讯
	stub 充当远程对象的客户端代理，有着和远程对象相同的远程接口，
	远程对象的调用实际是通过调用该对象的客户端代理对象stub来完成的，效果和调用本地对象一样。
既然用只支持java那么它也有了java对象的很多特性，如果垃圾回收、面向对象等。
传输的数据一般是java对象，而不是XML格式的数据。
```
* 优点
```md
支持分布式对象、跨平台，stubs/skeletons机制
```
* 缺点
```md
不能跨语言
```
* RMI和RPC
```md
返回值
	RMI 调用远程对象方法，允许方法返回 Java 对象以及基本数据类型。
	RPC 不支持对象的概念
		传送到 RPC 服务的消息由外部数据表示 (ExternalData Representation,XDR) 语言表示
		这种语言抽象了字节序类和数据类型结构之间的差异。
	可以说 RMI 是面向对象方式的 JavaRPC 。
通信语言
	RMI：仅支持Java语言
	RPC：可以跨语言访问
错误处理
	不支持对象，无法在编译器检查错误，只能在运行期检查。
方法调用
	在方法调用上，RMI中，远程接口使每个远程方法都具有方法签名。
		如果一个方法在服务器上执行，但是没有相匹配的签名被添加到这个远程接口上，那么这个新方法就不能被RMI客户方所调用。
	在RPC中，当一个请求到达RPC服务器时
		这个请求就包含了一个参数集和一个文本值，通常形成“classname.methodname”的形式。
		然后RPC服务器就去搜索与之相匹配的类和方法
```