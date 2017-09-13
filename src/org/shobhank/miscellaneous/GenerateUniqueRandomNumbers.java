package org.shobhank.miscellaneous;

import org.shobhank.datastructures.Arrays;

import java.util.Random;

/**
 * Created by shobhanksharma on 3/24/17.
 */
public class GenerateUniqueRandomNumbers {
    public static void main(String in[]){
        generateRandom(5,20);
    }

    public static void generateRandom(int start, int end){
        int N = end - start + 1 ;
        int a[] = new int[N];
        for(int i=start;i<=end;i++){
            a[i-start] = i;
        }

        int x = N;
        Random random = new Random();
        while(x>=1){
            int randomIx = random.nextInt(x);
            System.out.println(a[randomIx]);
            swap(a,randomIx, x-1);
            x--;
        }
    }

    public static void swap(int a[], int s, int t){
        int temp = a[s];
        a[s] = a[t];
        a[t] = temp;
    }
}
