package org.shobhank.misc;

/**
 * @author shsharma
 */

public class AddTwoBigInt {
    public static void main(String args[]) {
        String num1 = "11";
        String num2 = "9999";
        System.out.println(sum(num1, num2));
    }

    public static String sum(String str1, String str2){
        int i=str1.length()-1, j=str2.length()-1, carry =0;
        String out = "";
        while(i>=0 && j>=0){
            int sum = str1.charAt(i)-'0' + str2.charAt(j)-'0' + carry;
            if(sum>=10){
                carry = 1;
                sum = sum - 10;
            }else{
                carry = 0;
            }
            out = sum + out;
            i--;
            j--;
        }

        while(i>=0){
            int sum = str1.charAt(i)-'0' + carry;
            if(sum>=10){
                carry = 1;
                sum = sum - 10;
            }else{
                carry = 0;
            }
            out = sum + out;
            i--;
        }

        while(j>=0){
            int sum = str2.charAt(j)-'0' + carry;
            if(sum>=10){
                carry = 1;
                sum = sum - 10;
            }else{
                carry = 0;
            }
            out = sum + out;
            j--;
        }

        if(carry!=0)
            out = carry + out;
        return out;
    }
}
