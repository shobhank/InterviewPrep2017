package org.shobhank.MultiThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shobhanksharma on 5/18/17.
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(new ReentryTask(lock));
        Thread t2 = new Thread(new ReentryTask(lock));
        t1.start();
        t2.start();
    }
}

class ReentryTask implements Runnable{

    ReentrantLock lock;
    ReentryTask(ReentrantLock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is waiting for lock");
        lock.lock();
        methodA();
        lock.unlock();
    }

    private void methodA(){
        lock.lock();
        System.out.println("Doing something critical " + Thread.currentThread().getName()
        + " has " + lock.getHoldCount() + " locks");
        lock.unlock();
    }
}
