package org.shobhank.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shobhanksharma on 4/23/17.
 */
public class MatrixDemo {


    public static int countIslands(int a[][]){
        int count = 0;
        boolean visited[][] = new boolean[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if(visited[i][j] || a[i][j]==0)
                    continue;
                else{
                    count++;
                    flood(a, i, j, visited);
                }
            }
        }
        return count;
    }

    public static void flood(int a[][], int i, int j, boolean[][] visited){
        if(i<0 || i>=a.length || j<0 || j>=a[0].length)
            return;
        if(a[i][j]==0 || visited[i][j])
            return;
        visited[i][j] = true;
        flood(a,i+1,j,visited);
        flood(a,i,j+1,visited);
        flood(a, i-1, j, visited);
        flood(a, i, j-1, visited);
    }

    public static int count(int a[][]){
        int count = 0;
        int i=0,j=a.length-1;
        while(i<a.length && j>=0 ){
            if(a[i][j] < 0) {
                count = count + j+1;
                i = i+1;
            }else{
                j = j-1;
            }
        }
        return count;
    }

    public static void printAllPaths(int in[][], int x, int y, int path[], int curr){
        if(x==in.length-1 && y==in[0].length-1) {
            path[curr] = in[x][y];
            printPath(path, curr);
        }else if(x>=in.length || y>=in[0].length){
            return;
        }
        else{
            path[curr] = in[x][y];
            printAllPaths(in,x+1,y,path, curr+1);
            printAllPaths(in, x, y+1, path, curr+1);
        }
    }

    public static void printPath(int path[], int pathLen){
        for(int i=0;i<=pathLen;i++){
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }


    public static int[][] matrixMultiplication(int a[][], int b[][]){
        if(a[0].length!=b.length)
            return null;
        int out[][] = new int[a.length][b[0].length];
        for(int i=0;i<out.length;i++){
            for(int j=0;j<out[0].length;j++){
                for(int k=0;k<a[0].length;k++){
                    out[i][j] = out[i][j] + a[i][k]*b[k][j];
                }
            }
        }
        return out;
    }

    public static void  turnImageBy90(int [][]mat){

        int length = mat.length-1;
        int layer=0;
        while(layer < mat.length/2){

            for(int i=layer; i < length-layer; i++){
                int temp = mat[layer][i];
                mat[layer][i] = mat[length-i][layer];
                mat[length-i][layer] = mat[length-layer][length-i];
                mat[length-layer][length-i] = mat[i][length-layer];
                mat[i][length-layer] = temp;

            }
            layer++;
        }
    }

    private void print(int arr[][]){
        for(int i=0; i < arr.length; i++){
            for(int layer=0; layer < arr.length; layer++){
                System.out.print(arr[i][layer] + " ");
            }
            System.out.print("\n");
        }
    }

    public void fillWith1s(int input[][]){
        boolean row[] = new boolean[input.length];
        boolean col[] = new boolean[input[0].length];

        // Find which rows and cols have 1s
        for(int i=0; i < input.length; i++){
            for(int j=0; j < input[i].length; j++){
                if(input[i][j] == 1){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }


        for(int i=0; i < input.length; i++){
            for(int j=0; j < input[i].length; j++){
                if(row[i] || col[j]){
                    input[i][j] = 1;
                }
            }
        }
    }

    public static void spiralTraversal(int a[][]){
        int tR = 0, bR = a.length-1, lC = 0, rC = a[0].length-1;
        while(tR<bR || lC<rC){
            for(int i=lC;i<=rC;i++)
                System.out.print(a[tR][i] + ",");
            tR++;

            for(int i=tR;i<=bR;i++)
                System.out.print(a[i][rC] + ",");
            rC--;

            for(int i=rC;i>=lC;i--)
                System.out.print(a[bR][i] + ",");
            bR--;

            for(int i=bR;i>=tR;i--)
                System.out.print(a[i][lC] + ",");
            lC++;
        }
    }

    /**
     *
     *
     Input:
     {0, 1, 0, 0, 1}
     {1, 0, 1, 1, 0}
     {0, 1, 0, 0, 1}
     {1, 1, 1, 0, 0}
     Output:
     0 1 0 0 1
     1 0 1 1 0
     1 1 1 0 0

     Idea is to convert each row to its binary and store it in
     a set. Next row iteration if it is present in the set then
     dont print it else, print it
     */
    public static void printNonRepeat(int a[][]){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
            String curr = "";
            for(int j=0;j<a[0].length;j++){
                curr = curr + a[i][j];
            }
            int currInt = toBinary(curr);
            if(set.contains(currInt))
                continue;
            else
                print(curr);
            set.add(currInt);
        }
    }

    public static void print(String in){
        for(int i=0;i<in.length();i++){
            System.out.print(in.charAt(i) + ",");
        }
        System.out.println();
    }

    public static int toBinary(String in){
        int i=in.length()-1;
        int out = 0;
        int factor = 1;
        while(i>=0){
            out = out + (in.charAt(i)-'0')*factor;
            factor = factor*2;
            i--;
        }
        return out;
    }

    /**
     * Create matrix of the form O-X in spiral order
     *
     X	X	X	X	X
     X	O	O	O	X
     X	O	X	O	X
     X	O	O	O	X
     X	X	X	X	X
     * @param a
     */

    public static void createMatrix(char a[][]) {
        int tR = 0, bR = a.length - 1, lC = 0, rC = a[0].length - 1;
        int mark = 1;
        while (tR <= bR && lC <= rC) {
            for (int i = lC; i <= rC; i++)
                a[tR][i] = mark==1?'X':'O';
            tR++;

            for (int i = tR; i <= bR; i++)
                a[i][rC] = mark==1?'X':'O';
            rC--;

            for (int i = rC; i >= lC; i--)
                a[bR][i] = mark==1?'X':'O';
            bR--;

            for (int i = bR; i >= tR; i--)
                a[i][lC] = mark==1?'X':'O';
            lC++;

            mark = mark ^ 1;
        }
    }

    public void printMatrixDiagonalOrder(int [][]a){
        // Print row down
        for(int r=0;r<a.length;r++){
            int i=r, j=0;
            while(i>=0 && j<a[0].length){
                System.out.print(a[i][j] + "\t");
                i--;
                j++;
            }
            System.out.println();
        }

        // Print col left to right
        for(int c = 1;c<a[0].length;c++){
            int i=a.length-1,j=c;
            while(i>=0 && j<a[0].length){
                System.out.print(a[i][j] + "\t");
                i--;
                j++;
            }
            System.out.println();
        }
    }

    public static void display(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] reshape(int a[][], int r, int c){
        int out[][] = new int[r][c];
        int R = a.length,C = a[0].length;
        if(r*c != R*C)
            return a;
        int count = 1;
        int I = 0, J = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                out[i][j] = a[I][J];
                if(count%C==0){
                    I++;
                    J=0;
                }else {
                    J++;
                }
                count++;
            }
        }
        return out;
    }

    public static void searchInRowColSortedMatrix(int a[][], int x){
        int i = 0, j = a.length-1;
        while(i<a.length && j>=0){
            if(a[i][j]==x) {
                System.out.println("Found at [" + i + "," + j + "]");
                break;
            }
            else if(a[i][j]<x)
                i++;
            else
                j--;
        }
    }

    /*
    Idea is to copy each column and find kadanes max and then copy next column and find kadanes and so on.
    if
     */
    public static int maxSumSubrectangle(int in[][]){
        int max = Integer.MIN_VALUE;
        int L = 0, R = 0;
        int leftMax = 0, rightMax = 0, topMax = 0, bottomMax = 0;
        int row[] = new int[in.length];
        while(L<in[0].length){
            for(R = L;R<in[0].length;R++){
                for(int i=0;i<in.length;i++) {
                    row[i] = row[i] + in[i][R];
                }
                Kadane k = kadanes(row, 0, in.length-1);
                if(k.max>max){
                    max = k.max;
                    leftMax = L;
                    rightMax = R;
                    topMax = k.s;
                    bottomMax = k.e;
                }
            }
            L++;
            row = new int[in.length];
        }

        System.out.println("Max sum rectangle is left=" + leftMax +
        " right=" + rightMax +" top=" + topMax + " bottom=" + bottomMax);
        return max;
    }

    static class Kadane{
        int max,s,e;
    }

    public static Kadane kadanes(int a[], int s, int e){
        Kadane k = new Kadane();
        k.max = Integer.MIN_VALUE;
        k.s = -1;
        k.e = -1;
        int currentStart = 0;
        int meh = 0;
        for(int i=s;i<=e;i++){
            if(meh + a[i] < 0) {
                meh = 0;
                currentStart = i+1;
            }
            else {
                meh = meh + a[i];
            }
            if(k.max < meh){
                k.s = currentStart;
                k.max = meh;
                k.e = i;
            }
        }
        return k;
    }

    public static void main(String args[]){
        int in[][] = { {2,1,-3,-4,5},
                       {0,6,3,4,1},
                       {2,-2,-1,4,-5},
                       {-3,3,1,0,3}};
        System.out.println(maxSumSubrectangle(in));
//        int a[][] = {{0,2,7,8},{1,6,9,10},{3,8,12,15}};
//        searchInRowColSortedMatrix(a, 3);
//        int in[][] = {{1,2},{3,4}};
//        display(reshape(in,4,1));
//        int[][] sea = new int[][] {
//                new int[] {0,  1,  0,  1,  0},
//                new int[] {0,  0,  1,  1,  1},
//                new int[] {1,  0,  0,  1,  0},
//                new int[] {0,  1,  1,  0,  0},
//                new int[] {1,  0,  1,  0,  1} };
//        System.out.println(countIslands(sea));
//
//        int a[][] = {{-3,-2,-1,1},
//                {-2,-1,3,4},
//                {-1,5,7,8}};
//        System.out.println(count(a));
//
//        int in[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        printAllPaths(in, 0,0, new int[100], 0);

//        int a[][] = {{1,2,3,4},
//                     {5,6,7,8},
//                     {9,10,11,12},
//                     {13,14,15,16}};
//        display(a);
//        turnImageBy90(a);
//        System.out.println();
//        display(a);
//        int a[][] = {{1,2,3},{5,6,7},{9,10,11},{4,8,12}};
//        spiralTraversal(a);
    }
}
