package com.fbin.demo01;

//多个线程操作同一对象
//买火车票的例子
public class TestThread4 implements Runnable{

    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            try {
                Thread.sleep(220);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第几张"+ ticketNums-- +"票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();
        new Thread(testThread4,"我").start();
        new Thread(testThread4,"其他乘客").start();
        new Thread(testThread4,"黄牛党").start();
        new Thread(testThread4,"xx").start();
        new Thread(testThread4,"fb").start();
        new Thread(testThread4,"dbin").start();
    }
}
