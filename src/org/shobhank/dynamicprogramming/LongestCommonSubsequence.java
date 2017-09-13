/**
*@author
*shsharma
*/
package org.shobhank.dynamicprogramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        char a[] = {'A','B','C','D','G','H'};
        char b[] = {'A','E','D','F','H','R'};
        System.out.println(longestCommonSubSeq(a,b));

    }
    
    public static int longestCommonSubSeq(char a[],char b[]){
        int soln[][] = new int[a.length+1][b.length+1];
        for(int i=0;i<=a.length;i++){
            for(int j=0;j<=b.length;j++){
                if(i==0 || j==0){
                    soln[i][j] = 0;
                    continue;
                }
                if(a[i-1] == b[j-1]){
                    soln[i][j] = 1 + soln[i-1][j-1];
                }else{
                    soln[i][j] = soln[i-1][j]>soln[i][j-1]?soln[i-1][j]:soln[i][j-1];
                }
            }
        }
        int i = 0,j=0;
        return soln[a.length][b.length];
    }

}


