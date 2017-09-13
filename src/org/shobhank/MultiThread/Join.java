/**
*@author
*shsharma
*/
package org.shobhank.MultiThread;

public class Join {
    
    public static void main(String args[]) throws InterruptedException{
      
        System.out.println(Thread.currentThread().getName() + " is Started");
      
        Thread exampleThread1 = new Thread(){
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName() + " is Started");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is Completed");
                } catch (InterruptedException ex) {
                    
                }
            }
        };
        
        Thread exampleThread2 = new Thread(){
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName() + " is Started");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is Completed");
                } catch (InterruptedException ex) {
                    
                }
            }
        };
        
        Thread exampleThread3 = new Thread(){
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName() + " is Started");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is Completed");
                } catch (InterruptedException ex) {
                    
                }
            }
        };
      
        exampleThread1.start();
        exampleThread1.join();
        exampleThread2.start();
        exampleThread2.join();
        exampleThread3.start();
        exampleThread3.join();
        
      
        System.out.println(Thread.currentThread().getName() + " is Completed");
    }
  
}

