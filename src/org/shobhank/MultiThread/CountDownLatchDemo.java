package org.shobhank.MultiThread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shobhanksharma on 5/16/17.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        System.out.println("Starting both the tasks");
        new Thread(new Task1(countDownLatch)).start();
        new Thread(new Task2(countDownLatch)).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed both the tasks");
    }
}

class Task1 implements Runnable{
    private CountDownLatch countDownLatch;

    Task1(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " is running task 1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " is finished with task 1");
        countDownLatch.countDown();
    }
}

class Task2 implements Runnable{
    private CountDownLatch countDownLatch;

    Task2(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " is running task 2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " is finished with task 2");
        countDownLatch.countDown();
    }
}