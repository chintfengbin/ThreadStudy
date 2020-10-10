package com.fbin.testthread;

public class TestRace {

    static int numRabit = 0;
    static int numHes = 0;


    public static void  rabit() throws InterruptedException {
        while(true){
            if (numRabit%10 == 0){
                Thread.sleep(150);
            }
            if (numHes == 100||numRabit==100){
                System.out.println("比赛结束");
                if (numRabit == 100){
                    System.out.println("兔子是胜利者");
                }
                break;
            }
                System.out.println("兔子跑了" + numRabit++);
        }

    }

    public static void  hes() throws InterruptedException {

        while(true){
            Thread.sleep(10);
            if (numHes == 100||numRabit==100){
                System.out.println("比赛结束");
                if (numHes == 100){
                    System.out.println("乌龟是胜利者");
                }
                break;
            }
            System.out.println("乌龟跑了" + numHes++) ;
        }

    }

    public static void main(String[] args) {
        TestRace testRace = new TestRace();
        new Thread(() ->{
            try {
                TestRace.rabit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                TestRace.hes();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}



