package org.shobhank.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddingTwoSetOfIntervals {

    public static class Pair implements Comparable<Pair>{
        int low;
        int high;
        Pair(int low,int high){
            this.low = low;
            this.high = high;
        }
        @Override
        public int compareTo(Pair o) {
            if(this.low <= o.low){
                return -1;
            }else{
                return 1;
            }
        }
        
        public String toString(){
            return low + " " + high;
        }
    }

    /*
    1. Sort the intervals
    Do merge of the two arrays:
    2. Check if low of 1 is less than low of 2? then we are going to deal with 1 and hence current.low will be lower of 1
    3. If low of 1 is less than high of current that means there is a chance that it can be merged. eg.
    if current = 1,4 and we are currently processing 4,6 then we can probably merge it to 1,6. It could also be
    that we are currently processing 2,3 in that case it will be 1,4. Which means current.high will be max of current.high and
    high of currently processing array element
    4. If we know that currently processing array element cannot be merged then we can just add it to result and make it
    current for next processing
     */
    public List<Pair> combineInterval(Pair[] arr1, Pair[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        List<Pair> result = new ArrayList<Pair>();
        int i=0;
        int j=0;
        Pair current = new Pair(-1000,-1000);
        while(i < arr1.length && j < arr2.length){
            if(arr1[i].low <= arr2[j].low){
                if(arr1[i].low <= current.high){
                    current.high = Math.max(arr1[i].high,current.high);
                }else{
                    current = arr1[i];
                    result.add(current);
                }
                i++;
            }
            else{
                if(arr2[j].low <= current.high){
                    current.high = Math.max(arr2[j].high,current.high);
                }else{
                    current = arr2[j];
                    result.add(current);
                }
                j++;
            }
        }
        while(i < arr1.length){
            if(arr1[i].low <= current.high){
                current.high = Math.max(current.high,arr1[i].high);
            }else{
                current = arr1[i];
                result.add(current);
            }
            i++;
        }
        while(j < arr2.length){
            if(arr2[j].low <= current.high){
                current.high = Math.max(current.high, arr2[j].high);
            }else{
                current = arr2[j];
                result.add(current);
            }
            j++;
        }
        
        return result;
    }
    
    public static void main(String args[]){
        Pair p1 = new Pair(1,3);
        Pair p2 = new Pair(4,6);
//        Pair p3 = new Pair(9,15);
//        Pair p4 = new Pair(14,18);
        
        Pair[] arr1 = {p1,p2};
        
        Pair r1 = new Pair(2,4);
        Pair r2 = new Pair(7,8);
//        Pair r3 = new Pair(11,13);
        
        Pair[] arr2 = {r1,r2};
        
        AddingTwoSetOfIntervals ats = new AddingTwoSetOfIntervals();
        List<Pair> rs = ats.combineInterval(arr1, arr2);
        System.out.print(rs);
    }
    
}
