package org.shobhank.MultiThread;

public class WaitNotifyDemo {

	public static void main(String[] args) throws InterruptedException {
		ThreadB b = new ThreadB();
		b.start();
//		b.join();
    		synchronized(b){
    		b.wait();
    		}
		System.out.println(b.total);
	}

}

class ThreadB extends Thread {
	int total;
 
	@Override
	public void run() {
		synchronized(this){
		for (int i = 0; i < 10; i++) {
			total += i;
		}
		notify();
		}
	}
}