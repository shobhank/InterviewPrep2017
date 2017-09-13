/**
*@author
*shsharma
*/
package org.shobhank.patternsearching;

public class RabinKarp {
    final static int Q = 997;
    final static int R = 256;
    
    public static void main(String[] args) {
        char pat[] = new String("is").toCharArray();
        char text[] = new String("This is a test and is going to rise").toCharArray();
        search(pat,text);
    }
    
    static int hash(char a[]){
        int h = 0;
        for(int i=0;i<a.length;i++){
            h = (R*h + a[i]);
        }
        return h%Q;
    }
    
    static void search(char pat[],char text[]){
        
        //get hash for pattern 
        int p = hash(pat);
        int t = 0;
        int h = 1;
        
        //get first hash for text
        for(int i = 0;i<pat.length;i++){
            t = (R*t + text[i]);
        }
        t = t%Q;
        
        //get multiplier to subtract the most significant digit
        for (int i = 1; i < pat.length; i++)
            h = (h*R)%Q;
        
        //get rolling hashes and compare with p
        for(int i=0;i<text.length-pat.length;i++){
            if(p == t){
                boolean flag = true;
                for(int k=0;k<pat.length;k++){
                    if(pat[k] != text[i+k])
                        flag = false;
                }
                if(flag == true)
                    System.out.println(i);
            }
            if(i < text.length - pat.length){
                t = (R*(t - text[i]*h) + text[i+pat.length])%Q;
                if(t < 0)
                    t = t + Q;
            }
        }
    }

}


