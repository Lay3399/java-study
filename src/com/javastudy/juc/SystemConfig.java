package com.javastudy.juc;

/**
 * @author 路晓梦
 * @title: SystemConfig
 * @description: TODO
 * @mail 836097839@qq.com
 * @date 19-11-25   下午9:05
 */
public class SystemConfig {
            public static void main(String[] args) {
                        //显示CPU核心    （ 可用处理器数）
                        System.out.println("CPU核心数："+Runtime.getRuntime().availableProcessors());
                        //最大Java虚拟机试图使用的最大内存  字节  默认1/4 物理内存
                        System.out.println("-Xmx: Java虚拟机堆试图使用的最大内存内存大小" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "MB");
                        //jvm初始堆内存    默认为物理内存的1/64
                        System.out.println("-Xmx:初始堆内存大小"+Runtime.getRuntime().totalMemory()/1024/1024+"MB");
            }
}
