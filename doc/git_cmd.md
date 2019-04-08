# git 学习

--------------------------------------
安装使用配置

什么是ss,sshkey？可以不用密码连接。

win生成sshkey

```
ssh-keygen -t rsa -C "794549197@qq.ocm"
```

## 1 git 配置

-------------------------------------
1. 配置你的用户名和密码
```
 git config --global user.name "wirelessqa"
 git config --global user.email wirelessqa.me@gmail.com
```
2. 配置客户端长期存储用户各和密码
```
git config --global credential.helper store
```
3. 配置你的比较工具
git config --global merge.tool vimdiff

4. 检查你的配置
```
git config --list
```
## 2 git 使用

-----------------------------------

### 2.1

 使用情况：1本地项目上传到远程仓库中；2从远程仓库中拉取项目。

1. 将本地项目上传到远程仓库
```
//获取远程仓库
git remote add  [remote_respo_name] [remote_res_addrress]
```
2. 从远程仓库拉取项目
```
git clone [remote add]
```
3. 第一次推送master分支所有内容
```
git push -u [remote_respo_name] master
```

### 3 常用命令
1. 查看远程仓库
```
git remote
git remote -v
```
2. 取消与远程仓库的关联
```
git remote  remove  relative_origin
```
3. 查看所有分支，包括远程仓库分支
```
git branch -a
```

