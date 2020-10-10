package com.fbin.state;

//测试线程优先级
public class TestPriority{

    public static void main(String[] args) {
        //主线程优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread a = new Thread(myPriority);
        Thread b = new Thread(myPriority);

        a.setPriority(5);
        b.setPriority(10);
        a.start();
        b.start();
    }

}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}