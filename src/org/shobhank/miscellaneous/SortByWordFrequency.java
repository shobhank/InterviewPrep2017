package org.shobhank.miscellaneous;

import java.util.*;

/**
 * Created by shobhanksharma on 3/19/17.
 */
public class SortByWordFrequency {
    public static void main(String as[]){
        String in[] = {"Apple","The","The","Force","Apple","Cat","Box","Ball","Cat","The","The"};
        FrequencyCounter fc = new FrequencyCounter();
        fc.createCountMap(in);
        System.out.println(fc.getWordsInOrderOfFrequency());
    }
}

class FrequencyCounter implements Comparator<String> {
    public Map<String, Integer> wordCount;

    public void createCountMap(String a[]){
        wordCount = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(wordCount.containsKey(a[i])){
                int count = wordCount.get(a[i]);
                wordCount.put(a[i],count+1);
            }else
                wordCount.put(a[i],1);
        }
    }

    @Override
    public int compare(String o1, String o2) {
        int diff = getCount(o2) - getCount(o1);
        if(diff!=0)
            return diff;
        return o1.compareTo(o2);
    }

    public List<String> getWordsInOrderOfFrequency(){
        List<String> words = new ArrayList<>(wordCount.keySet());
        Collections.sort(words, this);
        return words;
    }

    public int getCount(String s){
        if(wordCount.containsKey(s))
            return wordCount.get(s);
        return 0;
    }
}
