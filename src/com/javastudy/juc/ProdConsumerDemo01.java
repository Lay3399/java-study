package com.javastudy.juc;

/**
 * @author 路晓梦
 * @title: ProdConsumerDemo
 * @description: TODO生产者消费者案例
 * @mail 836097839@qq.com
 * @date 19-11-23   下午5:57
 */
public class ProdConsumerDemo01 {

            public static void main(String[] args) {
                        Aircondition aircondition = new Aircondition();
                        new Thread(() -> {
                                    try {
                                                for (int i = 0; i < 10; i++) {
                                                aircondition.increment();
                                                }
                                    } catch (Exception e) {
                                                e.printStackTrace();
                                    }
                        }, "A").start();
                        new Thread(() -> {
                                    try {
                                                for (int i = 0; i < 10; i++) {
                                                            aircondition.decrement();
                                                }
                                    } catch (Exception e) {
                                                e.printStackTrace();
                                    }
                        }, "B").start();
            }
}

class Aircondition {
            private int number = 0;

            public synchronized void increment() throws Exception {

                        while (number != 0) {    //当加线程超过2个，还是会出现线程安全问题，应该用while
                                    this.wait();
                        }
                        number++;
                        System.out.println(Thread.currentThread().getName() + "\t" + number);

                        this.notifyAll();
            }

            public synchronized void decrement() throws Exception {
                        while(number == 0) {
                                    this.wait();
                        }
                        number--;
                        System.out.println(Thread.currentThread().getName() + "\t" + number);
                        this.notifyAll();
            }

}


