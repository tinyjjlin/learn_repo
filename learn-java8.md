# learn java8

## Java 8 新特性

reference: [https://www.runoob.com/java](https://www.runoob.com/java)

### 1 Lambda表达式
闭包；
允许把函数作为一个方法的参数。

注意：

变量作用域
lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。

### 2 方法引用
方法引用使用一对冒号 ::

```
# demo 
system.out::println
```

### 3 函数式接口

函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。

### 4 默认方法

默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。

```
public class Java8Tester {
   public static void main(String args[]){
      Vehicle vehicle = new Car();
      vehicle.print();
   }
}
 
interface Vehicle {
   default void print(){
      System.out.println("我是一辆车!");
   }
    
   static void blowHorn(){
      System.out.println("按喇叭!!!");
   }
}
 
interface FourWheeler {
   default void print(){
      System.out.println("我是一辆四轮车!");
   }
}
 
class Car implements Vehicle, FourWheeler {
   public void print(){
      Vehicle.super.print();
      FourWheeler.super.print();
      Vehicle.blowHorn();
      System.out.println("我是一辆汽车!");
   }
}

```


### 5 Stream

数据源： 集合；数组；I/O channel,generaor
聚合操作： fillter,map,reduce,find,match,sorted

生成流程（stream）: stream(); parallelStream()

```
#map 
List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());

# collectors
List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
 
System.out.println("筛选列表: " + filtered);
String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
System.out.println("合并字符串: " + mergedString);

```


1. Spliterator

reference: [java8 stream 中Spliterator的使用(一)](https://blog.csdn.net/silver9886/article/details/87917823)


### 6 Optional类

Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。

## 7 Nashorn,JavaScript引擎

### 8 新的日期时间API


## 四大核心函数式接口Funtion,Consumer,Supplier,Predicate
```
Function<T, R> 

T：入参类型，R：出参类型

调用方法：R apply(T t); 

定义函数示例：Function<Integer, Integer> func = p -> p * 10;    // 输出入参的10倍

调用函数示例：func.apply(10);    // 结果100

Consumer<T>

T：入参类型；没有出参

调用方法：void accept(T t);

定义函数示例：Consumer<String> consumer= p -> System.out.println(p);    // 因为没有出参，常用于打印、发送短信等消费动作

调用函数示例：consumer.accept("18800008888");

Supplier<T>

T：出参类型；没有入参

调用方法：T get();

定义函数示例：Supplier<Integer> supplier= () -> 100;    // 常用于业务“有条件运行”时，符合条件再调用获取结果的应用场景；运行结果须提前定义，但不运行。

调用函数示例：supplier.get();

Predicate<T>

T：入参类型；出参类型是Boolean

调用方法：boolean test(T t);

定义函数示例：Predicate<Integer> predicate = p -> p % 2 == 0;    // 判断是否、是不是偶数

调用函数示例：predicate.test(100);    // 运行结果true

```