# Java GC

## 发展
* Serial
* Throughput
* CMS（Concurrent Mark Sweep）
* G1（Garbage-First）

### 对比
```md
并行 GC 面向吞吐量
G1 则侧重于低延迟 GC
```

## 应用
```md
Throughput 在 Java 9 之前是 JVM的默认GC。
CMS 在 Java 9 中已经被废弃，但了解CMS的行为对理解G1会有一些帮助。
从JDK 1.6时代就开始进入开发者的视野，直到 Java 9 正式成为Hotspot的默认GC。
```


## 参考
* [G1](https://www.jianshu.com/p/a3e6a9de7a5d?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io)