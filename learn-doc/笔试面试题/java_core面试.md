#java core

java 语法

数据类型，字符串string，面向对象，集合，异常，多线程


##1 String SringBuilder，StringBuffer（线程安全的） 区别？
答：String 字符串常量，不可变，
涉及：字符串常量，堆，栈，final

##2 面向对象的四大特点？
抽象，封装，继承，多态。

封装，赢藏类的内部属性和行为，包含对象的内部状态。提高代码的可用性和维护性。

抽象，将方法，或行为从具体对象中抽离出来。实现行为和具体实现的分离。

继承，对象从基类获取变量和方法的能力，实现代码的复用。基类添加属性和方法，对继承
的子类透明。子类也可以自定义变量和方法。

多态，同一消息根据发送对象的不同采用不同的行为，方法。
类多态，分类指向不同子类时，相同方法，有不同行为。
接口实现多态，
继承父类时子类重写父类方法。
同一类方法的重载。

##3重写和重载的区别？
overriding 重写
overloading ,相同的方法名，不同的参数，个数，类型。返回类型可以不同。
##4接口，抽象类。
接口，规范，扩展，回调。
抽象类，为子类提供公共的类型，封装重复的内容（实现），定义抽象方法，子类可以有不同的实实现。

区别：
   interface，1没有构造函数，2必须是public,3一个子类可以有多个接口，4接口变，实现的子类也改变。
   abstract calss。
   ##5 静态方法，静态方法块。
##5 静态方法属于类，不能被子类重写。
##6 静态变量与实例变量的区别。
静态变量存储在类的方法区，实例变量存储在堆中，引用在当前线程栈。

##7 jvm 虚拟机。
jvm深入浅出

jvm 内存区。堆，栈，方法区。
heap,存放对象本身，数组，是共享的。jvm只有一堆。
satck,每个线程包含一个栈区，基本数据类型，和对象的引用。私有的其他栈不能访问。
静态区，方法区，静态变量。
常量是方法区的一部分。

##8 对象的创建
1 new ，2 反射，3 clone（深克隆，浅克隆），序列化
## 9 clone
object 方法。本地方法，由其他语言c,c++实现。

浅拷贝：对其他对象的引用仍然指向原来的对象。

深拷贝：引用其他对象的变量，将指向被复制过的新对象。不在指向原来的对象。
implements cloneable
```
/**
* Return a copy of this object.
*/
public Object clone() {
    Date d = null;
    try {
        d = (Date)super.clone();
        if (cdate != null) {
            d.cdate = (BaseCalendar.Date) cdate.clone();
        }
    } catch (CloneNotSupportedException e) {} // Won't happen
    return d;
}

```


##10 序列化
把对象转换为字节序列的过程称为对象的序列化。
把字节序列恢复为对象的过程称为对象的反序列化。
serialVersionUID
[参考](https://www.cnblogs.com/xdp-gacl/p/3777987.html)
##11 equals（） ==  hascode()
== 比较两基本类型值是否相等。
equals() 比较两个对象是否相同，指向同一个对象
String 比较两值是否相同，需要重写equas()方法

   1.hashCode是为了提高在散列结构存储中查找的效率，在线性表中没有作用。
       2.equals和hashCode需要同时覆盖。
       3.若两个对象equals返回true，则hashCode有必要也返回相同的int数。
       4.若两个对象equals返回false，则hashCode不一定返回不同的int数,但为不相等的对象生成不同hashCode值可以提高哈希表的性能。

       5.若两个对象hashCode返回相同int数，则equals不一定返回true。

       6.若两个对象hashCode返回不同int数，则equals一定返回false。

       7.同一对象在执行期间若已经存储在集合中，则不能修改影响hashCode值的相关信息，否则会导致内存泄露问题。

[hashcode](https://blog.csdn.net/haobaworenle/article/details/53819838)
##11 异常
##12 集合
集合框架中的泛型有什么优点？

Java1.5引入了泛型，所有的集合接口和实现都大量地使用它。泛型允许我们为集合提供一个可以容纳的对象类型，因此，如果你添加其它类型的任何元素，它会在编译时报错。这避免了在运行时出现ClassCastException，因为你将会在编译时得到报错信息。泛型也使得代码整洁，我们不需要使用显式转换和instanceOf操作符。它也给运行时带来好处，因为不会产生类型检查的字节码指令。


ArrayList（对象） 基于数组的列表，Array(基本数据类型) vector  fail-fast快速失败
ArrayList Vector(同步慢) 允许空值
迭代时更改使用CopyOnWriteArralist

HashMap（非线程安全的），键和值允许为空值，HashMap效率比HashTap高

Hashtable(线程安全的)弃用，使用ConcurrentHashMap

TreeMap 遍历时选择使用。

HashMap工作原理，链表散列

Iterator只能向前遍历

 ListIterator可以向前向后遍历

ArraySet

13手写单例模式（饿汉和饱汉模式）和工厂模式？

14 final ，finalize()垃圾回收之前被调用,finally
final 申明集合时，表示集合的引用不可更改。
final定义的类不能被重载
15java 反射机制，实现，代理，动态代理 （spring DI，aop）

#数据结构 算法
## 1 排序算法，时间复杂度
## 2 冒泡算法
## 3 遍历一颗二叉树
## 4 倒排一个LinkedList
## 5 遍历递归目录下的所以文件（非递归，广度，深度，层次遍历）

#内存泄露的原因
对象可以达，但不可用
堆中的对象占用资源不被回收。
gc垃圾回收器，
对象不可达（有向图），
内存泄露，对象占用的内存资源不被回收。
长生命周期的对象持有短生命周期的引用，就很可能会出现内存泄露。

解决办法：
将不用的对象，负null值。
将小对象的作用域。


出现的地方：
集合中出现的
使用equals()进行比较。添加
io操作不及时close()
单列中，有对象的引用。

[内存泄露](https://blog.csdn.net/anxpp/article/details/51325838)

内存溢出，outof memory 申请的内存不够用
解决办法：
1及时是否无用对象
2 字符串处理少用String
3 少用静态变量
4避免集中创建大对象，
5 对象池

#jvm
## jvm堆的基本结构。
新生区，老年区，eden ,sofrom s1 to tenured
从新区向老年区一动

##jvm垃圾算法有哪些，CMS垃圾流程
标记-清除算法 内存碎片

复制算法， 新生代区

标记压缩算法

https://www.cnblogs.com/yulinfeng/p/7163052.html

CMS
https://blog.csdn.net/kobejayandy/article/details/78516471

查看jvm内存使用？

[java tool 工具的使用]（https://www.cnblogs.com/z-sm/p/6745375.html）

jmap -heap pid

jvm配置和调优参数有哪些


#java多线程并发
##1创建线程，保证线程安全
##2 如何实现线程安全的数据结构
##3 如何避免死锁
##4 volatile作用
##5 Threadlocal作用实现
##6 Hashmap在多线程下使用注意什么，为什么？
##7 什么是守护线程？有什么作用？
##8 concurrentHashMap实现原理
##9 sleep,wait,notify,notifyAll 区别
##10 线程如何串行
##11上下文切换时什么意思
##12 可以运行时kill一个线程吗？
##13 什么是条件锁，读写锁，自旋锁，可从写锁？
##14线程池ThreadPoolExecutor实现原理
2017/12/14






