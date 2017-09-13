/**
*@author
*shsharma
*/
package org.shobhank.dynamicprogramming;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int a[] = {10,22,9,33,21,50,41,60,80};
        System.out.println(longestIncreasingSSSize(a));
//        System.out.println(kadane(a));
    }
    
  
    public static int longestIncreasingSSSize(int a[]){
        int lkp[] = new int[a.length];
        lkp[0] = 1;
        for(int i=1;i<a.length;i++){
            int key = a[i];
            int max = 0;
            for(int j=0;j<i;j++){
                if(key>a[j] && lkp[j]>max){
                    max = lkp[j];
                }
            }
            lkp[i] = max + 1;
        }
        return max(lkp);
    }
    
    public static int max(int a[]){
        int max = a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;
    }

}


