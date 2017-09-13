package org.shobhank.MultiThread.Executor;

import org.shobhank.design.shoppingcart.ShoppingCart;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by shobhanksharma on 5/17/17.
 */
public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future f1 = executorService.submit(new Task());
        Future f2 = executorService.submit(new Task());

        try {
            System.out.println(f1.get()); // Blocking
            System.out.println(f2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future f3 = executorService.submit(new CallableTask());
        ShoppingCart cart = null;
        try {
            cart = (ShoppingCart) f3.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(cart.calculateTotal());

        executorService.shutdown();

        System.out.println("End");
    }
}

