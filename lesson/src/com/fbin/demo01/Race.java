package com.fbin.demo01;

//模拟龟兔赛跑
public class Race implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            //兔子休息
            if (Thread.currentThread().getName().equals("兔子") && i%10==0){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            if (gameOver(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName()+ "跑了"+ i +"步");
        }
    }

    //判断是否完成比赛
    private boolean gameOver(int steps){
        //判断是否有胜利者
        if (winner!=null){
            return true;
        }else {
            if(steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner is " + winner);
                return true;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}
