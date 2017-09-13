package org.shobhank.MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample {

	private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
	public static ExecutorService threadPool =  new ThreadPoolExecutor(2, 10, 1000, TimeUnit.SECONDS,queue, new ThreadPoolExecutor.CallerRunsPolicy());
	
	public void doWork() throws Exception{
		
		Count10 count1 = new Count10(1);
		Count10 count2 = new Count10(2);
		Count10 count3 = new Count10(3);
		
		List<Future<String>> futureList = new ArrayList<Future<String>>();
		futureList.add(threadPool.submit(count1));
		futureList.add(threadPool.submit(count2));
		futureList.add(threadPool.submit(count3));
		
		for(int i=0; i < 3; i++){
			Future<String> future = futureList.get(i);
			System.out.println(future.get());
		}
		System.out.println("Done All");
		threadPool.shutdown();
	}
	
	public static void main(String args[]) throws Exception{
		ThreadPoolExample tpe = new ThreadPoolExample();
		tpe.doWork();
	}
	
}

class Count10 implements Callable<String>{

	private int index = 0;
	Count10(int i){
		index = i;
	}
	@Override
	public String call() throws Exception {
		for(int i=0; i < 10; i++){
			System.out.println("Print i for " + index + ":" + i);
			int sleepTime = (int)(Math.random()*1000) + 1;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Done" + index;
	}
	
}
