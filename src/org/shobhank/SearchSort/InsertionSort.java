/**
*@author
*shsharma
*/
package org.shobhank.SearchSort;

public class InsertionSort {
    public static void main(String as[]){
        int a[] = {14,8,9,4,16,25,2,17,38,20};
        display(a);
        insertionSort(a);
        System.out.println();
        display(a);
    }
    
    public static void display(int a[]){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
    
    public static void insertionSort(int a[]){
        for(int i=1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if(a[j]>a[i]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
}


