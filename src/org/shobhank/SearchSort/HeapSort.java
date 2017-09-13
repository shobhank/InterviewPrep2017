/**
*@author
*shsharma
*/
package org.shobhank.SearchSort;

public class HeapSort {

    public static void main(String[] args) {
        int a[] = {14,8,9,4,16,25,2,17,38,20};
        display(a);
        heapSort(a,a.length);
        display(a);
    }
    
    public static void display(int a[]){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    
    public static void maxHeapify(int arr[],int pos,int size){
        int max = pos;
        int temp;
        int l = pos * 2 + 1;
        int r = pos * 2 + 2;
        if(l<size && arr[l]>arr[max])
            max = l;
        if(r<size && arr[r]>arr[max])
            max = r;
        if(max!=pos){
            temp = arr[max];
            arr[max] = arr[pos];
            arr[pos] = temp;
            maxHeapify(arr,max,size);
        }
    }

    public static void buildMaxHeap(int arr[],int size){
        for(int i=size/2-1;i>=0;i--){
            maxHeapify(arr, i, size);
        }
    }

    public static void heapSort(int arr[],int size){
        buildMaxHeap(arr,size);
        int temp;
        for(int i=0;i<size;i++){
            temp = arr[0];
            arr[0] = arr[size-(i+1)];
            arr[size-(i+1)] = temp;
            maxHeapify(arr,0,size-(i+1));
        }
    }

}


