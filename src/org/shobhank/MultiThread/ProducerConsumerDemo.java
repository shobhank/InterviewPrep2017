package org.shobhank.MultiThread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shobhanksharma on 5/7/17.
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        final PC pc = new PC(5);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.produce();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.consume();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PC {
    Queue<Integer> q = new LinkedList<>();
    final int MAX;

    PC(int MAX){
        this.MAX = MAX;
    }

    public void produce(){
        int value = 0;
        synchronized (this) {
            while (true) {
                while (q.size() == MAX) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Producing " + value);
                q.add(value++);
                notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consume(){
        synchronized (this){
            while (true){
                while (q.size()==0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Polled: " + q.poll());
                notify();
            }
        }
    }
}
