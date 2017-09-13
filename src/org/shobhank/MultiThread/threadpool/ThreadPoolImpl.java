package org.shobhank.MultiThread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shobhanksharma on 5/21/17.
 */
public class ThreadPoolImpl implements IThreadPool{

    List<Thread> threadList;
    boolean isStopped = false;
    BlockingQueue<Task> taskQueue;

    ThreadPoolImpl(int numThreads){
        taskQueue = new LinkedBlockingQueue<>();
        threadList = new ArrayList<>();
        for(int i=1;i<=numThreads;i++){
            MyThread thread = new MyThread(taskQueue);
            threadList.add(new Thread(thread));
        }

        for(Thread thread: threadList){
            thread.start();
        }
    }

    @Override
    public void shutDown() {
        this.isStopped = true;
    }

    @Override
    public void execute(Task task) {
        taskQueue.add(task);
    }
}
