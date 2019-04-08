# java　笔试面试题

---
## 
 原文：https://www.toutiao.com/i6581730497943044611/

java 基础

    八种基本数据类型的大小，以及他们的封装类
    引用数据类型
    Switch能否用string做参数
    equals与==的区别
    自动装箱，常量池
    Object有哪些公用方法
    Java的四种引用，强弱软虚，用到的场景
    Hashcode的作用
    HashMap的hashcode的作用
    为什么重载hashCode方法？
    ArrayList、LinkedList、Vector的区别
    String、StringBuffer与StringBuilder的区别
    Map、Set、List、Queue、Stack的特点与用法
    HashMap和HashTable的区别
    JDK7与JDK8中HashMap的实现
    HashMap和ConcurrentHashMap的区别，HashMap的底层源码
    ConcurrentHashMap能完全替代HashTable吗
    为什么HashMap是线程不安全的
    如何线程安全的使用HashMap
    多并发情况下HashMap是否还会产生死循环
    TreeMap、HashMap、LindedHashMap的区别
    Collection包结构，与Collections的区别
    try?catch?finally，try里有return，finally还执行么
    Excption与Error包结构，OOM你遇到过哪些情况，SOF你遇到过哪些情况
    Java(OOP)面向对象的三个特征与含义
    Override和Overload的含义去区别
    Interface与abstract类的区别
    Static?class?与non?static?class的区别
    java多态的实现原理
    foreach与正常for循环效率对比
    Java?IO与NIO
    java反射的作用于原理
    泛型常用特点
    解析XML的几种方式的原理与特点：DOM、SAX
    Java1.7与1.8,1.9,10 新特性
    设计模式：单例、工厂、适配器、责任链、观察者等等
    JNI的使用
    AOP是什么
    OOP是什么
    AOP与OOP的区别

多线程

    什么是线程？
    什么是线程安全和线程不安全？
    什么是自旋锁？
    什么是Java内存模型？
    什么是CAS？
    什么是乐观锁和悲观锁？
    什么是AQS？
    什么是原子操作？在Java Concurrency API中有哪些原子类(atomic classes)？
    什么是Executors框架？
    什么是阻塞队列？如何使用阻塞队列来实现生产者-消费者模型？
    什么是Callable和Future?
    什么是FutureTask?
    什么是同步容器和并发容器的实现？
    什么是多线程？优缺点？
    什么是多线程的上下文切换？
    ThreadLocal的设计理念与作用？
    ThreadPool（线程池）用法与优势？
    Concurrent包里的其他东西：ArrayBlockingQueue、CountDownLatch等等。
    synchronized和ReentrantLock的区别？
    Semaphore有什么作用？
    Java Concurrency API中的Lock接口(Lock interface)是什么？对比同步它有什么优势？
    Hashtable的size()方法中明明只有一条语句”return count”，为什么还要做同步？
    ConcurrentHashMap的并发度是什么？
    ReentrantReadWriteLock读写锁的使用？
    CyclicBarrier和CountDownLatch的用法及区别？
    LockSupport工具？
    Condition接口及其实现原理？
    Fork/Join框架的理解?
    wait()和sleep()的区别?
    线程的五个状态（五种状态，创建、就绪、运行、阻塞和死亡）?
    start()方法和run()方法的区别？
    Runnable接口和Callable接口的区别？
    volatile关键字的作用？
    Java中如何获取到线程dump文件？
    线程和进程有什么区别？
    线程实现的方式有几种（四种）？
    高并发、任务执行时间短的业务怎样使用线程池？并发不高、任务执行时间长的业务怎样使用线程池？并发高、业务执行时间长的业务怎样使用线程池？
    如果你提交任务时，线程池队列已满，这时会发生什么？
    锁的等级：方法锁、对象锁、类锁?
    如果同步块内的线程抛出异常会发生什么？
    并发编程（concurrency）并行编程（parallellism）有什么区别？
    如何保证多线程下 i++ 结果正确？
    一个线程如果出现了运行时异常会怎么样?
    如何在两个线程之间共享数据?
    生产者消费者模型的作用是什么?
    怎么唤醒一个阻塞的线程?
    Java中用到的线程调度算法是什么
    单例模式的线程安全性?
    线程类的构造方法、静态块是被哪个线程调用的?
    同步方法和同步块，哪个是更好的选择?
    如何检测死锁？怎么预防死锁？

设计模式

    装饰器模式
    工厂模式
    单例模式
    观察者模式
    动态代理模式
    适配器模式
    模板模式
    策略模式

