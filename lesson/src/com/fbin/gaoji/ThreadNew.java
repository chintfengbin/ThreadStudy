package com.fbin.gaoji;

//回顾线程的创建
public class ThreadNew {
    public static void main(String[] args) {
        new MyThread1().start();
        new Thread(new MyThread2()).start();
    }
}

//1.继承Thread类
class MyThread1 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mythread1");
    }
}
//2.实现Runnable
class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("mythread2");
    }
}