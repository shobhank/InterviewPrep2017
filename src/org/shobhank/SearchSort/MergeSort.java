/**
*@author
*shsharma
*/
package org.shobhank.SearchSort;

public class MergeSort {

    public static void main(String[] args) {
        int a[] = {14,8,9,4,16,25,2,17,38,20};
        mergeSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
    
    public static void mergeSort(int a[],int i,int j){
        if(i<j){
            int m = (i+j)/2;
            mergeSort(a,i,m);
            mergeSort(a,m+1,j);
            merge(a,i,m,j);
        }
    }
    
    public static void merge(int a[],int p,int q,int r){
        int helper[] = new int[a.length];
        int i = p;
        int j = q+1;
        int k = p;
        while(i<=q && j<=r){
            if(a[i]<a[j]){
                helper[k++] = a[i++];
            }else{
                helper[k++] = a[j++];
            }
        }
        
        while(i<=q){
            helper[k++] = a[i++];
        }
        
        while(j<=r){
            helper[k++] = a[j++];
        }
        
        for(int z=p;z<=r;z++){
            a[z] = helper[z];
        }
    }
    

}


