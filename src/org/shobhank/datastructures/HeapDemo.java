package org.shobhank.datastructures;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by shobhanksharma on 5/12/17.
 */
public class HeapDemo {
    public static void main(String[] args) {
//        int in[] = {30, 56, 22, 49, 30, 51, 2, 67};
//        System.out.println(checkIfMinHeapForLevelOrderTraversal(in));
//        String in = "abbbbcdeada";
//        System.out.println(rearrangeWithoutAdjacentDups(in));
//        int in[] = {10, 2, 50, 12, 48, 13};
//        System.out.println(sumOfAllElementsBetweenK1thAndK2thSmallestElement(in,2,6));
//        int in[] = {5,3,0,7,4};
//        System.out.println(minSumFormedFromDigits(in));
//        KthLargest kthLargest = new KthLargest(3);
//        int a[] = {10, 20, 11, 70, 50, 40, 100, 5};
//        for(int i=0;i<a.length;i++){
//            System.out.println(kthLargest.getKthLargest(a[i]));
//        }
//        int in[][] = {  {10, 20, 30, 40},
//                        {15, 25, 35, 45},
//                        {27, 29, 37, 48},
//                        {32, 33, 39, 50},
//        };
//        displayMatrixSortedByRowAndColInSortedOrder(in);
//        int in[] = {4,3,2,6};
//        System.out.println(minCostToConnectRopes(in));
        int a[][] = {{1,2,8,10},{3,9,11,12},{5,15,16,18}};
        displayMatrixSortedByRowAndColInSortedOrder(a);
    }

    public static boolean checkIfMinHeapForLevelOrderTraversal(int in[]){
        int i=in.length/2;
        while (i>=0){
            int leftIx = 2*i + 1;
            int rightIx = 2*i + 1;
            if(leftIx < in.length){
                if(in[i] > in[leftIx])
                    return false;
            }
            if(rightIx < in.length){
                if(in[i] > in[rightIx])
                    return false;
            }
            i--;
        }
        return true;
    }

    /**
     * Given a string with repeated characters, task is rearrange characters in a string so that no two adjacent characters are same.
     * @param str
     */
    public static String rearrangeWithoutAdjacentDups(String str){
        // Create priority Queue (Max Heap) based on frequency of character
        PriorityQueue<FreqNode> priorityQueue = new PriorityQueue<>(str.length(), new FreqNode('a',0));
        int count[] = new int[256];
        for(Character character: str.toCharArray()){
            count[character]++;
        }
        for(int i='a';i<='z';i++){
            int freq = count[i];
            if(freq==0)
                continue;
            FreqNode node = new FreqNode((char)i, freq);
            priorityQueue.add(node);
        }

        // Now, we follow greedy approach of adding most occuring character first to the result
        // and decrement its count, remove it temporarily and then go for next highest

        FreqNode last = null;
        FreqNode current = null;
        StringBuilder result = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            current = priorityQueue.poll();
            result.append(current.c);
            current.freq--;
            priorityQueue.remove(current);
            if(last!=null && last.freq!=0)
                priorityQueue.add(last);
            last = current;
        }
        if(last!=null && last.freq>0)
            return "Not Possible";
        return result.toString();
    }

    public static int sumOfAllElementsBetweenK1thAndK2thSmallestElement(int in[], int k1, int k2){
        MinHeap minHeap = new MinHeap(in);
        for(int i=1;i<=k1;i++){
            minHeap.poll();
        }
        int sum = 0;
        for(int i=k1+1;i<k2;i++){
            sum+= minHeap.poll();
        }
        return sum;
    }

    /**
     * Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of given array must be used to form the two numbers.
     *
     Input: [6, 8, 4, 5, 2, 3]
     Output: 604
     The minimum sum is formed by numbers
     358 and 246
     * @param a
     * @return
     */
    public static int minSumFormedFromDigits(int a[]){
        // Create min heap and poll two numbers from it and append to num1 and num2
        StringBuilder num1Str = new StringBuilder();
        StringBuilder num2Str = new StringBuilder();
        MinHeap minHeap = new MinHeap(a);
        while (minHeap.size>=0){
            num1Str.append(minHeap.poll());
            if(minHeap.size>=0)
                num2Str.append(minHeap.poll());
        }
        int num1 = Integer.parseInt(num1Str.toString());
        int num2 = Integer.parseInt(num2Str.toString());
        System.out.println("Min Sum " + num1 + " + " + num2);
        return num1+num2;
    }


    /**
     * Does not work for always??
     * Idea is to add first column to a min heap and
     * then keep displaying the root of the heap and replacing root with next element to be considered
     * IT can be optimized by replacing root with the next element from the same row as the root was from
     * @param a
     */
    public static void displayMatrixSortedByRowAndColInSortedOrder(int a[][]){
        int firstCol[] = new int[a.length];
        for(int i=0;i<a.length;i++){
            firstCol[i] = a[i][0];
        }
        MinHeap minHeap = new MinHeap(firstCol);
        for(int col=1;col<a[0].length;col++){
            for(int row=0;row<a.length;row++){
                System.out.print(minHeap.heap[0] +" ");
                minHeap.insertReplaceOnRoot(a[row][col]);
            }
        }

        while (minHeap.size>=0)
            System.out.print(minHeap.poll() + " ");
    }

    /**
     * There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.
     * Idea is to add it to all the ropes to minHeap and keep polling two minimum length ropes
     * Once rope is tied, add it back to the minHeap
     * @param in
     * @return
     */
    public static int minCostToConnectRopes(int in[]){
        MinHeap minHeap = new MinHeap(in);
        int cost = 0;
        while (minHeap.size>0){
            int r1 = minHeap.poll();
            int r2 = minHeap.poll();
            cost = cost + (r1 + r2);
            minHeap.insert(r1+r2);
        }
        return cost;
    }

}

