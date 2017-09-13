/**
*@author
*shsharma
*/
package org.shobhank.datastructures;

import java.util.*;
import java.util.LinkedList;

public class QueueDemo {

    public static void main(String[] args) {
//        Queue q = new Queue(5);
//        q.push(10);
//        q.push(20);
//        q.push(30);
//        q.push(40);
//        q.push(50);
//        q.push(60);
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
        SQ sq = new SQ(5);
        sq.push(10);
        sq.push(20);
        sq.push(30);
        sq.push(40);
        sq.push(50);
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
    }

}

class Queue{
    private int arr[];
    private int front;
    private int rear;
    private int size;
    
    Queue(int size){
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }
    
    void push(int value){
        if(rear >= size-1){
            System.out.println("Queue Full");
            return;
        }else{
            if(front==-1){
                front++;
            }
            rear++;
            arr[rear] = value;
        }
    }
    
    int poll(){
        int temp;
        if(front==-1 || front>rear)
            return -99;
        else{
            temp = arr[front];
            front++;
        }
        return temp;
    }

    boolean isEmpty(){
        return (front==-1 || front>rear);
    }
}

class SQ {
    java.util.Queue<Integer> q1, q2;
    SQ(int size){
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    public void push(int value){
        q1.add(value);
    }

    /**
     * Making push expensive
     * @return
     */
    public int pop(){
        int curr = -99;
        while(true){
            curr = q1.poll();
            if(q1.isEmpty())
                break;
            q2.add(curr);
        }

        while (!q2.isEmpty())
            q1.add(q2.poll());
        return curr;
    }
}


