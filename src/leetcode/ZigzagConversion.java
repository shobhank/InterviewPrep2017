package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shobhanksharma on 8/8/17.
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        if(numRows==2)
            return forTwoRows(s);
        StringBuilder str = new StringBuilder();
        boolean topToBottom = true;
        int i=0;
        List<Character> lists[] = new List[numRows];
        for(int x=0;x<lists.length;x++){
            lists[x] = new ArrayList<>();
        }
        int rowNum = 0;
        while (i<s.length()){
            lists[rowNum].add(s.charAt(i));
            i++;
            if(topToBottom)
                rowNum++;
            else
                rowNum--;
            if(topToBottom && rowNum>=numRows) {
                topToBottom = false;
                rowNum = rowNum-2;
            }
            else if(!topToBottom && rowNum==0) {
                topToBottom = true;
            }

        }

        for(List<Character> list: lists){
            for(Character c: list){
                str.append(c);
            }
        }
        return str.toString();
    }

    public String forTwoRows(String s){
        StringBuilder oddStr = new StringBuilder();
        StringBuilder evenStr = new StringBuilder();
        for(int even = 0; even<s.length();even=even+2){
            evenStr.append(s.charAt(even));
        }
        for(int odd=1;odd<s.length();odd=odd+2){
            oddStr.append(s.charAt(odd));
        }
        return evenStr.toString()+oddStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("ABCD", 2));
    }
}
