package org.shobhank.miscellaneous;

/**
 * http://www.geeksforgeeks.org/fast-multiplication-method-without-using-multiplication-operator-russian-peasants-algorithm/
 * Test cases
 * Division by 0
 * Negative numbers
 *
 * Let the two given numbers be 'a' and 'b'
 1) Initialize result 'res' as 0.
 2) Do following while 'b' is greater than 0
 a) If 'b' is odd, add 'a' to 'res'
 b) Double 'a' and halve 'b'
 3) Return 'res'.
 */
public class RussianPeasantMultiplication {

    public int multiply(int a,int b){
        int res = 0;
        while(b > 0){
            if(b % 2 != 0){
                res += a;
            }
            a = a<<1;
            b = b>>1;
        }
        return res;
    }
    
    public static void main(String args[]){
        RussianPeasantMultiplication rpm = new RussianPeasantMultiplication();
        System.out.println(rpm.multiply(7, 13));
    }
}
