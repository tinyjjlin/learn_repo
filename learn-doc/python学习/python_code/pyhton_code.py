#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2018-10-04 11:55:03
# @Author  : jjlin (794549197@qq.com)
# @Link    : ${link}
# @Version : $Id$

'''
learing python thread
'''
import threading
import time
import sys
# print(dir(threading))


def action(arg):
    time.sleep(1)
    print('the arg is:%s\r' % arg)


for i in range(4):
    t = threading.Thread(target=action, args=(i,))
    t.start()


print('main thread end!')
print(sys.path)
