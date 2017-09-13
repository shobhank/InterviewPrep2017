package org.shobhank.datastructures;

/**
 * Created by shobhanksharma on 4/29/17.
 */
public class BitManipulation {

    public static void main(String[] args) {
//        System.out.println(flipBits(10L)); // 1010 => 0101, 10 => 5
//        System.out.println(countSetBits(3636363));
        // 10000101 1 + 4 + 128 => 10100001
        System.out.println(reverseBits(133));
    }

    public static long flipBits(long input){
        long max = 15L;
        return input^max;
    }

    public static int countSetBits(int input){
        int count = 0;
        while (input>0){
            count = count + (input & 1);
            input = input >> 1;
        }
        return count;
    }

    public static int positionOfRightmostSetBit(int a){
        int twoSComplement = -a;
        // when we & number with its twos complement
        // all bits are reverted except the first one from the right
        return (int)Math.floor(Math.log(twoSComplement & a)/Math.log(2)) + 1;
    }

    /**
     *
     * @param a
     * @return returns reversed bit number
     * eg. 00000110 => 01100000 (in 8 bits)
     */
    public static int reverseBits(int a){
        final int BITS = 8;
        int reverse = 0;
        for(int i=0;i<BITS;i++){
            int temp = a & (1 << i); // mask to check if bit at i is 1
            if(temp!=0) // if 1 then we move 1 to that many bits and or it with reverse which is output
                reverse = reverse | (1 << (BITS-i-1));
        }
        return reverse;
    }

    /**
     * leftBy3(1110 0101) => 0010 1111
     * Similarly right rotation
     *
     * @param num
     * @param d
     * @return
     */
    public int rotateLeft(int num, int d){
        return ((num << d) | (num >> (8-d)));
    }

    /**
     * 01011101 => 10101110
     * @param num
     * @return
     */
    public int swapEvenOddBits(int num){
        int mask1 = 0xAAAAAAAA;
        int mask2 = 0x55555555;
        return (num << 1 & mask1) | ( num >> 1 & mask2);
    }

    /*
All the bits that are set in xor will be set in one non-repeating element (x or y) and not in other.
So if we take any set bit of xor and divide the elements of the array in two sets – one set of elements
with same bit set and other set with same bit not set.
By doing so, we will get x in one set and y in another set
 */
    public static void twoNumbersOccuringOddTimes(int arr[]){
        int r = 0;
        for(int i=0; i < arr.length; i++){
            r = r^arr[i];
        }

//        r = r & ~(r-1);
        int r1 = 0;
        int r2 = 0;
        for(int i=0; i < arr.length; i++){
            if((r&arr[i]) == 0){
                r1 = r1^arr[i];
            }else{
                r2 = r2^arr[i];
            }
        }
        System.out.println(r1 + " " + r2);
    }

    public static int nextPowerOf2(int num){
        int p=1;
        if(num ==0){
            return 1;
        }
        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while (p < num)
            p <<= 1;
        return p;
    }

    // 1. Make both the strings equal length by adding 0s
    // 2. sum = x ^ y ^ carry and carry = (x & y) | (y & carry) | (carry & x)
    public static String sum(String a, String b){
        int la = a.length()-1, lb = b.length()-1;
        while(la!=lb){
            if(la<lb){
                a = "0" + a;
                la++;
            }else{
                b = "0" + b;
                lb++;
            }
        }

        int i = a.length()-1;
        int carry = 0;
        String out = "";
        while(i>=0){
            int x = a.charAt(i)-'0';
            int y = b.charAt(i)-'0';
            int sum = x ^ y ^ carry;
            carry = (x & y) | (y & carry) | (carry & x);
            out = sum + out;
            i--;
        }
        if(carry == 1)
            out = carry + out;
        return out;
    }

    public int countBitswapsForNtoM(int m, int n){
        int r = n^m;
        int count = 0;
        while(r != 0){
            count = count + (r&1);
            r=r>>1;
        }
        return count;
    }
}
