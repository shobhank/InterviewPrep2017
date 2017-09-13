package org.shobhank.MultiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by shobhanksharma on 5/16/17.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        System.out.println("Starting Fetch and Report");
        CyclicBarrier cb = new CyclicBarrier(8, new Aggregator());
        new Thread(new TaskDB(cb)).start();
        new Thread(new TaskDB(cb)).start();
        new Thread(new TaskDB(cb)).start();
        new Thread(new TaskDB(cb)).start();
        new Thread(new TaskDB(cb)).start();
        new Thread(new TaskDB(cb)).start();
        new Thread(new TaskDB(cb)).start();
        new Thread(new TaskDB(cb)).start();
        System.out.println("Finish Fetch and Report");
    }
}

class Aggregator implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " All Tasks Done Now Aggregating and Reporting");
    }
}

class TaskDB implements Runnable {
    private CyclicBarrier cyclicBarrier;

    TaskDB(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " Fetching data from database");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " Fetched data from database");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
