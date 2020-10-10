package com.fbin.state;

import java.time.chrono.ThaiBuddhistChronology;

//测试守护线程
//上帝守护你
public class TestDeamon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//设置守护线程

        thread.start();
        new Thread(you).start();//
    }
}

//上帝
class God implements  Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("god deamon you");
        }
    }
}


//你
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("happy everyday");
        }
        System.out.println("==========goodbye life============");
    }
}