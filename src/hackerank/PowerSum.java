package hackerank;

/**
 * Created by shobhanksharma on 8/6/17.
 */

/**
 * Find the number of ways that a given integer, , can be expressed as the sum of the  power of unique, natural numbers.
 */
public class PowerSum {
    public static void main(String[] args) {
        int X = 10;
        int N = 2;
        System.out.println(powerSum(X,N,1));
    }

    public static int powerSum(int X, int N, int curr){
        int sum = (int) (X - Math.pow(curr,N));
        if(sum == 0){
            return 1;
        }else if(sum<0){
            return 0;
        }else{
            return powerSum(sum, N, curr+1) +
            powerSum(X, N, curr+1);
        }
    }
}
