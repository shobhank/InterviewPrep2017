package leetcode;

/**
 * Created by shobhanksharma on 6/11/17.
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
    public static void main(String[] args) {
        MyThreadPool threadPool = new MyThreadPool(3);
        for(int i=1;i<=10;i++){
            threadPool.execute(new Task("Task"+i));
        }
    }
}


class MyThreadPool{
    List<Thread> threads = new ArrayList<>();
    BlockingQueue<Task> queue = new LinkedBlockingQueue<>();

    MyThreadPool(int poolSize){
        for(int i=1;i<=poolSize;i++){
            threads.add(new Thread(new Worker(queue)));
        }

        for(int i=0;i<poolSize;i++){
            threads.get(i).start();
        }
    }

    public void execute(Task task){
        queue.add(task);
    }

}

class Worker implements Runnable{

    BlockingQueue<Task> queue;

    Worker(BlockingQueue<Task> queue){
        this.queue = queue;
    }

    public void run(){
        while(true) {
            try {
                Task task = queue.take();
                task.run();
            } catch (InterruptedException ie) {
            }
        }
    }



}

class Task implements Runnable{
    private String name;
    Task(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("Task " + name + " Starting By Thread " + Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }catch(InterruptedException ie){

        }
        System.out.println("Task " + name + " Completed By Thread " + Thread.currentThread().getName());
    }

}
