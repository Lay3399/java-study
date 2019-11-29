package com.javastudy.juc;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 路晓梦
 * @title: NotSafeDemo01
 * @description: TODO
 * @mail 836097839@qq.com
 * @date 19-11-21   下午4:18
 * <p>
 * HashMap  默认初始值未16  扩容一倍
 * ArraysList   底层默认10     扩容第一次15 Array.copy    15+7
 */

/**
 *  java.util.ConcurrentModificationException
 */
public class NotSafeDemo01 {
            public static void main(String[] args) {

            }

            /**
             *  java.util.ConcurrentModificationException   并发修改异常
             *  ArrayList:
             *  解决方案：
             *  1：换线程安全的 Vector
             *  2:   Collections.synchronizedList
             *  3.  CopyOnWriteArrayList
             */
            @Test
            public void testArrayList01() {
                        List<String> list = new ArrayList<>();
//                        List<String> list = new CopyOnWriteArrayList<>();
                        List<String> list1 = Collections.synchronizedList(list);
                        for (int i = 0; i < 300; i++) {
                                    new Thread(() -> {
                                                list1.add(UUID.randomUUID().toString().substring(0, 8));
                                                System.out.println(list1);
                                    }, String.valueOf(i)).start();
                        }
            }
}
