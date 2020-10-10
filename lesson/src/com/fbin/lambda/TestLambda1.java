package com.fbin.lambda;
/*
推导lambda表达式
 */
public class TestLambda1 {
    //3.静态内部类（放在类里面）
    static class Like2 implements ILike{
        @Override
        public void lambdam() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambdam();

        like = new Like2();
        like.lambdam();

        //4.局部内部类(放在方法里面）
        class Like3 implements ILike{
            @Override
            public void lambdam() {
                System.out.println("i like lambda3");
            }
        }

        like = new Like3();
        like.lambdam();

        //5.匿名内部类，没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambdam() {
                System.out.println("i like lambda4");
            }
        };
        like.lambdam();

        //6.用lambda简化
        ILike like1 = () -> {
            System.out.println("i like lambda5");
        };
        like1.lambdam();
    }
}

//1.定义函数式接口(只有一个方法的接口）
interface ILike{
    void lambdam();
}

//2.实现类
class Like implements ILike{
    @Override
    public void lambdam() {
        System.out.println("i like lambda");
    }
}