package com.fbin.demo01;

//创建线程方式：继承Thread，重写run（）方法，调用start开启线程
//run方法时先执行完了再执行主线程，start方法是cpu调度，并发执行
public class TestThread1 extends Thread{

    @Override
    public void run(){
        //run方法线程体
        for (int i=1;i<=20;i++){
            System.out.println("我在敲代码" + i);
//            System.out.println();
        }
    }

    public static void main(String[] args) {

        TestThread1 testThread1 = new TestThread1();
        //调用start方法开启多线程
        testThread1.start();

        //main线程，主线程
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }
}
