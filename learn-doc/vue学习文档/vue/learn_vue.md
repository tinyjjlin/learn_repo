# vue 学习比较

----
## vue cli 安装使用
要求安装最新版本的node.js npm

安装vue cli
```
npm install -g @vue/cli
```

## 创建项目
```
vue create hello-world
```

## npm 命令

```
# install 可以简写为 i
npm install
npm i

#devDependencies  里面的插件只用于开发环境，不用于生产环境，而 dependencies  是需要发布到生产环境的。
#  写入package.json->  dependencies 对象
npm i module_name -S => npm install module_name -Save

#写入package.json -> devDependencies 对象
npm i module_name -D => npm install module_name -save-dev

#全局安装
npm i module_name  -g  

# npm install module 默认写入 dependencies中
```