# learn python

## pip

### requirements生成和导入
pip 批量安装包
```python
pip freeze > requirements.txt
pip install -r requirements.txt
```

## virtualenv
为应用创建“隔离”的python运行环境。

可以为每一个应用创建python运行环境。每个应用直接安装的包不受影响。

virtualenv为应用提供了隔离的Python运行环境，解决了不同应用间多版本的冲突问题。

## win 安装使用 virtualenv
```python 
# 1 安装 virtualenv ,virtualenvwrapper

pip3 install virtualenv
pip3 install virtualenvwrapper

#2 为每个项目创建单独的python运行环境（win)

c:

#2.1 创建项目

md myproject
cd myproject

# 2.2 创建独立的python运行环境，--no-site-packages 已经安装到系统Python环境中的所有第三方包都不会复制过来

virtualenv --no-site-package venv

# 2.3 激活虚拟环境
activate.bat

# 2.4 退出虚拟环境
deactivate.bat
```

## gunicorn
参考: [refs](https://www.cnblogs.com/xybaby/p/6296974.html)

gunicorn是一个python Wsgi http server，只支持在Unix系统上运行，来源于Ruby的unicorn项目。Gunicorn使用prefork master-worker模型（在gunicorn中，master被称为arbiter），能够与各种wsgi web框架协作。gunicorn的文档是比较完善的，这里也有部分中文翻译，不过还是建议直接读英文文档。笔者并没有在项目中真正使用过gunicorn，阅读其源码只要是为了了解其master worker模型，如有纰漏，还请多多指教。
 
gunicorn的安装非常简单，pip install guncorn 即可。后续如果用到异步的worker模型，还需要安装对应的模块（如gevent）