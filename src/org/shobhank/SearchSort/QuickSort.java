/**
*@author
*shsharma
*/
package org.shobhank.SearchSort;

public class QuickSort {

    public static void main(String[] args) {
        int a[] = {40,30,10,50,70,60,80,0,90};
        for(int k=0;k<a.length;k++)
            System.out.print(a[k] + " ");
        System.out.println();
        quickSort(a,0,a.length-1);
        for(int k=0;k<a.length;k++)
            System.out.print(a[k] + " ");
    }
    
    public static void quickSort(int a[],int p,int q){
        if(p<q){
            int pivot = partition(a,p,q);
            quickSort(a,p,pivot-1);
            quickSort(a,pivot+1,q);
        }
    }
    public static int partition(int a[],int p,int q){
        int pivot = p;
        int i = p+1;
        int j = q;
        while(i<j){
            while(a[i] < a[pivot]){
                i++;
            }
            while(a[j] > a[pivot]){
                j--;
            }
            if(i<j){
                int temp  = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[j];
        a[j] = a[pivot];
        a[pivot] = temp;
        return j;
    }

}