class KthLargest{
    MinHeap heap;
    KthLargest(int k){
        heap = new MinHeap(new int[k]);
    }

    public int getKthLargest(int value){
        int temp = heap.heap[0];
        if(value>temp){
            heap.insertReplaceOnRoot(value);
            temp = heap.heap[0];
        }
        if(temp==0)
            return -1;
        return temp;
    }


}

class MinHeap{
    int heap[];
    int size;

    MinHeap(int[] in){
        heap = in;
        size = in.length-1;
        buildMinHeap();
    }

    private void buildMinHeap(){
        for(int i=heap.length/2-1;i>=0;i--){
            minHeapify(heap, i);
        }
    }

    private void minHeapify(int in[], int pos) {
        int leftIx = 2 * pos + 1;
        int rightIx = 2 * pos + 2;
        int minPos = pos;
        if (leftIx <= size && in[leftIx] < in[minPos])
            minPos = leftIx;
        if (rightIx <= size && in[rightIx] < in[minPos])
            minPos = rightIx;
        if (pos != minPos) {
            swap(in, pos, minPos);
            minHeapify(in, minPos);
        }
    }

    private void swap(int in[], int s, int t){
        int temp = in[s];
        in[s] = in[t];
        in[t] = temp;
    }

    public int poll(){
        int temp = heap[0];
        swap(heap, 0, size);
        size--;
        minHeapify(heap, 0);
        return temp;
    }

    public void insertReplaceOnRoot(int value){
        heap[0] = value;
        minHeapify(heap,0);
    }

    public void insert(int value){
        if(size<heap.length-1){
            size++;
            heap[size] = value;
            minHeapify(heap,0);
        }
    }
}

class FreqNode implements Comparator<FreqNode>{
    char c;
    int freq;

    public FreqNode(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FreqNode freqNode = (FreqNode) o;

        return c == freqNode.c;

    }

    @Override
    public int hashCode() {
        return (int) c;
    }

    @Override
    public String toString() {
        return "FreqNode{" +
                "c=" + c +
                ", freq=" + freq +
                '}';
    }

    @Override
    public int compare(FreqNode o1, FreqNode o2) {
        return o2.freq - o1.freq;
    }
}