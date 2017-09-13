package org.shobhank.design.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by shobhanksharma on 5/18/17.
 */
public class StaticFactorySpringDemo {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("spring-context.xml");
        System.out.println(context.getBean("adminBean1.1"));
        System.out.println(context.getBean("adminBean1.2"));
        System.out.println(context.getBean("adminBean2.1"));
        System.out.println(context.getBean("adminBean2.2"));
    }
}

class Admin{
    private static Admin admin;
    private Admin(){}
    public static Admin getInstance(){
        if(admin==null)
            admin = new Admin();
        return admin;
    }
}
