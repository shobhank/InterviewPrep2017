package org.shobhank.MultiThread.threadpool;

/**
 * Created by shobhanksharma on 5/21/17.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        IThreadPool threadPool = new ThreadPoolImpl(3);
        for(int i=1;i<=10;i++){
            threadPool.execute(new Task("Task"+i));
        }
        threadPool.shutDown();
    }
}
