package org.shobhank.miscellaneous;

import java.util.Arrays;
import java.util.Comparator;

/**
 http://www.geeksforgeeks.org/suffix-array-set-1-introduction/
 */
public class SuffixArray {

    public int[] createSuffixArray(String str){
        Suffix[] suffices = new Suffix[str.length()];
        for(int i=0;i<str.length();i++){
            String curr = str.substring(i);
            Suffix suffix = new Suffix(curr, i);
            suffices[i] = suffix;
        }
        Arrays.sort(suffices, new Suffix());

        int i=0;
        int result[] = new int[str.length()];
        for(Suffix suffix:suffices){
            result[i] = suffix.getIndex();i++;
        }
        return result;
    }

    public static void main(String args[]){
        SuffixArray suffix = new SuffixArray();
        String str = "banana";
        int result[] = suffix.createSuffixArray(str);
        display(result);
    }
    /*
    0 missisippi
    1 issisippi
    2 ssisippi
    3 sisippi
    4 isippi
    5 sippi
    6 ippi
    7 ppi
    8 pi
    9 i
    {9,6,4,1}
     */

    public static void display(int in[]){
        for(int a:in){
            System.out.print(a + "\t");
        }
    }
}

class Suffix implements Comparator<Suffix>{

    private String str;
    private int index;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Suffix(String curr, int i) {
        str = curr;
        index = i;
    }

    public Suffix() {

    }

    @Override
    public String toString() {
        return "Suffix{" +
                "str='" + str + '\'' +
                ", index=" + index +
                '}';
    }

    @Override
    public int compare(Suffix o1, Suffix o2) {
        return o1.str.compareTo(o2.str);
    }
}
