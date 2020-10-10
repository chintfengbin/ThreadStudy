package com.fbin.state;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class TestSleep2 implements Runnable {
    @Override
    public void run() {

    }

    //模拟倒计时
    public static void tenDown(){
        int num = 10;

        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(num);
                num--;
                if (num <= 0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //打印系统当前时间
        Date startTime = new Date(System.currentTimeMillis());//获取系统当前时间
        while(true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime));
            startTime = new Date(System.currentTimeMillis());//更新系统当前时间
        }
    }
}
