package org.shobhank.MultiThread.threadpool;

/**
 * Created by shobhanksharma on 5/21/17.
 */
public class Task implements Runnable {

    String taskName;

    Task(String taskName){
        this.taskName = taskName;
    }
    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() +" Performing task " + taskName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getName() +" Done task " + taskName);
    }
}
