package com.fbin.demo01;

//创建线程方式2：实现runable接口，重写run方法，执行线程是丢入runable接口实现类，调用start（）方法
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        //run方法线程体
        for (int i=1;i<=20;i++){
            System.out.println("我在敲代码" + i);
//            System.out.println();
        }
    }

    public static void main(String[] args) {
       //创建接口的实现类对象
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，通过线程对象来实现我们的线程，代理
        Thread thread = new Thread(testThread3);
        thread.start();
        //main线程，主线程
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }
}
