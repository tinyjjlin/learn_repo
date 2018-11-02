# Django
## Django安装过程

Django 官网:[address](https://www.djangoproject.com/download/)

*步骤*

###1. 下载django
```
pip install django
```

###2. 验证
```python
   import django
   print(django.get_version())
```
###3. django 使用

1. create django project
```
    django-admin startproject [projectname]
```
2. create app (model)
```
    django-admin startapp [appname]
```
3. syncrhonize data with db (models.py)
```

   python manage.py migrate   #create table structe

   python manage.py makemigrations #myapp  notify django,myapp's table structe update

   python manage.py migreate myapp #excute the talbe sturcte of myapp to mysql
 start server

   python manage.py runserver 0.0.0.0:8000
```

###4. 学习重点
1. django管理工具 manage.py