## 4 git pull 使用
[git pull 详细说明](https://www.yiibai.com/git/git_pull.html)

 ``git pull``相当于(``git fetch``,``git merge``)

``git pull --rebase``详细使用？


## 5 git push 使用

---
1. 本地的代码替换git仓库内容

`` git push -f  ``

2. push 到远程指定的分支上
 
``git push --set-upstream java_origin master``

3. pubsh到远程仓库，并创建分支，如果分支不存在

``git push  -u remote_respo_Name  remote_branch``


## 6 实现本地分支与远程分支的关联
```
git branck --track  loacal_branch  remote/remote_branch
```

## 7 分支操作
1. 创建分支
```
//1基于master创建分支，在master上创建分支
git branch develop master
//2 创建分支，并切换到该分支
git checkout -b develop master
//切换分支
git checkout develop
```
2. 新建分支的push,上传
```
//新建的分支要和远程的分支关联
//1 origin 上存在develop时
git push --set-upstream origin develop
//2 origin上还没有develop时
git push -u origin develop
//3 指定分支
git push -u origin local_branch:remoter_branch
```
3.删除分支
```
git branch -d develop
//强行删除
git branch  -D  feature-v
```
4.查看分支
```
//-a表示查看本地，和远程上的所有分支。
git branch -a(all)/-r
```
5.根据远程仓库上的分支，创建本地分支
```
//clone
git clone github_adress
git checkout -b dev origin/dev
```
6. 合并分支
```
//1现切换到要合并的主分支上
git checkout master
//2将develop分支merge过来，不要参数是快进合并，--no-off在
//master分支上生成一个新的节点。
git merge --no-ff develop
//3有冲突时，手段解决；重写add,commit

```

## 8git non-fast-forward冲突解决
解决：

1 分支关联：

   1. 方法一：
修改配置文件.git/config
```
[branch "master"]
    remote = origin
    merge = refs/heads/master
```

  2. 方法二：
```
git config branch.master.remoter  origin
git config branch.master.merge refs/heads/master

```


## 9 git 查看分支合并图

---
``git log --graph``

## 10 解决bug,回到正在做的工作现场

1. 保存当前的修改的内容，工作现场，因为还没有提交到仓库。

//将工作现场保存在一个stash中。

`` git stash ``

2.为bug添加分支,解决bug,bug分支合并
```
git checkout master
git checkout -b issue-001
fix bug
git add
git commit

git checkout master
git merge --no--ff -m "merge inform"  issue-001
```

3. 返回现场
```
//查看
git stash list
//恢复现场
//同时删除stash中现场标志，
git stash pop
//不删除stash中的现场标志
git stash apply
```

## 11分支操作

1. 本地创建分支，并上传分支到远程仓库
```
git checkout master
git branch dev master
git checkout dev
git push  origin dev

```
2. 在本地新建远程仓库的分支，默认clone只会获取master分支。
```
git clone  [github address]
git branch
git checkout -b dev origin/dev
```
3.在dev分支上操作

1. 先pull(更新)2
```
 git branch --set-upstream-to=origin/dev dev
```
查看是否有冲突，有冲突的话，解决冲突。
2.上传push
```
git push origin dev
```

## 12冲突解决

发生的情况：dev分支上有两个分支，dev_01,dev_02,当dev_01合并分支到dev
上，然后dev_02也想合并到dev上时，发生冲突。这时需要冲突解决。

重点冲突的解决是在dev分支下，add,commit

## 13查看具体文件的修改

1. 以图形化的界面显示文件的修改

`` gitk --follow filename``

## 14查看log
```
//更友好的显示
git log --pretty=oneline --abbrev-commit
```
## 15 标签管理

命令git push origin <tagname>可以推送一个本地标签；

命令git push origin --tags可以推送全部未推送过的本地标签；

命令git tag -d <tagname>可以删除一个本地标签；

命令git push origin :refs/tags/<tagname>可以删除一个远程标签。

1. 创建标签
```
//1在当前commit上创建tag
git tag  version_id
//2指定commit上创建tag
//git log 获取commit id
git log
git tag  learngit_v_0.1 f82370f
//3 加上提示信息
git tag -a v.01 -m "version0.1 released" a46713d
```
2. 查看tag
```
git tag
git show  <tagname> //查看标签具体信息

```

3. 删除标签

```
git tag -d <tagname>
git push origin :refs/tags/v0.9

```

4. 将标签推送远程

```
 git push origin taganme
 git push origin --tags

```


# 问题总结：

-----------------------------#### 1 git add 多个文件夹，多个文件
```
git add  foldername1/ foldername2/
git add  fielname1  filename2
git add  *.type
//add 所以文件
git add -A
git add .
```

#### 2 当提交的时候，在远程分支上有我们本地分支上没有的内容（提交）push会失败。
解决：

1. 设定本地上游分支

git branch --set-upstream-to=remote_respo/remote_branch

2. pull (fetch and merge)相当于更新操作。

3. git pull -rebase

4. git push

### 3 git merge 
3.1 远程别人分支上的代码，合并到master上

Git鼓励大量使用分支：
查看分支：git branch
创建分支：git branch <name>
切换分支：git checkout <name>
创建+切换分支：git checkout -b <name>
合并某分支到当前分支：git merge <name>
删除分支：git branch -d <name>


    根据远程分支，创建本地分支并关联


    根据本地分支，创建远程分支并关联

### 4 合并两个仓库
git pull origin master --allow-unrelated-histories

### 5 本地创建新分支，关联远程新分支，并创建远程新分支，从主分支拉去代码
```
git push  origin dev
```

#### 查看本地分支和远程分支的跟踪关系

git branch -vv

#### 查看某个文件修改记录
```
git log --pretty=oneline 文件名

git show commit_id  文件路径
```

#### 拉取远程指定分支
```
git pull origin dev:dev
```

#### 本地上传到远程指定分支
```

```

### git push
git push <远程主机名> <本地分支名>  <远程分支名>

# git 用法总结

## git add 
1. git add <path> 说明： add to index only files created or modified and not those deleted 。不包括删除的文件。
2. git add -u [<path>] 说明：add to index only files modified or deleted and not those created .不处理untracted文件。
3. git add -A [<Path>]

## git 合并远程分支
git  创建远程分支的本地分支，并关联本地分支和远程分支
git checkout -b dev origin/dev

拉取远程指定分支
git pull origin dev

git checout master
git merge dev
git push origin master

git branch
git branch -d dev
git branch -D dev #强制删除分支

git push origin :dev
git push origin --delete dev

## git  创建远程分支
git branch -a 

查看所有分支

git checkout -b test01

创建本地test01分支

git push --set-upstream origin test01

把本地test01分支推送到远程

git push origin dev:dev