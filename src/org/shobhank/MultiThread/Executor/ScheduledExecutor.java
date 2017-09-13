package org.shobhank.MultiThread.Executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by shobhanksharma on 5/17/17.
 */
public class ScheduledExecutor {
    public static void main(String[] args) {
        System.out.println("Start at " + new Date());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        scheduledExecutorService.schedule(new ScheduledTask(), 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new ScheduledTask(),3, 2, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleWithFixedDelay(new ScheduledTask(),3, 2, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();

    }
}

class ScheduledTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Running scheduled task " + Thread.currentThread().getName() + " At " + new Date());
    }
}
