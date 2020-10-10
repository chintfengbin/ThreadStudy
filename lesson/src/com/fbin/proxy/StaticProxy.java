package com.fbin.proxy;

//静态代理模式总结
//真是对象要和代理对象都要实现一个接口
//代理对象需要真实角色

//好处：
//代理对象可以做很多真实对象做不了的事情，真实对象专注做自己想做的事情

public class StaticProxy {
}

interface Marry{

    //结婚
    void HappyMarry();

}

//真实角色
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("小明要结婚了");
    }
}

//代理角色
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("布置婚礼现场");
    }

    public static void main(String[] args) {
        //创建真实角色
        You you = new You();

        //创建婚庆公司代理对象（将真实对象传入婚庆公司），婚庆公司需要一个目标对象
        WeddingCompany weddingCompany = new WeddingCompany(you);

        //代理对象帮助真是对象执行结婚
        weddingCompany.HappyMarry();
    }
}