package com.javastudy.jvm;

/**
 * @author 路晓梦
 * @title: ClassLoderDemo
 * @description:  类加载器
 *
 * 启动类加载器
 * 扩展类加载器
 * 应用程序加载器
 * 自定义加载器
 *
 * @mail 836097839@qq.com
 * @date 19-11-23   下午9:08
 */
public class ClassLoderDemo {
            public static void main(String[] args) {
                        Object obj = new Object();
                        System.out.println(obj.getClass().getClassLoader());   //null  启动类加载器  加载java所用类库

                        MyObject mobj = new MyObject();
                        System.out.println(mobj.getClass().getClassLoader());  // 应用程序加载器   sun.misc.Launcher$AppClassLoader@18b4aac2
            }
}


class MyObject {

}
