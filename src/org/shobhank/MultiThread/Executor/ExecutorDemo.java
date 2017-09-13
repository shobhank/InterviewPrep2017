package org.shobhank.MultiThread.Executor;

import org.shobhank.design.shoppingcart.Item;
import org.shobhank.design.shoppingcart.ShoppingCart;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shobhanksharma on 5/17/17.
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.shutdown();
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("In task ran by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CallableTask implements Callable<ShoppingCart>{

    @Override
    public ShoppingCart call() throws Exception {
        ShoppingCart cart = new ShoppingCart();
        for(int i=0;i<1000;i++){
            cart.addItem(new Item("UPS"+i, (int) (10*Math.random())));
            Thread.sleep(2);
        }
        return cart;
    }
}