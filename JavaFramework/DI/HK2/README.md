# [glassfish-hk2](https://javaee.github.io/hk2/)
- A light-weight and dynamic dependency injection framework
```md
HK2是JavaSE环境中JSR-330的一个实现。
HK2提供了一个API来控制其操作，并能够自动将服务加载到容器中。
它是GlassFish V3和V4应用程序服务器以及其他产品的基础。
HK2还具有强大的功能，可用于执行查找服务或自定义注入等任务，以及允许用户与其他容器技术连接的多种可扩展性功能。
```

## [API](https://javaee.github.io/hk2/api-overview.html)
* ServiceLocator
```md
是HK2中最基本的服务，ServiceLocator表示查找服务的注册表以及有关服务的信息（称为描述符）绑定到注册表中的位置。
ServiceLocator本身在其自己的注册表中表示为服务;它始终是绑定到自己的注册表中的第一个服务。

ServiceLocators在JVM中唯一命名，每个都具有唯一的定位器ID。
可以使用ServiceLocatorFactory创建或查找ServiceLocator。
ServiceLocatorFactory通常使用META-INF / services中指定的ServiceLocatorGenerator的默认实现。

可以通过在类路径中早于提供的实现具有ServiceLocatorGenerator实现的不同META-INF /服务规范来更改默认实现。

ServiceLocatorGenerator的实现也可以直接提供给ServiceLocatorFactory create方法。
```
```md
使用ServiceLocatorFactory创建ServiceLocator后，它将至少包含三个服务：
1. Itself (see ServiceLocator)
2. The default JSR-330 resolver (see InjectionResolver)
3. A service for configuring further services (see DynamicConfigurationService)
```
