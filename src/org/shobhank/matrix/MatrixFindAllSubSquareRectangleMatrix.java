package org.shobhank.matrix;

/**
 * Iterate through matrix and get all subsquare and subrectangle matrix and print their sum
 */
public class MatrixFindAllSubSquareRectangleMatrix {

	// Given a square matrix of nXn find sum of all matrix kXk
	public void printSumOfAllKSquareMatrix(int a[][], int k, int n){
		for(int r=0;r<n-k+1;r++){
			for(int c=0;c<n-k+1;c++){
				int sum = 0;
				for(int i=r;i<r+k;i++){
					for(int j=c;j<c+k;j++){
						sum = sum + a[i][j];
					}
				}
				System.out.print(sum + "\t");
			}
			System.out.println();
		}
	}

	public void printSumOfAllSquareMatrix(int input[][]){
		
		for(int len = 1; len <= input.length; len++){
			for(int i=0; i < input.length - len + 1; i++){
				for(int j=0; j < input[i].length - len + 1; j++){
					int sum = 0;
					for(int k=i;k < i+len; k++){
						for(int m = j; m < j+len; m++){
							sum += input[k][m];
						}
					}
					System.out.println("Start " + i + " " + j + " End " + len + " sum " + sum);
				}
			}
		}
	}
	
	public void printSumOfAllRectangleMatrix(int input[][]){
		for(int rlen = 1 ; rlen <= input.length; rlen++){
			for(int clen = 1; clen <= input[0].length; clen++){
				for(int i=0; i < input.length - rlen + 1; i++){
					for(int j=0; j < input[i].length - clen + 1; j++){
						int sum = 0;
						for(int k=i;k < i+rlen; k++){
							for(int m = j; m < j+clen; m++){
								sum += input[k][m];
							}
						}
						System.out.println("Start " + i + " " + j + " End " + (i + rlen-1) + " "  + (j + clen-1) + " sum " + sum);
					}
				}
			}
		}
	}
	public static void main(String args[]){
		int input[][] = { {1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
		};
		
		MatrixFindAllSubSquareRectangleMatrix mal = new MatrixFindAllSubSquareRectangleMatrix();
		mal.printSumOfAllSquareMatrix(input);
//		mal.printSumOfAllKSquareMatrix(input,2,3);
	}
}
