package com.fbin.lambda;

public class TestLambda2 {

    static class Love2 implements ILove{
        @Override
        public void love(int a) {
            System.out.println("I love you2 : "+ a);
        }
    }

    public static void main(String[] args) {
        ILove iLove = new Love();
        iLove.love(3);
        iLove = new Love2();
        iLove.love(2);
        class Love3 implements ILove{
            @Override
            public void love(int a) {
                System.out.println("I love you3 : "+ a);
            }
        }
        iLove = new Love3();
        iLove.love(5);

        iLove = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("I love you4 : "+ a);
            }
        };
        iLove.love(6);

        ILove love = (int a) -> {
            System.out.println("I love you5 : "+ a);
        };

        //简化1.去掉参数类型
        love = (a) -> {
            System.out.println("I love you6 : "+ a);
        };

        //简化2.简化括号
        love = a -> {
            System.out.println("I love you7 : "+ a);

        };

        //简化3.去掉花括号(仅限于代码里面只有一行)
        love = a -> System.out.println("I love you8 : "+ a);

        //总结：
            //lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行那么就用代码包裹块{}
            //必须是函数式接口（只有一个方法的接口）
            //多个参数也可以去掉参数类型，要去掉就都得去掉，必须加上括号

        love.love(7);
    }
}

interface ILove{
    void love(int a);
}

class Love implements ILove{
    @Override
    public void love(int a) {
        System.out.println("I love you1 : "+ a);
    }
}