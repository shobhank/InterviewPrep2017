package org.shobhank.miscellaneous;

/**
 * http://www.careercup.com/question?id=5399897561890816
 * Idea is simple. Count the number of times it takes to swap 0s such that all
 * 1's are at least significant position.
 * e.g 1010 -> 1001 -> 101 -> 11
 *     1010  -> 110 -> 101 -> 11
 *     
 * No matter which route you take it leads to same result so just looking at swaps you can say
 * which player will win
 *     
 */
public class WinnerWithBeautifulNumber {

    public char findWinner(int n){
        System.out.println("A plays " + n);
        int a = 0, b = 1; // b is current player
        while(n>=0){
            int next = findNextBeautifulNumber(n);
            if(a==1) System.out.println("A plays " + next);
            else System.out.println("B plays " + next);
            if(next == -1)
                return a==1? 'B':'A'; // it was As turn and he could not get next number so B is the winner
            n = next;
            a = a^1; // switch turns
            b = b^1;
        }
        return 'N';
    }

    public int findNextBeautifulNumber(int n){
        int last1s = count1s(n);
        int factor = 1;
        int num = n;
        while(num>0){
            num = num - ((int)Math.pow(2,factor));
            if(last1s == count1s(n - ((int)Math.pow(2,factor))))
                return n - ((int)Math.pow(2,factor));
            factor++;
        }
        return -1;
    }

    public int count1s(int n){
        int count = 0;
        while(n>0){
            count = count + (n & 0x1);
            n = n >> 1;
        }
        return count;
    }

    public int winner(int n){
        int sum = 0;
        int i =1;
        int result = 0;
        while( i <= n){
            i = i*2;
        }
        i = i/2;
        while(i > 0){
            if((n & i) != 0){
                sum++;
            }else{
                result += sum;
            }
            i = i/2;
        }
        if(result % 2 == 0){
            return 2;
        }else{
            return 1;
        }
    }
    
    public static void main(String args[]){
        WinnerWithBeautifulNumber wwb = new WinnerWithBeautifulNumber();
        System.out.println(wwb.findWinner(20) + " is the winner");
    }
}
