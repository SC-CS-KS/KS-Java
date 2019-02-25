# [jstat - JVM Statistics Monitoring Tool](https://docs.oracle.com/javase/7/docs/technotes/tools/share/jstat.html)

* GC 统计
```shell
$ jstat -gc 734 1000
 S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT
34816.0 5632.0  0.0   5542.3 2251264.0 2085840.5 2829312.0   50835.4   59328.0 57872.7 5888.0 5523.1   1580   93.237   9      3.658   96.895
34816.0 5632.0  0.0   5542.3 2251264.0 2101587.6 2829312.0   50835.4   59328.0 57872.7 5888.0 5523.1   1580   93.237   9      3.658   96.895
```
```md
S0C：第一个幸存区的大小
S1C：第二个幸存区的大小
S0U：第一个幸存区的使用大小
S1U：第二个幸存区的使用大小
EC：伊甸园区的大小
EU：伊甸园区的使用大小
OC：老年代大小
OU：老年代使用大小
MC：方法区大小
MU：方法区使用大小
CCSC:压缩类空间大小
CCSU:压缩类空间使用大小
YGC：年轻代垃圾回收次数
YGCT：年轻代垃圾回收消耗时间
FGC：老年代垃圾回收次数
FGCT：老年代垃圾回收消耗时间
GCT：垃圾回收消耗总时间
```

* GC 总体统计
```shell
$ jstat -gcutil 734 1000
  S0     S1     E      O      M     CCS    YGC     YGCT    FGC    FGCT     GCT
 91.70   0.00   5.46   1.80  97.55  93.80   1581   93.248     9    3.658   96.906
 91.70   0.00   6.07   1.80  97.55  93.80   1581   93.248     9    3.658   96.906
```

* Heap 统计
```shell
$ jstat -gccapacity 734 1000
 NGCMN    NGCMX     NGC     S0C   S1C       EC      OGCMN      OGCMX       OGC         OC       MCMN     MCMX      MC     CCSMN    CCSMX     CCSC    YGC    FGC
1397760.0 2446336.0 2375680.0 3072.0 32768.0 2201088.0  2796544.0  4893696.0  2829312.0  2829312.0      0.0 1103872.0  59328.0      0.0 1048576.0   5888.0   1581     9
1397760.0 2446336.0 2375680.0 3072.0 32768.0 2201088.0  2796544.0  4893696.0  2829312.0  2829312.0      0.0 1103872.0  59328.0      0.0 1048576.0   5888.0   1581     9
```
```m
NGCMN：新生代最小容量
NGCMX：新生代最大容量
NGC：当前新生代容量
OGCMN：老年代最小容量
OGCMX：老年代最大容量
OGC	Current old generation capacity (KB).
OC	Current old space capacity (KB).
MCMN:最小元数据容量
MCMX：最大元数据容量
```

* 新生代 GC 统计
```shell
$ jstat -gcnew 734 1000
 S0C    S1C    S0U    S1U   TT MTT  DSS      EC       EU     YGC     YGCT
31232.0 2560.0    0.0 2198.1 15  15 31232.0 2152448.0 350025.9   1582   93.256
31232.0 2560.0    0.0 2198.1 15  15 31232.0 2152448.0 350025.9   1582   93.256
```
```md
TT:对象在新生代存活的次数
MTT:对象在新生代存活的最大次数
DSS:期望的幸存区大小
```

* 新生代 内存 统计
```shell
$ jstat -gcnewcapacity 734 1000
  NGCMN      NGCMX       NGC      S0CMX     S0C     S1CMX     S1C       ECMX        EC      YGC   FGC
 1397760.0  2446336.0  2373120.0 815104.0  31232.0 815104.0   2560.0  2445312.0  2152448.0  1582     9
 1397760.0  2446336.0  2373120.0 815104.0  31232.0 815104.0   2560.0  2445312.0  2152448.0  1582     9
```

* 老年代 GC 统计
```shell
$ jstat -gcold 734 1000
```
* 老年代 内存 统计
```shell
$ jstat -gcoldcapacity 734 1000
```
* 元数据空间 统计
```shell
$ jstat -gcmetacapacity 734 1000
```

* 类加载统计
```shell
$ jstat -class 734 1000
Loaded  Bytes  Unloaded  Bytes     Time
  8031 15954.0       87    97.0       5.98
  8031 15954.0       87    97.0       5.98
```
```md
Loaded:加载class的数量
Bytes：所占用空间大小
Unloaded：未加载数量
Bytes:未加载占用空间
Time：时间
```

* 编译统计
```shell
$ jstat -compiler 734 1000
Compiled Failed Invalid   Time   FailedType FailedMethod
   17655      2       0   163.49          1 com/mysql/jdbc/AbandonedConnectionCleanupThread run
   17655      2       0   163.49          1 com/mysql/jdbc/AbandonedConnectionCleanupThread run
```
```md
Compiled：编译数量
Failed：失败数量
Invalid：不可用数量
Time：时间
FailedType：失败类型
FailedMethod：失败的方法
```

* JVM 编译方法 统计
```shell
$ jstat -printcompilation 734 1000
Compiled  Size  Type Method
   17654    252    1 org/apache/hadoop/hive/ql/parse/HiveParser_SelectClauseParser synpred2_SelectClauseParser
   17654    252    1 org/apache/hadoop/hive/ql/parse/HiveParser_SelectClauseParser synpred2_SelectClauseParser
```
```md
Compiled：最近编译方法的数量
Size：最近编译方法的字节码数量
Type：最近编译方法的编译类型。
Method：方法名标识。
```

## 参考
* [查看JVM的GC情况]