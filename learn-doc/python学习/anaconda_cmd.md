# anaconda operation
##windowsconda
###1 管理虚拟环境
###2 activate
进入虚拟环境
###3 创建自定义虚拟环境
```
 conda create -n  envName python=versionId
```
###4 切换虚拟环境
```
activate envName
```
###5 查看所有虚拟环境
```
        conda env list

        activate // 切换到base环境

        activate learn // 切换到learn环境

        conda create -n learn python=3 // 创建一个名为learn的环境并指定python版本为3(的最新版本)

        conda env list // 列出conda管理的所有环境

        conda list // 列出当前环境的所有包

        conda install requests 安装requests包

        conda remove requests 卸载requets包

        conda remove -n learn --all // 删除learn环境及下属所有包

        conda update requests 更新requests包

        conda env export > environment.yaml // 导出当前环境的包信息

        conda env create -f environment.yaml // 用配置文件创建新的虚拟环境
```

