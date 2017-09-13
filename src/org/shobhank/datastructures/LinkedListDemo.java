package org.shobhank.datastructures;

import java.util.Random;
import java.util.Stack;

/**
 * Created by shobhanksharma on 3/13/17.
 */
class LinkedList{
    NodeLL head;
    NodeLL tail;

    public void add(int info){
        NodeLL n = new NodeLL(info);
        if(head == null) {
            head = n;
            tail = n;
        }
        else{
            n.next = head;
            head = n;
        }
    }

    public void append(int info){
        NodeLL n = new NodeLL(info);
        if(head == null){
            head = n;
            tail = n;
        }else{
            tail.next = n;
            tail = n;
        }
    }

    public void display(){
        NodeLL trav = head;
        while(trav!=null){
            System.out.print(trav.info + "->");
            trav = trav.next;
        }
        System.out.println();
    }

    public void delete(int info){
        if(head==null)
            return;
        if(head.next==null){//Single element list
            if(head.info == info)
                head = null;
        }

        if(head.info == info){
            // delete first element
            head = head.next;
        }

        NodeLL curr = head.next;
        NodeLL prev = head;
        while(curr!=null && curr.info!=info){
            curr = curr.next;
            prev = prev.next;
        }
        if(curr==null)
            return;
        prev.next = curr.next;
    }

