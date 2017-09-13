package org.shobhank.miscellaneous;

import java.util.Arrays;
import java.util.Comparator;

/**
 * http://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 */
public class RearrangeNumberInArrayToFormLargestNumber {

	public void rearrange(Integer arr[]){
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = String.valueOf(o1);
				String s2 = String.valueOf(o2);
				return (Integer.parseInt(s1+s2))>(Integer.parseInt(s2+s1))?-1:1;
			}
		});
	}
	
	public static void main(String args[]){
		RearrangeNumberInArrayToFormLargestNumber rni = new RearrangeNumberInArrayToFormLargestNumber();
		Integer arr[] = {54,546,548,60};
		rni.rearrange(arr);
		for(int a : arr){
			System.out.print(a);
		}
	}
}

