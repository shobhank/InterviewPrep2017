/**
 *@author
 *shsharma
 */
package org.shobhank.patternsearching;

public class FindSubstring {

    public static void main(String[] args) {
        String text = "Thiis isis a teiist text";
        String pattern = "is";
        searchPattern(text, pattern);
    }

    static void searchPattern(String text, String pattern) {
        int i = 0;
        while(i<text.length()){
            int j = 0;
            while(j<pattern.length() && text.charAt(i+j)==pattern.charAt(j)){
                j++;
            }
            if(j==pattern.length()){
                System.out.println(i);
            }
            i++;
        }
    }
    

}
