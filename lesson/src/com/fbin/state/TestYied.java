package com.fbin.state;

//测试礼让线程
//礼让不一定成功，看cpu心情
public class TestYied {

    public static void main(String[] args) {
        MyYied myYied = new MyYied();
        new Thread(myYied,"线程1").start();
        new Thread(myYied,"线程2").start();
    }
}

class MyYied implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}