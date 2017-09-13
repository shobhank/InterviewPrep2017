/**
*@author
*shsharma
*/
package org.shobhank.datastructures;

public class StackDemo {

    public static void main(String[] args) {
//        Stack s = new Stack(5);
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        s.push(4);
//        s.push(5);
//        s.push(6);
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        Stack s = new Stack(5);
//        s.push(30);
//        s.push(-5);
//        s.push(18);
//        s.push(14);
//        s.push(-3);
//        s.sortStack(s);
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        QS q = new QS(5);
//        q.enqueue(10);
//        q.enqueue(20);
//        q.enqueue(30);
//        q.enqueue(40);
//        q.enqueue(50);
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
        MinMaxStack mms = new MinMaxStack(10);
        mms.push(10);
        mms.push(5);
        mms.push(15);
        mms.push(20);
        mms.push(8);
        mms.pop();
        mms.pop();
        mms.push(2);
        System.out.println(mms.max());
        System.out.println(mms.min());
    }

}

class MinMaxStack {
    Stack min;
    Stack max;
    Stack stack;

    MinMaxStack(int size){
        min = new Stack(size);
        max = new Stack(size);
        stack = new Stack(size);
    }

    public void push(int value){
        stack.push(value);
        if(value < min.top() || min.top()==-1)
            min.push(value);
        if(value > max.top() || min.top()==-1)
            max.push(value);
    }

    public int pop(){
        int temp = stack.pop();
        if(temp == min.top())
            min.pop();
        if(temp == max.top())
            max.pop();
        return temp;
    }

    public int min(){
        return min.top();
    }

    public int max(){
        return max.top();
    }
}

class QS {
    Stack stack1;
    Stack stack2;
    QS(int size){
        stack1 = new Stack(size);
        stack2 = new Stack(size);
    }

    /*
    This is making enqueue expensive, we can make enqueue better
    but dequeue expensive by poping eveything from stack1 and pushing in stack2
    return the top element from stack2

     */
    public void enqueue(int value){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int dequeue(){
        return stack1.pop();
    }
}

class Stack{
    int stack[];
    int top = -1;
    int size;
    Stack(int size){
        stack = new int[size];
        this.size = size;
    }
    
    void push(int value){
        if(top>=size-1){
            System.out.println("Stack Full");
            return;
        }
        top++;
        stack[top] = value;
    }
    
    int pop(){
        if(top <=-1){
            System.out.println("Stack Empty");
            return -99;
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    void sortStack(Stack s){
        if(!s.isEmpty()){
            int temp = s.pop();
            sortStack(s);
            sortedInsert(s, temp);
        }
    }

    int top(){
        if(top==-1)
            return -1;
        else
            return stack[top];
    }

    void sortedInsert(Stack s, int element){
        if(s.isEmpty() || element>s.top())
            s.push(element);
        else{
            int temp = s.pop();
            sortedInsert(s, element);
            s.push(temp);
        }
    }

    boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }
}


