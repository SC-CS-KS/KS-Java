# Maven Dependency Scope
```md
用来限制Dependency的作用范围的, 影响 maven 项目在各个生命周期时导入的 package 的状态。
```
* compile
```md
在一个工程 构建，测试，运行的所有阶段在 classpath 中都能找到 Compile Scope 级的 dependency，这是默认级别的。
```
* provided
```md
在构建和测试阶段的 classpath 中才能找到 provided Scope 级别的 Dependency, 如 Servlet api, JSP api,等等

不会将包打入本项目中，只是依赖过来。   
```
* runtime
```md
在构建阶段是不能在 classpath 中找到 runtime Scope 级别的 Dependency，
相反的它们被绑定到了生成的artifact中，并且只能在runtime阶段获取。
```
* test
```md
在test阶段可以获取 Test Scope 级别的 Dependency, 如 Junit 和 TestNG。
```
* system
```md
system Scope 级别的依赖和provided Scope级别的依赖相似，除了这些依赖不是来自仓库，
相反的，通过硬编码方式指定依赖jar包来自文件系统的具体位置。
```
* import
```md
Maven 2.0.9 之后新增
它只使用在<dependencyManagement>中，表示从其它的 pom 中导入 dependency 的配置。
```
```xml
      <dependency>
        <groupId>maven</groupId>
        <artifactId>A</artifactId>
        <version>1.0</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
```
```md
导入A项目中的包配置。
```
