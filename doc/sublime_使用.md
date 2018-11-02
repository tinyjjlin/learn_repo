#sublime text3使用
##1.sublime 本身的设置，操作
1. 显示控制台
```
contrl + `
```
2. 安装插件
  1. 下载插件直接放入packages目录下
  2. 在控制台下添加代码，使用package control组件安装
```
import urllib.request,os; pf = 'Package Control.sublime-package'; ipp = sublime.installed_packages_path(); urllib.request.install_opener( urllib.request.build_opener( urllib.request.ProxyHandler()) ); open(os.path.join(ipp, pf), 'wb').write(urllib.request.urlopen( 'http://sublime.wbond.net/' + pf.replace(' ','%20')).read())
```

打开package control

  ```
ctrl+shift+p
  ```
##2 集成markdown



