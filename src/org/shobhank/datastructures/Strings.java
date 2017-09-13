/**
*@author
*shsharma
*/
package org.shobhank.datastructures;

import java.util.Stack;
import java.util.*;
import java.util.Arrays;

public class Strings {

    public static void main(String[] args) {
//        System.out.println(reverseInPlace("Hello! How are you"));
//        runLengthEncoding("abbbbddddcccdddff");
//        String s = "a";
//        System.out.println(reverseString(s.toCharArray(),0,s.length()-1));
//        String s = "aassseerrrtttt";
//        System.out.println(Strings.removeDuplicates(s));
//        System.out.println(Strings.removeDupWithOrder("crazayforcyode"));
//        System.out.println(Strings.isAnagram("ab".toCharArray(), "ba".toCharArray()));
//          System.out.println(Strings.isAnagramLinear("orchemtra".toCharArray(), "carthorse".toCharArray()));
//          System.out.println(Strings.removeMask("crazy foore code", "cod"));
//        Strings.longestSSNonRepeat("abcdaefghiajkl");
//        System.out.println(Strings.removePairs("RGBBGBGR"));
//        System.out.println(Strings.moveSpacesToFront("move a space to the front"));
//        String strs[] = {"bat", "code", "cat", "tab", "cab", "crazy", "act","tac"};
//        Strings.anagrams(strs, "act");
//        System.out.println(Strings.isRotated("forcodcrazy", "crazyforcode"));
//        System.out.println(Strings.spaceEncode(" crazy for  a coding exercise "));
//        System.out.println(Strings.isAnaPalindrome("abaabbb"));
//        System.out.println(checkIfStringIsRotatedByTwoPlaces("amazon","azonam"));
//
//        String input = "aaa bb cc ddddd ee ffff ggg kkk";
//        int colwidth = 10;
//        displayWrap(input, colwidth);
//        System.out.println(decode("3[a2[b2[m]]z]"));
        System.out.println(LookAndSay("11",2));
    }

    static String LookAndSay(String start, int n) {
        if(n==1)
            return lookAndSayUtil(start);
        else
            return LookAndSay(lookAndSayUtil(start),n-1);
    }

    static String lookAndSayUtil(String num){
        String out = "";
        int i = 0;
        while(i<num.length()){
            char key = num.charAt(i);
            int count = 1;
            i++;
            while(i<num.length() && key == num.charAt(i)){
                count++;
                i++;
            }
            out = out + (count + "" + key + "");
        }
        return out;
    }

