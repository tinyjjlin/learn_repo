# git https http 设置用户名密码

[参考](https://www.cnblogs.com/cheyunhua/p/7945109.html)

```

git config --global credential.helper cache //default 15min
git config --global credential.helper 'cache --timeout=36500'

git config --global credential.helper store//长期存储

http://yourname:passwd@git.../name/project.git

```