package org.shobhank.miscellaneous;

public class StringPermutationRotation {

	private void swap(char arr[],int i, int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] =temp;
	}
	
	private void printArray(char str[]){
		for(int i=0; i< str.length; i++){
			System.out.print(str[i]);
		}
		System.out.print("\n");
	}

	public void permute(char str[], int k, int n){
		if(k==n){
			printArray(str);
		}else{
			for(int i=k;i<=n;i++){
				swap(str, i, k);
				permute(str, k+1,n);
				swap(str, i, k);
			}
		}
	}
	
	public static void main(String args[]){
		String str = "ABC";
		StringPermutationRotation sp = new StringPermutationRotation();
		sp.permute(str.toCharArray(),0,str.length()-1);
	}
}
