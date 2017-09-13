package org.shobhank.SearchSort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by shobhanksharma on 3/24/17.
 */

/*
Find median in stream of numbers
1. Create two heaps lowers which will be a maxHeap
    and highers which will be a minHeap
    eg. if we have numbers like 12,4,5,3,8,7
    lowers

      4

    highers

       5
    12

    Then median is 5 i.e. root element from heap that has more element

    Now insert 3
    since 3 is less than current median hence it goes in lowers
    lowers

    4
   3

   highers
     5
   12

    median is 4.5

    and so on...

 2. We will also do periodic rebalancing to keep size of the heaps differ max by 1
 */
public class MedianInStream {

    private int array[];

    private static PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -1* o1.compareTo(o2);
        }
    });

    private static PriorityQueue<Integer> highers = new PriorityQueue<>();

    public static void main(String as[]){
        Scanner s = new Scanner(System.in);
        s.nextInt();
        while(s.hasNext()){
            addNumber(s.nextInt());
            rebalance();
            System.out.println(findMedian());
        }
    }

    public static double findMedian(){
        if(lowers.size() == highers.size())
            return (lowers.peek() + highers.peek())/2.0;
        else if(lowers.size() > highers.size())
            return lowers.peek();
        else
            return highers.peek();
    }

    public static void bootstrap(int a[]){

        for(int i=0;i<a.length;i++){
            addNumber(a[i]);
            rebalance();
        }
    }

    public static void addNumber(int a){
        if(lowers.size()==0 || a < lowers.peek())
            lowers.add(a);
        else
            highers.add(a);
    }

    public static void rebalance(){
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
        PriorityQueue<Integer> smallerHeap = lowers.size()<highers.size()?lowers:highers;
        if(biggerHeap.size()-smallerHeap.size() >=2)
            smallerHeap.add(biggerHeap.poll());
    }
}
