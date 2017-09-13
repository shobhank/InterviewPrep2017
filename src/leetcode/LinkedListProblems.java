package leetcode;

/**
 * Created by shobhanksharma on 5/26/17.
 */
public class LinkedListProblems {

    ListNode head = null;
    ListNode tail = null;

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(9);

        System.out.println(new LinkedListProblems().addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry;
            if(sum>=10){
                carry = 1;
                sum = sum%10;
            }else
                carry = 0;
            addToList(sum);
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1==null && l2==null && carry!=0) {
            addToList(carry);
            return head;
        }

        while (l1!=null){
            int sum = l1.val + carry;
            if(sum>=10){
                carry = 1;
                sum = sum%10;
            }else
                carry = 0;
            addToList(sum);
            l1 = l1.next;
        }

        while (l2!=null){
            int sum = l2.val + carry;
            if(sum>=10){
                carry = 1;
                sum = sum%10;
            }else
                carry = 0;
            addToList(sum);
            l2 = l2.next;
        }

        if(carry!=0)
            addToList(carry);
        return head;
    }

    public void addToList(int value){
        if(head==null) {
            head = new ListNode(value);
            tail = head;
        }else{
            tail.next = new ListNode(value);
            tail = tail.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}