/**
*@author
*shsharma
*/
package org.shobhank.SearchSort;

public class Sort {

    public static void main(String[] args) {
        int a[] = {64,25,12,22,11};
        selectionSort(a);
        bubbleSort(a);
        print(a);
    }
    
    public static void print(int a[]){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    
    public static void selectionSort(int a[]){
        int min = 0;
        for(int j=0;j<a.length;j++){
            min = j;
            for(int i=j;i<a.length;i++){
                if(a[i]<a[min])
                    min = i;
            }
            int temp = a[j];
            a[j] = a[min];
            a[min] = temp;
        }
    }
    
    public static void bubbleSort(int a[]){
        for(int i=a.length-1;i>=1;i--){
            for(int j=1;j<=i;j++){
              if(a[j] < a[j-1]){
                  int temp = a[j];
                  a[j] = a[j-1];
                  a[j-1] = temp;
              }
            }
        }
    }
}


