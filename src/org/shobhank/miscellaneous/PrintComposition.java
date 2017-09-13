package org.shobhank.miscellaneous;

/**
 *@author
 *shsharma
 */

public class PrintComposition {

    final static int maxSize = 3;
    public static void main(String[] args) {
        int arr[] = new int[20];
        combinations(5,arr,0);
    }
    
    public static void combinations(int n,int arr[],int len){
        if(n==0){
            for(int i=0;i<len;i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }else if(n>0){
            for(int k=1;k<=maxSize;k++){
                arr[len] = k;
                combinations(n-k,arr,len+1);
            }
        }
    }

}


