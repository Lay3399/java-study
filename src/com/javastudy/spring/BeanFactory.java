package com.javastudy.spring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 路晓梦
 * @title: BeanFactory
 * @description: TODO
 * @mail 836097839@qq.com
 * @date 19-11-29   下午8:19
 */
public class BeanFactory {
            private static Properties props;

            //定义一个map，存放容器
            private static Map<String, Object> beans = null;

            //使用静态代码块为Properties对象赋值
            static {
                        try {
                                    //实例化对象
                                    props = new Properties();
                                    //获取properties文件的对象流
                                    InputStream in = null;
                                    in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
                                    props.load(in);
                                    //实例化容器
                                    beans = new HashMap<String, Object>();
                                    //取出配置文件中的所有的Keys
                                    Enumeration<Object> keys = props.keys();
                                    //遍历枚举
                                    while (keys.hasMoreElements()) {
                                                String key = keys.nextElement().toString();
                                                //根据key获取value
                                                String beanPath = props.getProperty(key);
                                                //反射创建对象
                                                Object value = Class.forName(beanPath).newInstance();
                                                //把key和value存到容器中
                                                beans.put(key, value);

                                    }
                        } catch (Exception e) {
                                    throw new ExceptionInInitializerError("初始化properties失败");
                        }


            }

            /**
             * 根据名称创建对象
             * @param beanName
             * @return
             */
            //反射的方式创建对象
            public Object getBean(String beanName) {
                 /*       Object bean = null;
                        String beanPath = props.getProperty(beanName);
                        try {
                                    bean = Class.forName(beanPath).newInstance();
                        } catch (InstantiationException e) {
                                    e.printStackTrace();
                        } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                        }
                        return bean;*/
                        return beans.get(beanName);
            }
}

