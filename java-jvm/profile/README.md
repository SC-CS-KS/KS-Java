# Java Profile

## OOM Profile 实践
* 分析栈
```md
1. 使用 jstack pid > jstack.log 保存了线程栈的现场。
2. 线程数
    grep 'java.lang.Thread.State' jstack.log | wc -l
3. 线程状态
    grep -A 1 'java.lang.Thread.State' jstack.log | grep -v 'java.lang.Thread.State' | sort | uniq -c |sort -n
```
* 分析堆文件
```md
1. 使用 jmap -dump:format=b,file=heap.log pid 保存堆现场
2. 使用 MAT 分析 jvm heap
```
* 分析代码


## Reference
* [《Java 性能权威指南》](https://github.com/SunnnyChan/sc.ebooks/blob/master/language/java/java-performance-the-definitive-guide)
