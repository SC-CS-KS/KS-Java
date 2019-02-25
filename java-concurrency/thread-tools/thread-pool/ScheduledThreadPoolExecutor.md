# ScheduledThreadPoolExecutor








## 与 java.util.Timer
```md
1. Timer 对系统时钟的变化敏感
2. Timer 只有一个执行线程
3. Runtime Exceptions 会导致 Timer 唯一的执行线程被 Kill，
  ScheduledThreadExecutor 不仅捕获运行时异常，还允许根据需要处理它们。
```