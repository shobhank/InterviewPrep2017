package org.shobhank.MultiThread.threadpool;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by shobhanksharma on 5/21/17.
 */
public interface IThreadPool {
    public void shutDown();
    public void execute(Task task);
}
