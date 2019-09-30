# IOC Container
```md
IoC 容器负责管理容器中所有 bean 的生命周期
```
## Workflow
```md
容器启动阶段
		会通过某种途径加载 ConfigurationMetaData
Bean 的实例化阶段
```
## Bean
```md
BeanDefinition
		容器中的每一个 bean 都会有一个对应的 BeanDefinition 实例
		负责保存 bean 对象的所有必要信息
			包括 bean 对象的 class 类型、是否是抽象类、构造方法和参数、其他属性等等
	当客户端向容器请求相应对象时
		容器就会通过这些信息为客户端返回一个完整可用的 bean 实例
BeanDefinitionRegistry
	抽象出 bean 的注册逻辑
	
		registerBeanDefinition
		removeBeanDefinition
		getBeanDefinition
BeanFactory
	抽象出了 bean 的管理逻辑
		各个 BeanFactory 的实现类就具体承担了 bean 的注册以及管理工作
	DefaultListableBeanFactory
		一个比较通用的 BeanFactory 实现
		同时也实现了 BeanDefinitionRegistry 接口
			因此它就承担了 bean 的注册管理工作
	
		getBean
		containBean
		getType
		getAliases
```
## Extend
```md
在 bean 生命周期的不同阶段，Spring 提供了不同的扩展点来改变 bean 的命运
```