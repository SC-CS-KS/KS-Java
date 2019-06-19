# 项目管理

## 创建

### 创建多模块项目
* 1. 创建 Maven 项目
```sh
$ mvn archetype:generate -DgroupId=com.sunny -DartifactId=demo -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* 2. 删除 src文件夹
* 3. 修改pom.xml文件
```md
将<packaging>jar</packaging>修改为<packaging>pom</packaging>，pom表示它是一个被继承的模块。
```
* 4. 创建模块
```sh
$ mvn archetype:generate -DgroupId=com.sunny -DartifactId=demo-nio -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Reference
* [使用Maven构建多模块项目](https://www.cnblogs.com/xdp-gacl/p/4242221.html)
