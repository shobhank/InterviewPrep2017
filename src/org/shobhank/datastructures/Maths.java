package org.shobhank.datastructures;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;
import java.util.Stack;

/**
 * Created by shobhanksharma on 4/29/17.
 */
public class Maths {
    public static void main(String as[]) throws InvalidArgumentException {
//        System.out.println(parseInt("-834"));
//        System.out.println(parseDouble("-963.065"));
//        System.out.println(floatingPointConversion("99.01E-1"));
//        System.out.println(excelNumberToColumn(126));
//        System.out.println(excelColumnToNumber("DV"));
//        System.out.println(evaluateExpression("2+3*12-14/2"));
//        System.out.println(gcd(1701,3768));
//        System.out.println(differenceBetweenDays(new Date(7,1945, 3), new Date(31, 2009, 8)));
//        System.out.println(toBaseN(30,2));
//        System.out.println(decimalToBinary(49));
//        System.out.println(binaryToDecimal("110001"));
//        System.out.println(excelNumberToColumn(53));
//        System.out.println(reverse(1534236469));
//        System.out.println(isPalindrome(-2147447412));
//        System.out.println(hammingDistance(1,4));
        System.out.println(complement(11));
    }

    public static int complement(int num){
        int mask = 1;
        int x = num;
        while (num>0){
            num = num >> 1;
            mask = mask << 1;
        }
        return x ^ (mask-1);
    }

