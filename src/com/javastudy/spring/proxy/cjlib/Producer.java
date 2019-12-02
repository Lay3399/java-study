package com.javastudy.spring.proxy.cjlib;

/**
 * @author 路晓梦
 * @title: Producer
 * @description: TODO 生产者
 * @mail 836097839@qq.com
 * @date 19-12-2   下午8:53
 */
public class Producer {
            /**
             * 销售
             */
            public void saleProduct(float money){
                        System.out.println("销售产品，并拿到钱："+money);
            }

            /**
             * 售后
             */
            public void afterService(float money) {
                        System.out.println("提供售后服务，并拿到钱："+money);
            }
}
