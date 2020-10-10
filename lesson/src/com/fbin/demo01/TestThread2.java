package com.fbin.demo01;

import org.apache.commons.io.FileUtils;
import sun.reflect.misc.FieldUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//联系Thread实现多线程同步下载图片
public class TestThread2 extends Thread{
    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,file);
        System.out.println("下载了文件名为:"+ file);
    }
    private String url;
    private String file;
    public TestThread2(String url,String file){
        this.file = file;
        this.url = url;
    }

    public static void main(String[] args) {
        TestThread2 testThread1 = new TestThread2(
                "http://10.120.7.221:8080/train/znn/image20200907125143106.jpg",
                "2.jpg");
        TestThread2 testThread2 = new TestThread2(
                "http://10.120.7.221:8080/train/znn/image20200907125143106.jpg",
                "3.jpg");
        TestThread2 testThread3 = new TestThread2(
                "http://10.120.7.221:8080/train/znn/image20200907125143106.jpg",
                "4.jpg");

        //线程是同时执行，没有顺序
        testThread1.start();
        testThread2.start();
        testThread3.start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String file){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(file));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}