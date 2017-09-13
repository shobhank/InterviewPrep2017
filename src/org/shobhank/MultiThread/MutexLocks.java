/**
 *@author
 *shsharma
 */
package org.shobhank.MultiThread;

public class MutexLocks {

    public static void main(String[] args) {
        //Thread unsafe
//         OddNonMutex e = new OddNonMutex();
//         new Odd2(e).start();
//         new Odd2(e).start();
         //Thread safe
        OddMutex om = new OddMutex(5);
        new Odd3(om).start();
        new Odd3(om).start();
    }
}

class OddNonMutex {
    private int n = 1;

    public int next() throws InterruptedException {
        ++n;
        Thread.sleep(1000);
        ++n;
        return n;
    }
}

class Odd2 extends Thread {
    private OddNonMutex e;

    public Odd2(OddNonMutex e) {
        this.e = e;
    }

    public void run() {
        for (int i = 0; i < 10; i++)
            try {
                System.out.println("Result " + e.next());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}

class Odd3 extends Thread {
    private OddMutex e;

    public Odd3(OddMutex e) {
        this.e = e;
    }

    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println("Result " + e.next());
    }
}

class OddMutex {
    private int n = 1;
    Semaphore mutex;

    OddMutex(int initial) {
        mutex = new Semaphore(1);
        n = initial;
    }

    public int next() {
        mutex.down();
        ++n;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ++n;
        mutex.up();
        return n;
    }
}
