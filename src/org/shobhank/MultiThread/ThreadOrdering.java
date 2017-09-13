/**
*@author
*shsharma
*/
package org.shobhank.MultiThread;

public class ThreadOrdering {
    public static void main(String[] args) {

        class MyRunnable implements Runnable{
            private final int threadnumber;

            MyRunnable(int threadnumber){
                this.threadnumber = threadnumber;
            }

            public void run() {
                System.out.println(threadnumber);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        Thread t[] = new Thread[10];
        for(int i=0; i<10; i++){
            t[i] = new Thread(new MyRunnable(i));
            t[i].start();
            try {
                t[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}


