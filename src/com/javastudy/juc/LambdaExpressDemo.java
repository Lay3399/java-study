package com.javastudy.juc;

/**
 * @author 路晓梦
 * @title: LambdaExpressDemo
 * @description: TODO
 * @mail 836097839@qq.com
 * @date 19-11-20   下午10:26
 */
public class LambdaExpressDemo {
            public static void main(String[] args) {
                        Fun01 fun01 = () -> {
                                    System.out.println("hello");
                        };
                        fun01.sayHello();

                        Fun02 fun02 = (a1, a2) -> {
                                    System.out.println(a1 + a2);
                        };
                        fun02.add(1, 2);


                        Fun03 fun03 = (a1, a2) -> {
                                    return a1 + a2;
                        };

                        int result = fun03.add(2, 3);
                        System.out.println(result);



            }
}

class Fun01Impl implements Fun01 {

            @Override
            public void sayHello() {

            }

            @Override
            public void say() {

            }
}

@FunctionalInterface
interface Fun01 {
            public void sayHello();

            default void say() {
                        System.out.println("say hello");
            }

            /**
             * 一个静态方法
             * @param x
             * @param y
             * @return
             */
            public static int div(int x, int y) {
                        return x/y;
            }
}
@FunctionalInterface
interface Fun02 {
            public void add(int a, int b);
}
@FunctionalInterface
interface Fun03 {
            public int add(int a, int b);
}
@FunctionalInterface
interface Fun04 {
            public int show(int a);
}