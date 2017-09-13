package org.shobhank.dynamicprogramming;

/**
 * @author shsharma
 */

public class MazeTracking {

    public static void main(String[] args) {
        int maze[][] = { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 1, 1, 1, 0 },
                { 1, 0, 1, 1 } };
        int soln[][] = new int[4][4];
        display(maze);
        solve(maze, 0, 0, soln);
        System.out.println();
        display(soln);
    }

    static void display(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static boolean solve(int maze[][], int x, int y, int soln[][]) {

        if (x == maze.length - 1 && y == maze.length - 1) {
            soln[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y) == true) {
            soln[x][y] = 1;
            if (solve(maze, x + 1, y, soln) == true)
                return true;
            if (solve(maze, x, y + 1, soln) == true)
                return true;
            soln[x][y] = 0;
            return false;
        }
        return false;
    }

    static boolean isSafe(int maze[][], int x, int y) {
        if ((x >= 0 && x < maze.length) && (y >= 0 && y < maze.length)
                && (maze[x][y] == 1))
            return true;
        else
            return false;
    }
}
