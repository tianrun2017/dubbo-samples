package org.apache.dubbo.samples.annotation;

import org.apache.dubbo.samples.annotation.api.HelloService;
import org.apache.dubbo.samples.annotation.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 描述
 *
 * @author fanqinhai
 * @since 2020/6/14 9:17 上午
 */
public class LoadBalanceConsumer {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();

        HelloService helloService = context.getBean( HelloService.class);

        while (true) {
            String hello = helloService.sayHello("world222ee");
            System.err.println("result: " + hello);

            System.err.println("===============================================");

            Thread.sleep(1000);
        }
    }
}
