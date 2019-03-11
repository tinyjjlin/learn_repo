# IDEA 工具的使用

---------------------------

##  maven配置

1 maven 系统统一配置？

## idea 中git 的使用


## idea 中常用插件

1. Alibaba Java Coding Guidelines 阿里巴巴Java开发规约
2. GSONformat  json 生成java对象
3. stackoverflow
4. Background Image Plus
5. Lombok
6. Background Image Plus 
7. Markdown support、Maven Helper
8. CodeGlance
9. activate-power-mode
10. AceJump
11. Shifter
12. String Manipulation
13. SQL Query Plugin

## idea 中配置java注解
类注解，方法注解（方法注解如何显示多参数，返回类型不需要返回全名称）

```
groovyScript("if(\"${_1}\".length() == 2) {return '';} else {def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList();for(i = 0; i < params.size(); i++) {if(i<(params.size()-1)){result+=' * @param ' + params[i] + ' : ' + '\\n'}else{result+=' * @param ' + params[i] + ' : '}}; return result;}", methodParameters()); 
```

```
groovyScript("def returnType = \"${_1}\"; def result = ' * @return : ' + returnType; return result;", methodReturnType());

```

