package org.shobhank.MultiThread;

import org.shobhank.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by shobhanksharma on 5/11/17.
 */
public class AtomicDemo{
    private static AtomicInteger count = new AtomicInteger(0);

    static class MyRunnable implements Runnable {

        private int myCounter;
        private int myPrevCounter;
        private int myCounterPlusFive;
        private boolean isNine;

        public void run() {
//            myCounter = count.incrementAndGet();
//            System.out.println("Thread " + Thread.currentThread().getId() + "  / Counter : " + myCounter);
            myPrevCounter = count.getAndIncrement();
            System.out.println("Thread " + Thread.currentThread().getId() + " / Previous : " + myPrevCounter);
            myCounterPlusFive = count.addAndGet(5);
            System.out.println("Thread " + Thread.currentThread().getId() + " / plus five : " + myCounterPlusFive);
//            isNine = count.compareAndSet(9, 3);
//            if (isNine) {
//                System.out.println("Thread " + Thread.currentThread().getId()
//                        + " / Value was equal to 9, so it was updated to " + count.intValue());
//            }

        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }
}


