#python 语法重点

## yield 使用

  + 迭代器
      读取的所有值保持在内存中
  + 生成器
      只能读取一次，并不是把所有值保持在内存中，实时生成的数据

  + yield
      类似return,返回的是生成器

参考：[yield](https://www.cnblogs.com/cotyb/p/5260032.html)

自己理解：

    yield 阻塞当前运行，每次只能返回一个值。
    在for循环中，会自动遵循迭代规则，每次调用next()函数，所以上面的结果不难理解。

```python

def create_counter(n):
    print "create counter"
    while True:
        yield n
        print 'increment n'
        n += 1

cnt = create_counter(2)
print cnt
print next(cnt)
print next(cnt)
```