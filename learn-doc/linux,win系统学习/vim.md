# vim 使用

## vim 中search
1. ? security
2. 选中的单词， shift+* ,n/N进行向上，向下选择

## vim 显示行号
: set number
syntax on
set tabstop=4
set shiftwidth=4
set showmatch //夸号匹配

## vim 跳到文件头，文件尾
gg
G


## 常见操作
1. 撤销 u
2. 在恢复 ctrl+r
3. 删除多行 : 指定行号1，指定行号2 d
4. 复制多行 ：line1,line2 copy line3
5. 移动多行 ：line1,line2 move line4
6. 删除全部： ggdG
7. 移动到文件尾：GG
8. 定位到文件头部：hh