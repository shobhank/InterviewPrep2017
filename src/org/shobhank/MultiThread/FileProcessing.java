package org.shobhank.MultiThread;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by shobhanksharma on 6/10/17.
 */
public class FileProcessing{
    private final String dirPath = "/opt/sas/logs";
    int counter = 0;
    volatile int counterM = 0;

    public void processSingleThread(){
        List<File> files = getAllFilePaths();
        for(File file:files){
            processAFile(file);
        }
    }

    public void processAFile(File file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String line = "";
            int localCounter = 0;
            while ((line=br.readLine())!=null){
                if(line.contains("java")) {
                    localCounter++;
                }
            }

            System.out.println("Processed " + file.getName() + " has " + localCounter);
            synchronized (this) {
                counter = counter + localCounter;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processMultiThread(){
        List<File> files = getAllFilePaths();
        CountDownLatch latch = new CountDownLatch(files.size());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(File file:files){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    processAFile(file);
                    latch.countDown();
                }
            });
            executorService.submit(t);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<File> getAllFilePaths(){
        File folder = new File(dirPath);
        File[] listOfFiles = folder.listFiles();
        List<File> files = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files.add(listOfFiles[i]);
            }
        }
        return files;
    }

    public static void main(String[] args) throws InterruptedException {
        FileProcessing processing = new FileProcessing();
        long start = System.currentTimeMillis();
        processing.processMultiThread();
//        Thread t = new Thread(processing);
//        t.start();
//        t.join();
        System.out.println(processing.counter + " in " + (System.currentTimeMillis()-start) + "ms");

    }


}