    public NodeLL getMiddle(){
        NodeLL p1 = head;
        NodeLL p2 = head;
        while(p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public NodeLL nthFromEnd(int n){
        NodeLL trav1 = head;
        NodeLL trav2 = head;
        for(int i=1;i<=n;i++){
            trav1 = trav1.next;
        }
        while(trav1!=null){
            trav2 = trav2.next;
            trav1 = trav1.next;
        }
        return trav2;
    }

    public static NodeLL reverse(NodeLL list){
        if(list == null || list.next==null)
            return list;
        NodeLL rest = list.next;
        NodeLL reverse = reverse(rest);
        rest.next = list;
        list.next = null;
        return reverse;
    }

    public boolean isCircular(){
        NodeLL p1 = head;
        NodeLL p2 = head;
        while(p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
            if(p1 == p2)
                return true;
        }
        return false;
    }

    public boolean isPalindrome(){
        if(head==null || head.next==null)
            return true;
        Stack<NodeLL> s = new Stack<>();
        NodeLL t1 = head;
        while(t1!=null){
            s.push(t1);
            t1 = t1.next;
        }
        t1 = head;
        while(t1!=null){
            if(t1.info!=s.pop().info)
                return false;
            t1 = t1.next;
        }
        return true;
    }

    public void sortedInsert(int info){
        NodeLL trav = head;
        if(trav==null) {
            head = new NodeLL(info);
            return;
        }
        while(trav!=null && trav.info<info){
            if(trav.next==null){
                trav.next = new NodeLL(info);
                return;
            }
            trav = trav.next;
        }
        NodeLL newNode = new NodeLL(trav.info);
        trav.info = info;
        newNode.next = trav.next;
        trav.next = newNode;
    }

    public NodeLL intersection(LinkedList l1, LinkedList l2){
        NodeLL n1 = l1.head;
        NodeLL n2 = l2.head;
        int c1 = count(n1);
        int c2 = count(n2);
        if(c1>c2){
            while(c1!=c2){
                n1 = n1.next;
                c1--;
            }
        }else if(c1<c2){
            while(c1!=c2){
                n2 = n2.next;
                c2--;
            }
        }
        while(n1!=null && n2!=null){
            if(n1==n2)
                return n1;
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }

    public static int count(NodeLL n){
        int count = 0;
        NodeLL trav = n;
        while(trav!=null){
            count++;
            trav = trav.next;
        }
        return count;
    }

    public void removeDuplicates(){
        if(head.next==null)
            return;
        NodeLL i = head;
        NodeLL j = head;
        while(j!=null){
            if(i.info == j.info){
                j = j.next;
            }else{
                i = i.next;
                i.info = j.info;
            }
        }
        i.next = null;
    }

    public void printBackwards(NodeLL n){
        if(n==null)
            return;
        printBackwards(n.next);
        System.out.print(n.info + "<-");
    }

    public static NodeLL mergeSort(NodeLL n){
        if (n == null || n.next == null)
            return n;
        int mid = count(n) / 2;
        NodeLL l = n, r = null, temp = n;
        int count = 1;
        // split the linkedlist at middle
        while (temp != null) {
            if (count == mid) {
                r = temp.next;
                temp.next = null;
            }
            temp = temp.next;
            count++;
        }
        return merge(mergeSort(l), mergeSort(r));
    }

    public static NodeLL merge(NodeLL list1, NodeLL list2){
        LinkedList list = new LinkedList();
        while (list1 != null && list2 != null) {
            if (list1.info < list2.info) {
                list.add(list1.info);
                list1 = list1.next;
            } else if (list1.info > list2.info) {
                list.add(list2.info);
                list2 = list2.next;
            } else {
                list.add(list1.info);
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        if (list2 != null) {
            while (list2 != null) {
                list.add(list2.info);
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            while (list1 != null) {
                list.add(list1.info);
                list1 = list1.next;
            }
        }
        list.head = list.reverse(list.head);
        return list.head;    }

    public static NodeLL getMiddle(NodeLL n){
        NodeLL p1 = n;
        NodeLL p2 = n;
        while(p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public LinkedList reverseGroup(int k) {
        NodeLL temp = head;
        int count = 1;
        LinkedList reversed = new LinkedList();
        java.util.Stack<Integer> s = new java.util.Stack<Integer>();
        while (temp != null) {
            s.push(temp.info);
            if (count % k == 0) {
                while (!s.isEmpty()) {
                    reversed.append(s.pop());
                }
            }
            count++;
            temp = temp.next;
        }
        while (!s.isEmpty()) {
            reversed.append(s.pop());
        }
        return reversed;
    }


    public void deleteLesserNode() {
        NodeLL prev = head;
        NodeLL curr = head.next;
        while (curr != null) {
            if (prev.info < curr.info) {
                if (prev == head) {
                    head = curr;
                }
            }
        }
    }

    public void deleteNAfterM(int n, int m) {
        NodeLL temp = head;
        NodeLL temp2 = head;
        while (true) {
            int i = m, j = n;
            while (temp != null && i > 1) {
                temp = temp.next;
                i--;
            }
            if (temp == null)
                break;
            temp2 = temp.next;
            while (temp2 != null && j > 1) {
                temp2 = temp2.next;
                j--;
            }
            if (temp2 == null)
                break;
            temp.next = temp2.next;
            temp = temp.next;
        }
    }

    public void seggregate(){
        NodeLL temp = head;
        int counts[] = {0,0,0};
        while(temp!=null){
            counts[temp.info]++;
            temp = temp.next;
        }
        temp = head;
        for(int i=0;i<counts.length;i++){
            while(counts[i] > 0){
                temp.info = i;
                temp = temp.next;
                counts[i]--;
            }
        }
    }

    public static void mergeAlternate(NodeLL head1, NodeLL head2) {
        NodeLL temp1 = head1;
        NodeLL temp2 = head2;
        while (temp1 != null && temp2 != null) {
            NodeLL temp = temp2.next;
            temp2.next = temp1.next;
            temp1.next = temp2;
            temp1 = temp2.next;
            temp2 = temp;
        }
    }

    public void pairSwapLink() {
        NodeLL curr = this.head.next;
        NodeLL prev = this.head;
        NodeLL temp = head;
        int flag = 0;
        while (curr != null) {
            prev.next = curr.next;
            curr.next = prev;
            if (flag == 0) {
                head = curr;
                flag = 1;
            } else {
                temp.next = curr;
            }
            temp = prev;
            prev = prev.next;
            if (prev == null)
                break;
            curr = prev.next;
        }
    }

//    public void flattenList() {
//        NodeLL temp = head;
//        java.util.Queue<NodeLL> q = new java.util.LinkedList<NodeLL>();
//        q.add(temp);
//        while(!q.isEmpty()){
//            NodeLL curr = q.poll();
//            while(curr!=null){
//                System.out.print(curr.info + "->");
//                if(curr.child!=null){
//                    q.add(curr.child);
//                }
//                curr = curr.next;
//            }
//        }
//    }

    public static LinkedList addNumbers(LinkedList l1,LinkedList l2){
        int carry = 0;
        LinkedList l3 = new LinkedList();
        NodeLL h1 = reverse(l1.head);
        NodeLL h2 = reverse(l2.head);
        while(h1!=null && h2!=null){
            l3.add((h1.info + h2.info + carry)%10);
            if(h1.info + h2.info + carry > 9)
                carry = 1;
            else
                carry = 0;
            h1 = h1.next;
            h2 = h2.next;
        }
        if(h1!=null){
            while(h1!=null){
                l3.add((h1.info + carry)%10);
                if(h1.info + carry > 9)
                    carry = 1;
                else
                    carry = 0;
                h1 = h1.next;
            }
        }
        if(h2!=null){
            while(h2!=null){
                l3.add((h2.info + carry)%10);
                if(h2.info + carry > 9)
                    carry = 1;
                else
                    carry = 0;
                h2 = h2.next;
            }
        }
        if(carry!=0)
            l3.add(carry);
        return l3;
    }

    public void rotate(int k){
        NodeLL temp = head;
        while(temp!=null && k>1){
            temp = temp.next;
            k--;
        }
        NodeLL tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        NodeLL temp2 = temp.next;
        temp.next = null;
        tail.next = head;
        head = temp2;
    }


    public static  int countNodes(NodeLL head) {
        int count = 0;
        NodeLL temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void add(NodeLL n) {
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    public void traverse() {
        NodeLL temp = head;
        while (temp != null) {
            System.out.print(temp.info + "->");
            temp = temp.next;
        }
    }

    public static int median(LinkedList l1,LinkedList l2){
        NodeLL h1 = l1.head;
        NodeLL h2 = l2.head;
        int count = 0 ;
        int mid = (LinkedList.countNodes(h1) + LinkedList.countNodes(h2))/2;
        while(h1!=null && h2!=null){
            if(count == mid)
                return h1.info < h2.info? h1.info:h2.info;
            if(h1.info < h2.info)
                h1 = h1.next;
            else
                h2 = h2.next;
            count++;
        }
        if(h1!=null){
            if(count==mid)
                return h1.info;
            h1 = h1.next;
        }
        if(h2!=null){
            if(count==mid)
                return h2.info;
            h2 = h2.next;
        }
        return -99;
    }

    /**
     *
     * @param head
     *
     * Input : 1 -> -2 -> -3 -> 4 -> -5
    output: -5 -> -3 -> -2 -> 1 -> 4
     */
    public void sortListSortedByAbsoluteValues(NodeLL head){
        if(head.next==null)
            return;
        NodeLL curr = head.next;
        NodeLL prev = head;
        while(curr!=null){
            if(curr.info<0){
                this.add(curr.info);
                prev.next = curr.next;
                curr = prev.next;
            }else{
                prev = prev.next;
                curr = prev.next;
            }
        }
    }

    /**
     * Reservoir sampling
     * @return
     */
    public int getRandom(){
        NodeLL trav = head;
        int out = trav.info;
        Random randomGenerator = new Random();
        for(int i=1;trav!=null;i++){
            int randInt = randomGenerator.nextInt(i);
            if(randInt == 0)
                out = trav.info;
            trav = trav.next;
        }
        return out;
    }

    public NodeLL detectCycle(NodeLL head) {
        if(head==null || head.next==null || head.next.next==null)
            return null;
        NodeLL p1 = head;
        NodeLL p2 = head;
        while(p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1==p2)
                break;
        }
        if(p2==null || p2.next==null)
            return null;
        p1 = head;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static int find(LinkedList l1, LinkedList l2){
        NodeLL h1 = l1.head;
        NodeLL h2 = l2.head;
        int output = -1;
        while(h1!=null && h2!=null){
            if(h1.info == h2.info){
                output++;
                while(h1!=null && h2!=null && h1.info==h2.info){
                    h1 = h1.next;
                    h2 = h2.next;
                }
                if(h2 == null) {
                    return output;
                }
                else {
                    h2 = l2.head;
                }
            }else{
                h1 = h1.next;
                output++;
            }
        }
        return -1;
    }

}



public class LinkedListDemo {
    public static void main(String as[]){
        LinkedList l1 = new LinkedList();
        l1.add(5);
        l1.add(4);
        l1.add(3);
        l1.add(2);
        l1.add(1);

        LinkedList l2 = new LinkedList();
        l2.add(5);
        l2.add(4);
        l2.add(3);

        System.out.println(LinkedList.find(l1,l2));

//        LinkedList l1 = new LinkedList();
//        l1.append(1);
//        l1.append(-2);
//        l1.append(-3);
//        l1.append(4);
//        l1.append(-5);
//        l1.append(6);
//        l1.display();
//        l1.sortListSortedByAbsoluteValues(l1.head);
//        l1.display();
//        l1.printBackwards(l1.head);
//        l1.removeDuplicates();
//        l1.display();
//        l1.display();
//        l1.delete(50);
//        l1.display();
//        System.out.println(l1.getMiddle().info);
//        System.out.println(l1.nthFromEnd(4));
//        l1.head = l1.reverse(l1.head);
//        l1.display();
//        System.out.println(l1.isCircular());
//        l1.tail.next = l1.head;
//        System.out.println(l1.isCircular());
//        LinkedList l2 = new LinkedList();
//        l2.add(10);
//        l2.add(20);
//        l2.add(30);
//        l2.add(30);
//        l2.add(20);
//        l2.add(10);
//        System.out.println(l2.isPalindrome());

//        LinkedList l3 = new LinkedList();
//        l3.sortedInsert(50);
//        l3.sortedInsert(20);
//        l3.sortedInsert(40);
//        l3.sortedInsert(30);
//        l3.sortedInsert(10);
//        l3.display();

//        LinkedList l4 = new LinkedList();
//        l4.add(100);
//        l4.add(90);
//        l4.add(80);
//        l4.head.next.next.next = l1.head.next.next;
//        System.out.println(l4.intersection(l1,l4));
//        LinkedList l5 = new LinkedList();
//        l5.append(7);
//        l5.append(6);
//        l5.append(5);
//        l5.append(4);
//        l5.append(3);
//        l5.append(2);
//        l5.append(1);
//        for(int i=1;i<=10;i++){
//            System.out.println(l5.getRandom());
//        }
//        l5.display();
//        l5.head = LinkedList.mergeSort(l5.head);
//        l5.display();
    }
}

class NodeLL{
    int info;
    NodeLL next;

    public NodeLL(int info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "NodeLL{" +
                "info=" + info +
                '}';
    }
}