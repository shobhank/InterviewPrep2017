package org.shobhank.MultiThread.threadpool;

import java.util.concurrent.BlockingQueue;

/**
 * Created by shobhanksharma on 5/21/17.
 */
public class MyThread implements Runnable {
    BlockingQueue<Task> taskBlockingQueue;
    boolean isStopped = false;

    MyThread(BlockingQueue<Task> queue){
        taskBlockingQueue = queue;
    }

    public void setStopped(){
        isStopped = true;
    }

    @Override
    public void run() {
        while (!isStopped){
            try {
                Task task = taskBlockingQueue.take();
                task.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
