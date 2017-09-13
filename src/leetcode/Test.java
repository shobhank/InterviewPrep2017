// Copyright Karat, Inc. 2016-2017 - Please do not distribute or republish.

import java.io.*;
import java.util.*;

/*
 * Imagine we have an image. We’ll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of the rectangle -- either top-left and bottom-right; or top-left, width, and height.
 */

class Solution1 {

    // Sample input
    static int[][] image = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1, 1},
            {1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
    };


    // Your function here!!!!!
    public static Box zeroRectangle(int a[][],boolean visited[][]){
        Pair topLeft = null;
        boolean found = false;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j] == 0){
                    topLeft = new Pair(i,j);
                    found = true;
                    break;
                }
                if(found)
                    break;
            }
        }

        Pair bottomRight = getBottomRight(a,topLeft,visited);
        display(visited, topLeft.x, topLeft.y);
        System.out.println("---");
        return new Box(topLeft,bottomRight);
    }

    public static List<Box> zeroRectangles(int a[][], boolean visited[][]){
        List<Box> boxes = new ArrayList<>();
        Pair topLeft;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==0 && !visited[i][j]){
                    topLeft = new Pair(i,j);
                    boxes.add(zeroRectangle(a,visited));
                    visited[i][j] = true;
                }
            }
        }
        return boxes;
    }

    private static Pair getBottomRight(int a[][], Pair topLeft,boolean visited[][]){
        Pair topRight = null;
        int row = -1;
        int col = -1;
        int x = topLeft.x;
        int y = topLeft.y;
        boolean found = false;
        for(int i=x;i<a.length;i++){
            for(int j=y;j<a[0].length;j++){
                if(a[i][j]==0 && (
                        (i+1>=a.length || a[i+1][j]==1))
                        &&
                        (j+1>=a[0].length || a[i][j+1]==1)){
                    row = i;
                    col = j;
                    found = true;
                    break;
                }
                if(found)
                    break;
                if(a[i][j]==0)
                    visited[i][j] = true;
            }
        }
        topRight = new Pair(row,col);
        return topRight;
    }

    public static void display(boolean a[][], int x, int y){
        for(int i=x;i<a.length;i++){
            for(int j=y;j<a[0].length;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        display(visited,0,0);
        List<Box> boxes = zeroRectangles(image,visited);
        System.out.println(boxes.size());
        // System.out.println(out.topLeft + " " + out.bottomRight);
    }
}

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "X=" + x +",Y="+y;
    }
}

class Box{
    Pair topLeft;
    Pair bottomRight;
    Box(Pair topLeft, Pair bottomRight){
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public String toString(){
        return "Top X=" + topLeft.x +",Y="+topLeft.y +
                "\tBottom Right X=" + bottomRight.x + ",Y=" + bottomRight.y + "\n" ;
    }

}


