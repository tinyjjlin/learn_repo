# vue 开发笔记



------

## 安装cnpm

```
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

## 安装 vue
```

npm install vue
```

## vue-cli  webpack

vue-cli 提供一个官方命令行工具，可用于快速搭建大型单页应用。该工具提供开箱即用的构建工具配置，带来现代化的前端开发流程。只需几分钟即可创建并启动一个带热重载、保存时静态检查以及可用于生产环境的构建配置的项目：

使用vue-cli 创建基于webpack模板的新项目
```
vue init webpack-simple my-project

vue init webpack my-project
# 安装依赖的模块
cnpm install
npm install
#运行项目
cnpm run dev
npm run dev
```

```
构建新项目（基于webpack 3.8.1，前提安装node环境）

$ npm install --global vue-cli
$ vue init webpack my-project
$ cd my-project
$ npm install
$ npm run dev
```

## vue-loader

vue-loader其实就是一个webpack的loader。用来把vue组件转换成可部署的js,html,css模块。如果要想在vue项目中使用scss,要告诉vue-loader怎么样解析我的scss文件。

在webpack中，所有预处理器都要匹配相应的loader,vue-loader允许其他的webpack loader处理组件中的代码，然后它根据lang属性自动判断出要使用的loaders。 因为在新版本的vue-cli已经帮我们把sass-loader配置好了，放在了util.js里面。 所以无需在webpack.base.config.js对scss进行配置，只要安装处理sass/scss的loader，就能在vue中使用scss了。

## webpack 基础配置
```
npm install
npm install webpack --save-dev
npm install webpack-dev-server --save-dev
```

## wepack 功能配置

## package.json
```
常用命令

npm i --save packageName   安装依赖包

npm i --save-dev packageName

npm i webpack@1.2.1   安装指定版本的包，版本号用@符号连接
```

scripts

通过设置这个可以使NPM调用一些命令脚本，封装一些功能。

"scripts": {"start": "babel-node src/pages/index.js",
    "build": "webpack --config config/webpack.config.js",
    "watch": "webpack-dev-server --config config/webpack.config.js --hot --inline --progress"
  }
config

添加一些设置，可以供scripts读取用，同时这里的值也会被添加到系统的环境变量中。

"config": {
  "port": "8080"
}
npm start的时候会读取到npm_package_config_port环境变量。

dependencies

指定依赖的其它包，这些依赖是指包发布后正常执行时所需要的，也就是线上需要的包。使用下面的命令来安装：

npm install --save packageName
如果是开发中依赖的包，可以在devDependencies设置。

devDependencies

这些依赖只有在开发时候才需要。使用下面的命令来安装：

npm install --save-dev packageName 


## model  CommonJs模块 ES模块
CommonJS模块

CommonJS规范规定，每个模块内部，module变量代表当前模块。这个变量是一个对象，它的exports属性（即module.exports）是对外的接口。加载某个模块，其实是加载该模块的module.exports属性。

require方法用于加载模块。

```
var exports = module.exports

module.exports.x =x
module.exports.addX = addX

var example = require('./example.js');
```

ES6模块规范
export import

```
export var m =1

var m =1
export {m}

var n =1
export {n as m}

//export-default.js
//使用export default命令，为模块指定默认输出。
export default function(){

}

```

export  export-defult 区别


## 开发 issue说明

### 1  Vue2.0 render:h => h(App)  [fix](https://www.cnblogs.com/whkl-m/p/6970859.html)

### 2 import '@'
[fix](https://www.cnblogs.com/boshow/p/8758927.html)

webpack.conf.js
```
 resolve: {
    extensions: ['.js', '.vue', '.json'],
    alias: {
      '@': resolve('src')
    }
  },

```

### 3 webpack Resolve 解析
webpack在启动后会从配置的入口模块触发找出所有依赖的模块，Resolve配置webpack如何寻找模块对应的文件。webpack内置JavaScript模块化语法解析功能，默认会采用模块化标准里约定好的规则去寻找，但你可以根据自己的需要修改默认的规则。

[fix](https://segmentfault.com/a/1190000013176083?utm_source=tag-newest)

### 4 webpack 总结
[fix](https://segmentfault.com/a/1190000012625058)

webpack 是一个前端常用的模块化打包工具，它的作用就是将 JavaScript 代码或者其他静态文件进行分析、压缩，最终合并打包成浏览器可以识别的代码。关于模块化，拿 ES6 module 来说，可以通过 export 导出，import 导入的代码块或者静态资源都可以成为模块。从入口文件开始，webpack 会通过递归的方式将应用程序所依赖的模块进行打包成一个或者多个 bundle。

### 5 webpack loader 
[fix](https://segmentfault.com/a/1190000004690467)

### 6 webpack 如何实现路由功能
https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80