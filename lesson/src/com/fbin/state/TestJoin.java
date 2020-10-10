package com.fbin.state;
//测试join方法（插队）
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("vip coming" + i);
        }
    }

    public static void main(String[] args) throws Exception{

        //启动我们的线程
        TestJoin join = new TestJoin();
        Thread thread = new Thread(join,"simple");
        thread.start();
        
        //主线程
        for (int i = 0; i < 500; i++) {
            System.out.println("主线程" + i);
            if (i == 200){
                thread.join();
            }
        }
    }
}
