# mvn

```shell
$ mvn -Dmaven.test.skip=true package
```
* help
```md
help:active-profiles 列出当前构建中活动的Profile（项目的，用户的，全局的）。
help:effective-pom 显示当前构建的实际POM，包含活动的Profile。
help:effective-settings 打印出项目的实际settings, 包括从全局的 settings和用户级别 settings继承的配置。
help:describe 描述插件的属性。它不需要在项目目录下运行。但是你必须提供你想要描述插件的 groupId 和 artifactId。
```