    public static int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;
        while(xor>0){
            count += xor&1;
            xor = xor>>1;
        }
        return count;
    }

    public static boolean isPalindrome(int x) {
        long y = x;
        if(y<0)
            y = Math.abs(y);
        int i = 1;
        int j=0;
        long num = y;
        while(num>0){
            num = num/10;
            j++;
        }
        j--;
        while (j>0){
            long left = y/(pow(10,j));
            long right = y%10;

            if(left!=right)
                return false;

            y = y - (left*pow(10,j));
            y = y/10;
            j = j-2;
        }
        return true;
    }

    public static int pow(int x, int n){
        return (int) Math.pow(x,n);
    }

    public static int parseInt(String input){
        boolean isNegative = false;
        int i = 0;
        if(input.charAt(0)=='-') {
            isNegative = true;
            i++;
        }
        int out = 0;
        for(;i<input.length();i++){
            // handle other number format exception
            out = (out * 10) + input.charAt(i)-'0';
        }
        return isNegative?-1*out:out;
    }

    public static double parseDouble(String input){
        boolean isNegative = false;
        int i=0;
        if(input.charAt(0)=='-'){
            isNegative = true;
            i=1;
        }
        double out = 0.0;
        // before decimal part
        for(;i<input.length();i++){
            if(input.charAt(i)=='.') {
                i++;
                break;
            }
            out = out * 10;
            out = out + (input.charAt(i) - '0');
        }

        // after decimal part
        double decimalPart = 0.0;
        double factor = 10.0;
        for(;i<input.length();i++){
            decimalPart = decimalPart + (input.charAt(i) - '0')/factor;
            factor = factor*10;
        }

        out = out + decimalPart;

        return isNegative?-1*out:out;
    }

    public static double floatingPointConversion(String input){
        // 96.3E2
        StringTokenizer tokenizer = new StringTokenizer(input, "E");
        String doublePart = tokenizer.nextToken();
        String power = tokenizer.nextToken();
        double out = parseDouble(doublePart);
        out = out * (Math.pow(10.0, parseInt(power)));
        return out;
    }

    public static int excelColumnToNumber(String in){
        int out = 0;
        for (int i=0;i<in.length();i++){
            out = out*26 + (in.charAt(i)-'A'+1);
        }
        return out;
    }

    public static String excelNumberToColumn(int input){
        String out = "";
        while (input>0){
            out = excelNumberToChar(input%26) + out;
            input = (int) Math.ceil(input/26.0);
            input--;
        }
        return out;
    }

    private static char excelNumberToChar(int input){
        if(input==0)
            return 'Z';
        return (char) (input + 'A' - 1);
    }

    public static int evaluateExpression(String input) throws InvalidArgumentException {
        Stack<Character> operator = new Stack();
        Stack<Integer> operand = new Stack();
        String x = "";
        String y = "";
        int i = 0;
        while (i<input.length()){
            char current = input.charAt(i);
            if (isOperator(current)){
                if(hasHigherPrecedence(current)){
                    y = "";
                    while ((i+1)<input.length() && !isOperator(input.charAt(i+1))){
                        i++;
                        y = y + input.charAt(i);
                    }
                    x = Integer.toString(calculate(Integer.parseInt(x),Integer.parseInt(y),current));
                }else{
                    operator.push(current);
                    operand.push(Integer.parseInt(x));
                    x = "";
                }
            }else{
                x = x + current;
            }
            i++;
        }
        operand.push(Integer.parseInt(x));

        while (!operator.isEmpty()){
            char operation = operator.pop();
            int v2 = operand.pop();
            int v1 = operand.pop();
            operand.push(calculate(v1,v2,operation));
        }
        return operand.pop();
    }

    private static boolean isOperator(char c){
        return c=='+' || c=='-' || c=='*' || c=='/';
    }

    private static boolean hasHigherPrecedence(char c){
        return (c=='*' || c=='/');
    }

    private static int calculate(int a, int b, char operator) throws InvalidArgumentException {
        switch (operator){
            case '*':
                return a*b;
            case '/':
                return a/b;
            case '+':
                return a+b;
            case '-':
                return a-b;
            default:
                throw new InvalidArgumentException(new String[]{"Invalid Operation"});
        }
    }

    public static int gcd(int num1, int num2){
        num2 = num2>num1?num2:num1;
        while (num1>0){
            int temp = num1;
            num1 = num2%num1;
            num2 = temp;
        }
        return num2;
    }

    public static int differenceBetweenDays(Date d1, Date d2){
        int monthDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        // days
        int days1 = d1.year*365 + d1.day;
        int days2 = d2.year*365 + d2.day;

        // month days
        for(int i=0;i<d1.month-1;i++){
            days1 = days1 + monthDays[i];
        }
        for(int i=0;i<d2.month-1;i++){
            days2 = days2 + monthDays[i];
        }

        // add 1 for current leap year
        if(d1.month>2 && isLeapYear(d1.year))
            days1++;
        if(d2.month>2 && isLeapYear(d2.year))
            days2++;

        // add for all the leap years
        days1 = days1 + d1.year/4 + d1.year/400 - d1.year/100;
        days2 = days2 + d2.year/4 + d2.year/400 - d2.year/100;
        return Math.abs(days1-days2);
    }

    public static boolean isLeapYear(int year){
        if(year%400==0)
            return true;
        if(year%4==0 && year%100!=0)
            return true;
        return false;
    }

    public static int toBaseN(int num, int base){
        int out = 0;
        int factor = 1;
        while (num>0){
            out = out + (num%base)*factor;
            num = num/base;
            factor = factor*10;
        }
        return out;
    }

    public static double binaryToDecimal(String binary){
        int i=binary.indexOf('.')-1;
        if(binary.indexOf('.')==-1)
            i = binary.length()-1;
        int factor = 1;
        double out = 0.0;
        while(i>=0){
            out = out + (binary.charAt(i)-'0')*factor;
            factor = factor*2;
            i--;
        }
        if(binary.indexOf('.') == -1)
            return out;

        i = binary.indexOf('.')+1;
        factor = 2;
        while(i<binary.length()){
            out = out + (binary.charAt(i)-'0') * (1.0/factor);
            factor = factor*2;
            i++;
        }
        return out;
    }

    public static String decimalToBinary(double decimal){
        double d = decimal - (int)decimal;
        int i = (int)decimal;
        String out = "";
        while(i>0){
            out = i%2 + out;
            i = i/2;
        }
        if(d==0.0)
            return out;
        out = out + '.';
        while(true){
            d = d*2;
            if(d==1.0) {
                out = out + '1';
                break;
            }
            else if(d>1.0)
                out = out + '1';
            else
                out = out + '0';
            d = d - (int)d;
        }
        return out;
    }

    /*
C(n,k) = (n!)/((n-k)!*k!)
= [n * (n-1) * (n-2)... *(n-k+1)*(n-k)*(n-k-1)*(n-k-2)...*1]/[(n-k)! * (k * (k-1) * (k-2)...1)]
= [n* (n-1) * (n-2)... n-k+1]/[k * (k-1) * (k-2)...]
 */
    public int calculate(int n, int k){
        if(k > n-k){
            k = n-k;
        }
        int result = 1;
        for(int i=0; i < k; i++){
            result *= (n-i);
            result /= (i+1);
        }
        return result;
    }

    public static String isFibo(long a){
        if(isPerfect(5*(a*a)+4) || isPerfect(5*(a*a)-4))
            return "IsFibo";
        else
            return "IsNotFibo";
    }

    public static boolean isPerfect(long n){
        return Math.sqrt(n)*Math.sqrt(n) == n;
    }

    public int power(int n, int m){
        if(m==0)return 1;
        if(m==1)return n;
        if(m%2==0)
            return power(n,m/2)*power(n,m/2);
        else
            return power(n,m/2)*power(n,m/2)*n;
    }

    /**
     * Formula for newton's sqrt is
     * new = (old + N/old)*1/2
     * let old = x and N/old = y
     *
     * @param n
     * @return
     */
    static double squareRoot(float n)
    {
      /*We are using n itself as initial approximation
       This can definitely be improved */
        double x = n;
        double y = 1;
        double e = 0.000001; /* e decides the accuracy level*/
        while(x - y > e)
        {
            x = (x + y)/2;
            y = n/x;
        }
        return x;
    }

    public int trailing0s(int num){

        int total = num/5; // number of 5s
        // but thsi is not enough, we may have 25s which has 2 fives

        int pow = 1;
        while(pow < num){
            pow = pow*5;
        }

        int index = 1;
        while(pow > 5){
            total = total + index;
            index++;
            pow = pow/5;
        }

        return total;
    }

    public static int reverse(int x){
        long out = 0;
        boolean isNegative = x<0;
        x = Math.abs(x);
        while(x>0){
            out = out*10 + (x%10);
            x = x/10;
        }
        if(out>Integer.MAX_VALUE) // checks overflow condition. If overflow then return 0
            return 0;
        return (int)(isNegative?out*(-1):out);
    }

    public double angle(int hour, int min){
        double hourAngle = (hour%12)*360/12 + ((double)min/60)*(360/12);
        double minAngle = min*360/60;

        double angleDiff = Math.abs(hourAngle - minAngle);
        return angleDiff < 360 - angleDiff ? angleDiff : 360 - angleDiff;
    }
}

class Date {
    int day;
    int year;
    int month;

    public Date(int day, int year, int month) {
        this.day = day;
        this.year = year;
        this.month = month;
    }
}
