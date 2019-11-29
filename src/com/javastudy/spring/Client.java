package com.javastudy.spring;

/**
 * @author 路晓梦
 * @title: Client
 * @description: TODO
 * @mail 836097839@qq.com
 * @date 19-11-29   下午8:45
 */
public class Client {
            public static void main(String[] args) {
                        BeanFactory beanFactory = new BeanFactory();
                        Hello hello = (Hello) beanFactory.getBean("Hello");
                        hello.sayHello();
            }
}
