package com.fbin.syn;

//不安全的取钱
//两个人去银行取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(10000,"冯斌");
        Drawing you = new Drawing(account,1000,"你");
        Drawing youfriend = new Drawing(account,1000,"你朋友");
        you.start();
        youfriend.start();
    }
}

//账户
class Account {
    int money;//余额
    String name;//卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing extends Thread {
    Account account;//账户
    //取了多少钱
    int drawingMoney;
    //现在手里多少钱
    int nowMoney;

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
//        this.nowMoney = nowMoney;

    }


    //取钱
    @Override
    public void run() {
        //锁的对象就是变化的量
        synchronized (account){
            if (account.money<drawingMoney){
                System.out.println("not enouth");
                return;
            }
            //sleep可以放大问题的发生性，如果不加延时，进程很快就执行了，很难产生负数结果，
            // 加了时延之后线程开启后休息1000ms，此时数据并未改变，
            // 因此其他线程可以通过设置的拦截条件进来抢占资源，休眠结束后都进行修改，让原本不能通过的线程也完整执行。
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为：" + account.money);
            //Thread.currentThread.getName() = this.getName()
            System.out.println(this.getName() + "手里的钱" + nowMoney);
        }
        }

}


