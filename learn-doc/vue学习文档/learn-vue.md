# learn vue

## vue-cli3

###  default features to select
1. Babel
2. TypeScript
3. PWA Support
4. CSS Pre-processors
5. Linter/Formatter
6. Unit Testing
7. ESE Testing

### reference
1. [Vue CLi3入门](https://www.jianshu.com/p/cf9b56efd3b8)


### 环境变量设置
reference:

1 [[Vue CLI 3] 环境变量和模式配置实践与源码分析](https://segmentfault.com/a/1190000016194157)

### package.json 详细
reference:
1. [package.json详解](https://www.cnblogs.com/nullcc/p/5829218.html)

### npm 命令 详解

package.json 文件里面的 devDependencies  和 dependencies 对象有什么区别呢？
devDependencies  里面的插件只用于开发环境，不用于生产环境，而 dependencies  是需要发布到生产环境的。

```
# write to dependencies
npm install(i) [module_name] -S 
npm install module_name --save

# write to devDependencies
npm install module_name -D
npm i module_name --save-dev
```

## v-for
```
     <ul>
            <li>index key value</li>
            <li
              v-for="(value, key, index) in item.requestParams"
            >{{ index }}. {{ key }} : {{ value }}</li>
          </ul>
```