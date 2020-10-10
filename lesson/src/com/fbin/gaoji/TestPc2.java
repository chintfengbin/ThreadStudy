package com.fbin.gaoji;
/*多个同样的线程一起运行用run接口，不同的线程分别运行一次就用thread*/


//测试生产者消费者问题2

public class TestPc2 {


    public static void main(String[] args) {
        TV tv = new TV();
        Player player = new Player(tv);
        Watch watch = new Watch(tv);
        player.start();
        watch.start();
    }
}

//生产者-->演员
class Player extends Thread{
    TV tv;
    public Player (TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0){
                try {
                    this.tv.play("：快乐大本营");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    this.tv.play("抖音记录美好生活");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//消费者-->观众
class Watch extends Thread{
    TV tv;
    public Watch (TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}


//产品-->节目
class TV{
    //演员表演观众等待
    //观众观看演员等待
    String voice;//表演的节目
    boolean flag = true;

    //表演
    public synchronized void play(String voice) throws InterruptedException {
        if (!flag){
            this.wait();
        }
        System.out.println("演员表演了节目" + voice);
        //通知观看
        this.notifyAll();//唤醒
        this.voice = voice;
        this.flag = !this.flag;
    }
    //观看
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了：" + voice);
        //通知演员表演
        this.notifyAll();//此线程进行时演员线程在wait，可以唤醒演员线程
        this.flag= !this.flag;

    }
}

