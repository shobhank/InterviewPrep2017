/**
 *@author
 *shsharma
 */
package org.shobhank.MultiThread;

public class MultithreadDemo {

    MultithreadDemo() {
        new SimpleThread("T1").start();
        new SimpleThread("T2").start();
        new SimpleThread("T3").start();
        new SimpleThread("T4").start();
        new SimpleThread("T5").start();
    }

    public static void main(String[] args) {
        new MultithreadDemo();

    }

}

class SimpleThread extends Thread {

    SimpleThread(String str) {
        super(str);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "starting");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "ending");
    }
}
