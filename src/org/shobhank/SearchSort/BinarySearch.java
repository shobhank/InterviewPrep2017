/**
 * @author shsharma
 */
package org.shobhank.SearchSort;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String as[]) {
//        int a[] = {10, 3, 40, 20, 50, 80, 70};
//        System.out.println(BinarySearch.almostSorted(a, 20, 0, a.length-1));
        int stalls[] = {0, 8, 19, 25, 30, 45, 80, 95, 97, 100};
        System.out.println(aggressiveCows(stalls, 5));
    }

    static int search(int a[], int key, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == key)
                return mid;
            else if (key < a[mid])
                return search(a, key, l, mid - 1);
            else
                return search(a, key, mid + 1, r);
        } else
            return -1;
    }

    static int almostSorted(int a[], int key, int p, int q) {
        //almost sorted except one of i and i+1 or i-1 values exchanged
        if (p <= q) {
            int mid = (p + q) / 2;
            if (a[mid] == key) return mid;
            if (mid < q && a[mid + 1] == key) return mid + 1;
            if (mid > p && a[mid - 1] == key) return mid - 1;
            if (key > a[mid]) return almostSorted(a, key, mid + 1, q);
            if (key < a[mid]) return almostSorted(a, key, p, mid - 1);
        }
        return -1;
    }

    /**
     * Given an array representing stalls stalls[]
     * Number of cows C
     * We need to find how far apart we can put the cows
     * Idea is to sort stalls and then do binary search to find if it is possible to put cows at that distance
     * or not
     * @return
     */
    static int aggressiveCows(int stalls[], int C) {
        int s = stalls[0];
        int e = stalls[stalls.length - 1] - stalls[0];
        int maxDistance = Integer.MIN_VALUE;
        Arrays.sort(stalls);
        while (s+1 < e) {
            int m = (s + e) / 2;
            if (isPossible(stalls, C, m)) {
                s = m;
                if (m > maxDistance)
                    maxDistance = m;
            } else {
                e = m;
            }
        }
        return maxDistance;
    }

    static boolean isPossible(int stalls[], int C, int distance) {
        int lastPlacement = stalls[0];
        int cowPlaced = 1;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlacement > distance) {
                cowPlaced++;
                lastPlacement = stalls[i];
            }
            if (cowPlaced == C)
                return true;
        }
        return false;
    }
}
