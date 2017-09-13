/**
*@author
*shsharma
*/
package org.shobhank.dynamicprogramming;

public class Fibonacci {
    public static void main(String as[]){
        int fib[] = generateFibonacci(10);
        for(int i=0;i<fib.length;i++)
            System.out.println(fib[i]);
    }
    
    static int[] generateFibonacci(int n){
        int out[] = new int[n];
        for(int i=0;i<n;i++){
            if(i==0 || i==1)
                out[i] = i;
            else
                out[i] = out[i-1] + out[i-2];
        }
        return out;
    }
}