    public static boolean isPalindromeAnagram(String s){
        int a[] = new int[256];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)]++;
        }
        boolean flag = false;
        for(int i=0;i<a.length;i++){
            if(a[i]%2!=0){
                if(flag)
                    return false;
                else
                    flag = true;
            }
        }
        return true;
    }

    public boolean isOneEdit(String str1, String str2){
        String small = str1.length() <= str2.length() ? str1 : str2;
        String big = str1.length() <= str2.length() ? str2 : str1;
        int operations = 0;
        if(big.length()-small.length()>1)
            return false;
        else if(big.length()==small.length()){
            for(int i=0;i<big.length();i++){
                if(big.charAt(i)!=small.charAt(i))
                    operations++;
            }
            return operations<=1;
        }else{
            int i=0;
            while(i<small.length()){
                if(small.charAt(i)!=big.charAt(i+operations)){
                    operations++;
                    if(operations>1)
                        return false;
                }else
                    i++;
            }
            return true;
        }
    }

    public static int editDistance(String s1, String s2){
        if(s1.isEmpty() && s2.isEmpty())
            return 0;
        else if(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.charAt(0)!=s2.charAt(0))
                return 1 + Math.min(editDistance(s1.substring(1), s2.substring(1)),
                        Math.min(editDistance(s1.substring(1), s2),editDistance(s1, s2.substring(1))));
            return editDistance(s1.substring(1),s2.substring(1));
        }else
            return 1;
    }

    public static boolean isVersionGreaterThanOrEqualTo10Dot3(String version){
        String v1Split[] = version.split("\\.");
        String v2Split[] = "10.3".split("\\.");

        int length = v1Split.length>v2Split.length?v1Split.length:v2Split.length;
        for(int i=0;i<length;i++){
            Integer v1Curr = i < v1Split.length?Integer.parseInt(v1Split[i]):0;
            Integer v2Curr = i < v2Split.length?Integer.parseInt(v2Split[i]):0;
            int compare = v1Curr.compareTo(v2Curr);
            if(compare!=0)
                return compare==-1?false:true;
        }
        return true;
    }

    /**
     * 3[a]2[ab]10[c]
     * @param
     * @param
     * @return
     * idea is to start from the end and use stack
     */
    public static String decode(String input){
        String out = "";
        Stack<String> s = new java.util.Stack<>();
        int i= input.length()-1;
        while (i>=0){
            if(input.charAt(i) == ']'){
                s.push("]");
            }else if(input.charAt(i) == '['){
                String temp = "";
                String toPush = "";
                i--;
                int num = Integer.parseInt(input.charAt(i)+"");
                while (!s.isEmpty()){
                    String c = s.pop();
                    if(c.equals("]"))
                        break;
                    temp = temp + c;
                }
                for(int count=1;count<=num;count++){
                    toPush = toPush + temp;
                }
                s.push(toPush);
            }else if(input.charAt(i) >='a' && input.charAt(i)<='z') {
                s.push(input.charAt(i) + "");
            }
            i--;
        }
        return s.pop();
    }

    public static Character firstNonRepeating(String s){
        Map<Character, Boolean> repeatMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(repeatMap.containsKey(c)){
                repeatMap.put(c,true);
            }else
                repeatMap.put(c,false);
        }
        for(int i=0;i<s.length();i++){
            if(!repeatMap.get(s.charAt(i)))
                return s.charAt(i);
        }
        return null;
    }
    
    public static String reverseInPlace(String s){
        char[] rev = reverseString(s.toCharArray(),0,s.length()-1);
        int i = 0,j=0;
        for(j=0;j<rev.length;j++){
            if(rev[j]==' '){
            rev = reverseString(rev,i,j-1); 
            i = j+1;
            }
        }
        rev = reverseString(rev,i,j-1);
        return String.valueOf(rev);
    }

    public static void printDuplicateCharacters(String s){
        Map<Character, Boolean> repeatMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(repeatMap.containsKey(c)){
                repeatMap.put(c,true);
            }else
                repeatMap.put(c,false);
        }
        Iterator<Character> iter = repeatMap.keySet().iterator();
        while(iter.hasNext()){
            Character c = iter.next();
            if(repeatMap.get(c))
                System.out.println(c);
        }
    }
    
    public static char[] reverseString(char s[],int beg,int end){
        while(beg<end){
            char temp = s[beg];
            s[beg] = s[end];
            s[end] = temp;
            beg++;
            end--;
        }
        return s;
    }

    public static void runLengthEncoding(String s){
        int i = 0;
        while(i<s.length()){
            int count = 0;
            char key = s.charAt(i);
            int j = i+1;
            while(i<s.length() && s.charAt(i)==key){
                count++;
                i++;
            }
            s = s.substring(0,j) + count + (i<s.length()?s.substring(i):"");
            i = j+1;
        }
        System.out.println(s);
    }

    public static String removeDuplicates(String s){
        char in[] = s.toCharArray();
        Arrays.sort(in);
        int i = 0;
        int j = 1;
        while(j<s.length()){
            if(in[i]!=in[j]){
                i++;
                in[i]=in[j];
            }
            j++;
        }
        return String.valueOf(in).substring(0,i+1);
    }
