package com.javastudy.juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程5种状态：创建、阻塞、就绪、运行、死亡
 */
public class LockDemo {
            public static void main(String[] args) {
                        Ticket ticket = new Ticket();

                        new Thread(() -> {for (int i = 1; i <= 40; i++)ticket.sale(); }  , "A").start();//线程A就绪
                        new Thread(() -> {for (int i = 1; i <= 40; i++)ticket.sale(); }  , "B").start();//线程B就绪
                        new Thread(() -> {for (int i = 1; i <= 40; i++)ticket.sale(); }  , "C").start();//线程C就绪

            }
}

class Ticket {
            private int number = 30;
            Lock lock = new ReentrantLock();

            public void sale() {
                        lock.lock();
                        try {
                                    if (number > 0) {
                                                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (number--) + "\t 还剩下： " + number);
                                    }
                        } catch (Exception e) {
                                    e.printStackTrace();
                        } finally {
                                    lock.unlock();
                        }
            }


}