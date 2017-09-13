/**
 *@author
 *shsharma
 */
package org.shobhank.MultiThread;

public class Semaphore {
    private int value;

    Semaphore(int init) {
        value = init;
    }

    public synchronized void down() {
        while (value == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrrrupt");
            }
        }
        value--;
    }

    public synchronized void up() {
        value++;
        notify();
    }

    public static void main(String as[]) {
        int noOfThreads = 5;
        Semaphore mutex = new Semaphore(noOfThreads);
        for (int i = 0; i < 10; i++) {
            new MutexThread(mutex, "T" + i);
        }
    }
}

class MutexThread extends Thread {
    private Semaphore mutex;

    MutexThread(Semaphore mutex, String name) {
        super(name);
        this.mutex = mutex;
        start();
    }

    public void run() {
        if (true) {
            mutex.down();
            System.out.println("CS " + Thread.currentThread().getName());
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exit CS " + Thread.currentThread().getName());
            mutex.up();
        }
    }
}
