/**
*@author
*shsharma
*/
package org.shobhank.patternsearching;

public class KMP {

    public static void main(String[] args) {
        String patt = "ABABCABAB";
        int pi[] = preprocess(patt.toCharArray());
        for(int i=0;i<pi.length;i++)
            System.out.print(pi[i] + " ");
    }
    
    public static int[] preprocess(char patt[]){
        int pi[] = new int[patt.length];
        int len = 0;
        int i = 1;
        pi[0] = 0;
        while(i<patt.length){
            if(patt[i] == patt[len]){
                len++;
                pi[i] = len;
                i++;
            }else{
                if(len!=0){
                    len = pi[len-1];
                }else{
                    pi[i] = 0;
                    i++;
                }
            }
        }
        return pi;
    }

}