JVM

    内存模型以及分区，需要详细到每个区放什么。
    对象创建方法，对象的内存分配，对象的访问定位。
    GC的两种判定方法：引用计数与引用链。
    GC的三种收集方法：标记清除、标记整理、复制算法的原理与特点，分别用在什么地方，如果让你优化收集方法，有什么思路？
    GC收集器有哪些？CMS收集器与G1收集器的特点。
    Minor?GC与Full?GC分别在什么时候发生？
    几种常用的内存调试工具：jmap、jstack、jconsole。
    类加载的五个过程：加载、验证、准备、解析、初始化。
    双亲委派模型：Bootstrap?ClassLoader、Extension?ClassLoader、ApplicationClassLoader。
    分派：静态分派与动态分派。
    JVM过去过来就问了这么些问题，没怎么变，内存模型和GC算法这块问得比较多，可以在网上多找几篇博客来看看。
    推荐书籍：《深入理解java虚拟机》

数据结构与算法

    链表与数组。
    队列和栈，出栈与入栈。
    链表的删除、插入、反向。
    字符串操作。
    Hash表的hash函数，冲突解决方法有哪些。
    各种排序：冒泡、选择、插入、希尔、归并、快排、堆排、桶排、基数的原理、平均时间复杂度、最坏时间复杂度、空间复杂度、是否稳定。
    快排的partition函数与归并的Merge函数。
    对冒泡与快排的改进。
    二分查找，与变种二分查找。
    二叉树、B+树、AVL树、红黑树、哈夫曼树。
    二叉树的前中后续遍历：递归与非递归写法，层序遍历算法。
    图的BFS与DFS算法，最小生成树prim算法与最短路径Dijkstra算法。
    KMP算法。
    排列组合问题。
    动态规划、贪心算法、分治算法。（一般不会问到）
    大数据处理：类似10亿条数据找出最大的1000个数.........等等
    算法的话其实是个重点，因为最后都是要你写代码，所以算法还是需要花不少时间准备，这里有太多算法题，写不全，我的建议是没事多在OJ上刷刷题（牛客网、leetcode等），剑指offer上的算法要能理解并自己写出来，编程之美也推荐看一看

数据库

    事务四大特性（ACID）原子性、一致性、隔离性、持久性
    数据库隔离级别，每个级别会引发什么问题，mysql默认是哪个级别
    innodb和myisam存储引擎的区别
    MYSQL的两种存储引擎区别（事务、锁级别等等），各自的适用场景
    查询语句不同元素（where、jion、limit、group by、having等等）执行先后顺序
    数据库的优化（从sql语句优化和索引两个部分回答）
    索引有B+索引和hash索引，各自的区别
    B+索引数据结构，和B树的区别
    索引的分类（主键索引、唯一索引），最左前缀原则，哪些情况索引会失效
    聚集索引和非聚集索引区别。
    有哪些锁（乐观锁悲观锁），select时怎么加排它锁
    关系型数据库和非关系型数据库区别
    数据库三范式，根据某个场景设计数据表（可以通过手绘ER图）
    数据库的读写分离、主从复制
    使用explain优化sql和索引
    long_query怎么解决
    内连接、外连接、交叉连接、笛卡儿积等
    死锁判定原理和具体场景，死锁怎么解决
    varchar和char的使用场景。
    mysql并发情况下怎么解决（通过事务、隔离级别、锁）
    数据库崩溃时事务的恢复机制（REDO日志和UNDO日志）
    查询语句不同元素（where、jion、limit、group by、having等等）执行先后顺序

Spring

    IOC和DI是什么？
    Spring IOC 的理解，其初始化过程？
    BeanFactory 和 FactoryBean的区别？
    BeanFactory和ApplicationContext的区别？
    ApplicationContext 上下文的生命周期？
    Spring Bean 的生命周期？
    Spring AOP的实现原理？
    Spring 是如何管理事务的，事务管理机制？
    Spring 的不同事务传播行为有哪些，干什么用的？
    Spring 中用到了那些设计模式？
    Spring MVC 的工作原理？
    Spring如何解决循环依赖？
    Spring 如何保证 Controller 并发的安全？

Netty

    BIO、NIO和AIO
    Netty 的各大组件
    Netty的线程模型
    TCP 粘包/拆包的原因及解决方法
    了解哪几种序列化协议？包括使用场景和如何去选择
    Netty的零拷贝实现
    Netty的高性能表现在哪些方面

缓存

    Redis用过哪些数据数据，以及Redis底层怎么实现
    Redis缓存穿透，缓存雪崩
    如何使用Redis来实现分布式锁
    Redis的并发竞争问题如何解决
    Redis持久化的几种方式，优缺点是什么，怎么实现的
    Redis的缓存失效策略
    Redis集群，高可用，原理
    Redis缓存分片
    Redis的数据淘汰策略

技术框架

    看过哪些开源框架的源码
    为什么要用Redis，Redis有哪些优缺点？Redis如何实现扩容？
    Netty是如何使用线程池的，为什么这么使用
    为什么要使用Spring，Spring的优缺点有哪些
    Spring的IOC容器初始化流程
    Spring的IOC容器实现原理，为什么可以通过byName和ByType找到Bean
    Spring AOP实现原理
    消息中间件是如何实现的，技术难点有哪些

