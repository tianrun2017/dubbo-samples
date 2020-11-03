/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.apache.dubbo.samples.annotation;

import java.util.concurrent.CountDownLatch;
import org.apache.dubbo.samples.annotation.action.AnnotationAction;
import org.apache.dubbo.samples.annotation.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sun.rowset.JdbcRowSetImpl;

public class AnnotationConsumerBootstrap {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");

       // while (true) {
            //正常调用
            System.err.println("hello : " + annotationAction.doSayHello("world"));
            //System.err.println("goodbye : " + annotationAction.doSayGoodbye("world"));
            //System.err.println("greeting : " + annotationAction.doGreeting("world"));
            //System.err.println("reply : " + annotationAction.replyGreeting("world"));

            Thread.sleep(1000);
       // }

        new CountDownLatch(1).await();
    }

}
