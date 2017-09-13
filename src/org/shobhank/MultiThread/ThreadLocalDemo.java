package org.shobhank.MultiThread;

import java.util.Date;

/**
 * Created by shobhanksharma on 5/16/17.
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        new Thread(new TestTask(new Date())).start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(new TestTask(new Date())).start();
    }
}

class TestTask implements Runnable{
    private static final ThreadLocal<Date> var = new ThreadLocal<>();

    TestTask(Date date){
        var.set(date);
    }

    @Override
    public void run() {
        System.out.println(var.get());
    }
}
