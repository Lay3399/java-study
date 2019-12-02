package com.javastudy.spring.proxy.cjlib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author 路晓梦
 * @title: Client
 * @description: TODO
 * @mail 836097839@qq.com
 * @date 19-12-2   下午9:00
 */
public class Client {

            @Test
            public void test01() {
                        /**
                         * Class[]字节码数组：它是用于指定被代理对象的字节码
                         * Callback:用于提供增强的代码
                         */

                        Producer cglibProducer =(Producer) Enhancer.create(Producer.class, new MethodInterceptor() {
                                    /**
                                     *
                                     * @param o
                                     * @param method
                                     * @param objects
                                     * 以上三个参数和基于接口的动态代理中invoke方法的参数是一样的
                                     * @param methodProxy: 当前执行方法的代理对象
                                     * @return
                                     * @throws Throwable
                                     */
                                    @Override
                                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                                                final Producer producer = new Producer();

                                                //提供增强的代码
                                                Object returnValue = null;
                                                //1.获取方法执行的参数
                                                Float money = (Float) objects[0];
                                                //2.判断当前方法是不是销售
                                                if ("saleProduct".equals((method.getName()))) {
                                                            returnValue = method.invoke(producer, money * 0.8f);
                                                }
                                                return returnValue;

                                    }
                        });
                        cglibProducer.saleProduct(1000F);

            }
}
