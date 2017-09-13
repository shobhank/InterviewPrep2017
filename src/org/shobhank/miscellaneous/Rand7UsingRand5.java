package org.shobhank.miscellaneous;

public class Rand7UsingRand5 {

	public int rand7(){
		int n = 5*rand5() + rand5() - 5; // we try to generate multiple of 7 eg. 21. It generates between 1 and 25
		if(n<22)
			return n%7 + 1;
		return rand7();
	}
	
	private int rand5(){
		return (int)(Math.ceil(Math.random()*5));
	}
	
	public static void main(String args[]){
		Rand7UsingRand5 rr = new Rand7UsingRand5();
		for(int i=0; i < 10; i++){
			System.out.print(rr.rand7()+ " ");
		}
	}
}
