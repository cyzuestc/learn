看这篇文章
https://www.cnblogs.com/wxd0108/p/5479442.html


# 扎好马步: 线程的状态
A thread can be in one of the following states.
- New 
- Runnable
- Blocked
- Waiting
- Timed_waiting
- Terminated
# 内功心法: 每个对象都有的方法(机制)
synchronized,wait,notify是任何对象都有的同步工具
- monitor
Java中每个对象都有一个监视器,来监测并发代码的重入.在多线程编码时该监视器不发挥作用,
反之如果在synchronized范围内,监视器发挥作用.
wait/notify必须存在于synchronized块中,并且这三个关键字针对的同一个监视器.
这意味着wait之后,
# 太祖长拳: 基本线程类
# 九阴真经: 高级多线程控制类