//crazyforcode
    public static String removeDupWithOrder(String s){
        boolean v[] = new boolean[256];
        int i = 0;
        while(i<s.length()){
            if(v[s.charAt(i)]){
                s = s.substring(0, i) + s.substring(i+1);
            }else{
                v[s.charAt(i)] = true;
                i++;
            }
        }
        return s;
    }

    public static boolean isAnagram(char s[],char t[]){
        if(s.length!=t.length)
            return false;
        Arrays.sort(s);
        Arrays.sort(t);
        int i = 0;
        while(i<s.length){
            if(s[i]!=t[i])
                return false;
            i++;
        }
        return true;
    }

    public static boolean isAnagramLinear(char s[],char t[]){
        int p[] = new int[256];
        for(int i=0;i<s.length;i++){
            p[s[i]]++;
            p[t[i]]--;
        }
        for(int i=0;i<p.length;i++){
            if(p[i]!=0)
                return false;
        }
        return true;
    }

    public static String removeMask(String s,String m){
        for(int i=0;i<m.length();i++){
            int ix = s.indexOf(m.charAt(i));
            while(ix!=-1){
                s= s.substring(0,ix) + s.substring(ix+1, s.length());
                ix = s.indexOf(m.charAt(i));
            }
        }
        return s;
    }

    public static void longestSSNonRepeat(String in){
        boolean v[] = new boolean[256];
        for(int i=0;i<v.length;i++)
            v[i] = false;
        int meh = 0,msf =0,s=-1,e=-1;
        for(int i=0;i<in.length();i++){
            if(v[in.charAt(i)]){
                meh = 1;
                s = i;
            }else{
                meh++;
            }
            if(msf<meh){
                msf = meh;
                e = i;
            }
            v[in.charAt(i)] = true;
        }
        System.out.println("Max Sub Sequence length" + msf + 
                " start:" + (s-msf) + " end:" + e);
    }

    public static String removePairs(String s){
        int j = 0 ;
        int i = 1 ;
        while(i<s.length()){
            while(i<s.length() && j>=0 && s.charAt(j)==s.charAt(i)){
                i++;
                j--;
            }
            j++;
            s = s.substring(0, j) + s.substring(i, s.length());
            i = j+1;
        }
        return s;
    }

    public static String moveSpacesToFront(String in){
        int i = 0;
        while(i<in.length()){
        if(in.charAt(i) == ' '){
        in = in.substring(0, i) + in.substring(i+1, in.length());
        in = '_' + in;
        }
        i++;
        }
        return in;
    }
    
    public static void anagrams(String strs[],String key){
        Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(int i=0;i<strs.length;i++)
        {
            String word = strs[i];
            String sortedWord = sortString(word); // this is a key
            ArrayList<String> anagrams = map.get( sortedWord );  //this is a value

            if( anagrams == null ) anagrams = new ArrayList<String>();

            anagrams.add(word);
            map.put(sortedWord, anagrams);
        }
        System.out.println(map.get(sortString(key)));   
    }
    
    private static String sortString( String w )
    {
        char[] ch = w.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public static boolean isRotated(String s,String t){
        s = s + s;
        return s.contains(t);
    }

    public static String spaceEncode(String str){
        int i = 0;
        while(i<str.length()){
            if(str.charAt(i)==' '){
                str = str.substring(0,i) + "%20" +str.substring(i+1, str.length());
                i = i+3;
            }else{
                i++;
            }       
        }
        return str;
    }
    
    public static boolean isAnaPalindrome(String str){
        int v[] = new int[256];
        for(int i=0;i<str.length();i++){
           v[str.charAt(i)]++; 
        }
        int flag = 0;
        for(int i = 0;i<v.length;i++){
            if(v[i]%2!=0)
                flag++;
        }
        if(flag>1)
            return false;
        else
            return true;
    }

    public static int checkIfStringIsRotatedByTwoPlaces(String a, String b){
        int k = 2;
        // Check if right rotated
        String s1 = a.substring(0,k);
        String s2 = a.substring(k);
        if((s1+b+s2).equals(a+a))
            return 1;

        s1 = a.substring(0,a.length()-k);
        s2 = a.substring(a.length()-k);
        if((s1+b+s2).equals(a+a))
            return 1;
        return 0;
    }

    public static void printArray(int a[],char in[]){
        for(int i=0;i<a.length;i++){
            if(a[i]==1)
                System.out.print(in[i]);
        }
        System.out.println();
    }

    public static void combinations(int a[],int k,int n,char in[]){
        if(k==n){
            a[k] = 1;
            printArray(a,in);
            a[k] = 0;
            printArray(a,in);
        }else{
            a[k] = 0;
            combinations(a,k+1,n,in);
            a[k] = 1;
            combinations(a,k+1,n,in);
        }
    }

    static public void commonCharracters(String[] strings) {
        /*
        Another way could be by sorting each string and then doing merge
         */
        int[] alphabets = new int[26];
        for (String string : strings) {
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (!string.substring(0, i).contains(c + "")) {
                    alphabets[c - 97]++;
                    // if the character is not present in the substring then
                    // increment else
                    // move on
                }
            }
            System.out.println();
        }
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == strings.length) {
                System.out.println((char) (i + 97));
            }
        }
    }

    public static void toHumanReadable(int a){
        int factor = 1000;
        int pfx = 0;
        int num = a;
        while(true){
            num = num/factor;
            if(num == 0)
                break;
            pfx++;
        }
        switch(pfx){
            case 0:
                System.out.println(a+"B");
                break;
            case 1:
                System.out.println(a/(1000.0) + "KB");
                break;
            case 2:
                System.out.println(a/(1000.0*1000.0) + "MB");
                break;
            case 3:
                System.out.println(a/(1000.0*1000.0*1000.0) + "GB");
                break;
            default:
                System.out.println("Out of range");
        }
    }

    public static void maxIntValue(){
        int i = -1;
        int count=0;
        while(i!=0){
            i = i >>> 1;
            System.out.println(i);
            count++;
        }
        System.out.println(count);
    }

    public static void permutate(char input[], int n, int m) {
        if (n == m) {
            printArray(input);
        } else {
            for (int i = n; i <= m; i++) {
                swap(i, n, input);
                permutate(input, n + 1, m);
                swap(i, n, input);
            }
        }
    }

    public static void printArray(char in[]) {
        for (int i = 0; i < in.length; i++)
            System.out.print(in[i]);
        System.out.println();
    }

    public static void swap(int i, int n, char input[]) {
        char temp;
        temp = input[i];
        input[i] = input[n];
        input[n] = temp;
    }

    public static void displayWrap(String str, int width){
        for(int i=0;i<str.length();i++){
            if(i+width >=str.length()-1){
                display(str, i, str.length()-1);
                break;
            }else if(i+width<str.length() && str.charAt(i+width)== ' '){
                display(str, i, i+width);
                i = i+width+1;
            }else if(i+width<str.length() && str.charAt(i+width)!=' '){
                int j = i+width;
                while(j>=0 && str.charAt(j)!=' '){
                    j--;
                }
                if(j>=0){
                    display(str,i,j);
                    i = j;
                }
            }
        }
    }

    public static void display(String str, int s, int e){
        for(int i=s;i<=e;i++)
            System.out.print(str.charAt(i));
        System.out.println();
    }
}


