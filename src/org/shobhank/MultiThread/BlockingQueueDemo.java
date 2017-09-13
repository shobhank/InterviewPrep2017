/**
*@author
*shsharma
*/
package org.shobhank.MultiThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {

    public static void main(String args[]){
  
     //Creating shared object
     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
 
     //Creating Producer and Consumer Thread
     Thread prodThread = new Thread(new ProducerBQ(sharedQueue));
     Thread consThread = new Thread(new ConsumerBQ(sharedQueue));

     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
    }
 
}

//Producer Class in java
class ProducerBQ implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    public ProducerBQ(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<2; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

}

//Consumer Class in Java
class ConsumerBQ implements Runnable{

    private final BlockingQueue<Integer> sharedQueue;

    public ConsumerBQ (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
  
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

}

/*


//  Write the code for multithreaded producer / consumer.  The producer and consumer communicate through a shared data structure.
//  The producer adds integers to the shared data structure and the consumer takes integers from the shared data structure and processes them.
//  Production of integers can come from a random number generator.  Consumption of integers means printing them out to the console.
//  For this problem it is safe to assume just 1 producer and 1 consumer (No need to try and support multiple producers/consumers).
//  The consumer should processes 3 integers at a time in parallel and it must wait for all 3 integers to be processed before taking any more from the shared data structure.

public class Producer implements Runnable{

    private final BlockingQueue<Integer> bQueue;

    Producer(BlockingQueue<Integer> bQueue){
        this.bQueue = bQueue;
    }

    public void run(){
        while(true){
            bQueue.put(Math.random());
        }
    }
}

public class Consumer implements Runnable{

    private final BlockingQueue<Integer> bQueue;

    Consumer(BlockingQueue<Integer> bQueue){
        this.bQueue = bQueue;
        this.threadPool = new ThreadPoolExecutor();
    }

    private ExectorService threadPool = Executors.newFixedThreadPool(3);

    public void run(){
        List<Task> tasks = new ArrayList();
        List<Future> futures = new ArrayList<>();
        for(int i=1;i<=3;i++){
            tasks.add(new Task());
        }
        CyclicBarrier barrier = new CyclicBarrier(4);
        while(true){
            if(bQueue.size()<3){
                try{
                    wait();
                }catch(InterrruptedException exp){

                }
            }
            for(int i=1;i<=3;i++){
                int out = bQueue.take();
                task.get(i).setInput(out);
                threadPool.submit(task.get(i));
            }
            barrier.await();
            barrier.reset();
        }
    }


}

class Task implements Runnable{
    private int input;
    private CyclicBarrier barrier;

    public void setInput(int input, CyclicBarrier barrier){
        this.input = input;
        this.barrier = barrier;
    }

    public void run(){
        System.out.println("Processing " + input);
        barrier.await();
    }
}

public class MainClass{
    public static void main(String[] args){
        BlockingQueue<Integer> bQueue = new LinkedBlockingQueue<>();
        Thread t1 = new Thread(new Producer(bQueue)).start();
        Thread t2 = new Thread(new Consumer(bQueue)).start();
        t1.join();
        t2.join();
    }
}
 */