技术深度

    事务的实现原理
    有没有看过JDK源码，看过的类实现原理是什么。
    HTTP协议
    TCP协议
    一致性Hash算法
    JVM如何加载字节码文件
    类加载器如何卸载字节码
    IO和NIO的区别，NIO优点
    Java线程池的实现原理，keepAliveTime等参数的作用。
    HTTP连接池实现原理
    数据库连接池实现原理
    数据库的实现原理

分布式

    什么是CAP定理
    CAP 理论和 BASE 理论
    CAP 理论
    CAP 理论和最终一致性
    最终一致性实现方式
    CAP 理论和 BASE 理论
    一致性 Hash
    分布式事务，两阶段提交。
    如何实现分布式锁
    如何实现分布式Session
    如何保证消息的一致性
    负载均衡
    正向代理（客户端代理）和反向代理（服务器端代理）
    CDN实现原理
    怎么提升系统的QPS和吞吐量
    Dubbo的底层实现原理和机制
    描述一个服务从发布到被消费的详细过程
    分布式系统怎么做服务治理
    接口的幂等性的概念
    消息中间件如何解决消息丢失问题
    Dubbo的服务请求失败怎么处理
    重连机制会不会造成错误
    对分布式事务的理解
    如何实现负载均衡，有哪些算法可以实现？
    Zookeeper的用途，选举的原理是什么？
    数据的垂直拆分水平拆分。
    zookeeper原理和适用场景
    zookeeper watch机制
    redis/zk节点宕机如何处理
    分布式集群下如何做到唯一序列号
    用过哪些MQ，怎么用的，和其他mq比较有什么优缺点，MQ的连接是线程安全的吗
    MQ系统的数据如何保证不丢失
    列举出你能想到的数据库分库分表策略；分库分表后，如何解决全表查询的问

系统架构

    如何搭建一个高可用系统
    哪些设计模式可以增加系统的可扩展性
    介绍设计模式，如模板模式，命令模式，策略模式，适配器模式、桥接模式、装饰模式，观察者模式，状态模式，访问者模式。
    抽象能力，怎么提高研发效率。
    什么是高内聚低耦合，请举例子如何实现
    什么情况用接口，什么情况用消息
    如果AB两个系统互相依赖，如何解除依赖
    如何写一篇设计文档，目录是什么
    什么场景应该拆分系统，什么场景应该合并系统
    系统和模块的区别，分别在什么场景下使用
    实战能力
    有没有处理过线上问题？出现内存泄露，CPU利用率标高，应用无响应时如何处理的。
    开发中有没有遇到什么技术问题？如何解决的
    如果有几十亿的白名单，每天白天需要高并发查询，晚上需要更新一次，如何设计这个功能。
    新浪微博是如何实现把微博推给订阅者
    Google是如何在一秒内把搜索结果返回给用户的。
    12306网站的订票系统如何实现，如何保证不会票不被超卖。
    如何实现一个秒杀系统，保证只有几位用户能买到某件商品。

LINUX

    硬链接和软连接区别
    kill用法，某个进程杀不掉的原因（进入内核态，忽略kill信号）
    linux用过的命令
    系统管理命令（如查看内存使用、网络情况）
    管道的使用 |
    grep的使用，一定要掌握，每次都会问在文件中查找
    shell脚本
    find命令
    awk使用

TCP/IP

    OSI与TCP/IP各层的结构与功能，都有哪些协议。
    TCP与UDP的区别。
    TCP报文结构。
    TCP的三次握手与四次挥手过程，各个状态名称与含义，TIMEWAIT的作用。
    TCP拥塞控制。
    TCP滑动窗口与回退N针协议。
    Http的报文结构。
    Http的状态码含义。
    Http?request的几种类型。
    Http1.1和Http1.0的区别
    Http怎么处理长连接。
    Cookie与Session的作用于原理。
    电脑上访问一个网页，整个过程是怎么样的：DNS、HTTP、TCP、OSPF、IP、ARP。
    Ping的整个过程。ICMP报文是什么。
    C/S模式下使用socket通信，几个关键函数。
    IP地址分类。
    路由器与交换机区别。
    网络其实大体分为两块，一个TCP协议，一个HTTP协议，只要把这两块以及相关协议搞清楚，一般问题不大。
    推荐书籍：《TCP/IP协议族》

软能力

    如何学习一项新技术，比如如何学习Java的，重点学习什么
    有关注哪些新的技术
    工作任务非常多非常杂时如何处理
    项目出现延迟如何处理
    和同事的设计思路不一样怎么处理
    如何保证开发质量
    职业规划是什么？短期，长期目标是什么
    团队的规划是什么
    能介绍下从工作到现在自己的成长在那里
    说说你认为的服务端开发工程师应该具备哪些能力
    网络必备，高并发，JVM必会，各种分布式技术，看源码的能力。
    说说你认为的架构师是什么样的，架构师主要做什么。

