# 高阶函数，将函数当参数传递
from functools import reduce

def add(x, y, f):
    return f(x) + f(y)

print(add(-2, 3, abs))

DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4,
          '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}


def str2int(s):
    def fn(x, y):
        return x * 10 + y

    def char2num(s):
        return DIGITS[s]
    return reduce(fn, map(char2num, s))
print(str2int('3434343434'))


def char2num(s):
    digits = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4,
              '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
    return digits[s]


def f(x):
    return x * x

r = map(f, [1, 2, 3, 4, 5, 6])
print(list(r))

p = list(map(char2num, '12456'))
print(p)
