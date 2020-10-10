package com.fbin.syn;


//不安全的买票
//有重复有负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"a").start();
        new Thread(buyTicket,"b").start();
        new Thread(buyTicket,"c").start();
    }
}


class BuyTicket implements Runnable{

    //票
    private int ticketNums = 10;
    boolean flag = true; //外部停止方式

    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized同步方法，锁的是this,可以理解为锁的是要保证数据安全的对象，让该方法体的操作逐一进行
    private  void buy() throws InterruptedException {

        synchronized (this){
            if (ticketNums <= 0){
                flag = false;
                return;
            }
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);

        }
        }

}