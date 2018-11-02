import gevent
'''
python 语法重点
'''


def test1():
    print(1, 2)
    gevent.sleep(0)
    print(3, 4)


def test2():
    print(5, 6)
    gevent.sleep(0)
    print(7, 8)

gevent.joinall([gevent.spawn(test1), gevent.spawn(test2)])
