# java 知识点补充

....
### 1 java 接口可以定义有成员变量

接口中可以含有变量，但是接口中的变量会被隐式的指定为 public static final 变量（并且只能是 public，用 private 修饰会报编译错误）。