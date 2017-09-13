/**
*@author
*shsharma
*/
package org.shobhank.datastructures;

import java.util.*;
import java.util.Stack;

public class Arrays {

    public static void display(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    public static void displayPoints(int a[][]){
        for(int i=0;i<a.length;i++){
            System.out.print("("+a[i][0]+"," + a[i][1]+"),");
        }
        System.out.println();
    }

    public static int countInversion(int a[],int p, int q){
        int inversions = 0;
        if(p<q){
            int m = (p+q)/2;
            inversions+= countInversion(a,p,m);
            inversions+= countInversion(a,m+1,q);
            inversions+= mergeInversions(a,p,m,q);
        }
        return inversions;
    }

    public static int mergeInversions(int a[], int p, int q, int r){
        int helper[] = new int[r-p+1];
        int inversions =0;
        int k=0;
        int i=p,j=q+1;
        while(i<=q && j<=r){
            if(a[i]<=a[j]){
                helper[k++] = a[i++];
            }else{
                helper[k++] = a[j++];
                inversions+= (q-i+1);
            }
        }

        while(i<=q){
            helper[k++] = a[i++];
        }

        while(j<=r){
            helper[k++] = a[j++];
        }

        for(int m=p;m<=r;m++){
            a[m] = helper[m-p];
        }
        return inversions;
    }

    public static int lengthOfLongestNonRepeatingSubstring(String s) {
        int maxLength=0, currLength=0;
        Map<Character,Integer> charIndexMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character currentChar = s.charAt(i);
            Integer prevIndex = charIndexMap.get(currentChar);
            if(prevIndex==null || i-prevIndex > currLength)
                currLength++;
            else{
                maxLength = Math.max(currLength,maxLength);
                currLength = i-prevIndex;
            }
            charIndexMap.put(currentChar, i);
        }

        return Math.max(maxLength,currLength);
    }

    public static int maxProductSubarray(int a[]){
        int minEndsHere = 1;
        int maxEndsHere = 1;
        int msf = 1;
        int e=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]>0){
                // since it is positive multiplying it will make it even bigger
                maxEndsHere = maxEndsHere * a[i];
                // minEndsHre if negative then will become more negative
                minEndsHere = minEndsHere * a[i];
            }else if(a[i]==0){
                maxEndsHere = 1;
                minEndsHere = 1;
            }else{
                int temp = maxEndsHere;
                // minEndsHere if negative will make product positive
                maxEndsHere = Math.max(minEndsHere * a[i],1);
                // maxEndsHere is positive so will make minEndsHere negative
                minEndsHere = Math.min(temp*a[i],1);
            }
            if(maxEndsHere>msf){
                msf = maxEndsHere;
                e = i;
            }
        }
        return msf;
    }

    /*
    eg. 1,2,3,4,5,6,7 ; k=3 => 4,5,6,7,1,2,3

     */
    public static void rotateArrayByK(int a[], int k){
        reverse(a,0,k-1);
        reverse(a,k,a.length-1);
        reverse(a,0,a.length-1);
    }

    public static int minDistance1d(int a[]){
        java.util.Arrays.sort(a);
        int minDistance = Integer.MAX_VALUE;
        for(int i=1;i<a.length;i++){
            if(a[i]-a[i-1]<minDistance){
                minDistance= a[i] - a[i-1];
            }
        }
        return minDistance;
    }

    public static void reverse(int a[], int p, int q){
        if(p<q){
            int temp = a[p];
            a[p] = a[q];
            a[q] = temp;
            reverse(a,p+1,q-1);
        }
    }

    public static void dutchFlag(int input[]){
        int low = 0,mid=0,high = input.length-1;
        while(mid<=high){
            if(input[mid]==0){
                swap(input, low, mid);
                low++;
                mid++;
            }else if(input[mid]==1){
                mid++;
            }else if(input[mid]==2){
                swap(input, high, mid);
                high--;
            }
        }
    }

    public static void evenOddPosition(int a[]){
        List<Integer> evenList = new ArrayList<Integer>();
        List<Integer> oddList = new ArrayList<Integer>();
        List<Integer> outList = new ArrayList<Integer>();
        int evenLength=0;
        int oddLength=0;
        for(int i=0;i<a.length;i++){
            if(a[i]%2==0){
                evenList.add(a[i]);
                evenLength++;
            }else {
                oddList.add(a[i]);
                oddLength++;
            }
        }

        int minLength = Math.min(evenLength, oddLength);
        int i=0;
        for(i=0;i<minLength;i++){
            outList.add(2*i,evenList.get(i));
            outList.add(2*i+1,oddList.get(i));
        }
        while(oddLength>evenLength && i<oddLength){
            outList.add(oddList.get(i));
            i++;
        }

        while(evenLength>oddLength && i<evenLength){
            outList.add(evenList.get(i));
            i++;
        }
        System.out.println(outList);
    }

    public static int kthMin(int a[], int x, int y, int k){
        if(x<=y){
            int p = partition(a, x,y);
            if(p==k)
                return a[p];
            else if(k<p)
                return kthMin(a,x,p-1,k);
            else
                return kthMin(a,p+1,y,k);
        }
        return -1;
    }

    public static int partition(int a[],int p, int q){
        int pivot = p;
        int i=p+1,j=q;
        while(i<=j){
            while(i<=j && a[i]<a[pivot]){
                i++;
            }
            while(i<=j && a[j]>a[pivot]){
                j--;
            }
            if(i<j){
                swap(a, i, j);
            }
        }
        swap(a, pivot, j);
        return j;
    }

    public static void swap(int a[], int s, int t){
        int temp = a[s];
        a[s] = a[t];
        a[t] = temp;
    }

    public static int majorityElement(int a[]){
        int count = 1;
        int key = a[0];
        for(int i=1;i<a.length;i++){
            if(a[i] == key)
                count++;
            else{
                if(count == 0){
                    key = a[i];
                    count = 1;
                }else
                    count--;
            }
        }
        return key;
    }

    /*
    To find two oddNumberOfRep, xor all the numbers. Since the two diffeerent numbers
    will give an XOR with some different bits. Find one such bit.
    Divide the array into two parts one with that bit set and one with that bit unset
    Now we the XOR output of each part of arrays will be the required numbers
     */
    private static int oddNumberOfRep(int[] a) {
        int xor = a[0];
        for (int i = 1; i < a.length; i++) {
            xor = xor ^ a[i];
        }
        return xor;
    }

    public static int removeDuplicates(int a[]){
        int j = 0;
        for(int i=1;i<a.length;i++){
            if(a[i]!=a[j]){
                j++;
                a[j] = a[i];
            }
        }
        return j;
    }

    public static int searchCircularSorted(int a[], int key){
        int i=0,j=a.length-1;
        while(i<=j){
            int m = (i+j)/2;
            if(a[m] == key)
                return m;
            else if(a[m] > a[i]){
                // left sorted
                if(key>=a[i] && key<a[m])
                    j=m-1;
                else
                    i=m+1;
            }else if(a[m] < a[j]){
                if(key<=a[j] && key>a[m])
                    i=m+1;
                else
                    j=m-1;
            }
        }
        return -1;
    }

    public static void seggregate0s1s(int a[]){
        int l=0,h=a.length-1;
        while(l<h){
            if(a[l]==0){
                l++;
            }else if(a[l]==1){
                swap(a,l,h);
                h--;
            }
        }
    }

    public static void display(int a[],int len){
        for(int i=0;i<len;i++)
            System.out.print(a[i] + " ");
    }

    public static void shiftZeros(int a[]){
        int zero = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                swap(a,i,zero);
                zero++;
            }
        }
    }

    public static void shiftZerosWithOrder(int a[]){
        int i = 1;
        int z = 0;
        while(z<a.length && i < a.length){
            if(a[z]==0){
                while(i<a.length && a[i]==0){
                    i++;
                }
                if(i>=a.length)
                    break;
                int temp = a[z];
                a[z] = a[i];
                a[i] = temp;
            }else{
                z++;
            }
        }
    }

    public static int sortedMedian(int a[], int b[]){
        // one way would be to merge and keep counting, but this will be O(n)
        // we can do better
        // Given that the arrays are equal lengths
        return sortedMedianUtil(a,b,0,a.length-1,0,b.length-1);
    }

    public static int sortedMedianUtil(int a[], int b[], int sA, int eA, int sB, int eB){
        if(eA-sA==1 && eB-sB==1){
            return (Math.max(a[sA],b[sB]) + Math.min(a[eA],b[eB]))/2;
        }
        int m1Ix = (sA + eA)/2;
        int m2Ix = (sB + eB)/2;
        if(a[m1Ix] == b[m2Ix])
            return (a[m1Ix] + b[m2Ix])/2;
        else if(a[m1Ix] < b[m2Ix]){
            sA = m1Ix;
            eB = m2Ix;
        }else{
            sB = m2Ix;
            eA = m1Ix;
        }
        return sortedMedianUtil(a,b,sA,eA,sB,eB);
    }

    public static void sumClosestToZero(int a[]){
        java.util.Arrays.sort(a);
        int i=0,j=a.length-1;
        int min = Integer.MAX_VALUE;
        int ix1=-1,ix2=-1;
        while(i<j){
            int sum = Math.abs(a[i]+a[j]);
            if(sum<min){
                min = sum;
                ix1 = i;
                ix2 = j;
            }else if(a[i]+a[j] < 0){
                i++;
            }else if(a[i]+a[j] > 0){
                j--;
            }else{
                System.out.println("Pair having sum closest to zero = " + a[i]+ "," +a[j]);
                return;
            }
        }

        System.out.println("Pair having sum closest to zero = " + a[ix1]+ "," +a[ix2]);
    }

    public static void threeSum(int a[], int sum){
        java.util.Arrays.sort(a);
        int i = a.length-1;
        while(i>1){
            int x = 0,y = i-1;
            int sumToFind = sum-a[i];
            while (x<y){
                if(a[x]+a[y] == sumToFind){
                    System.out.println("Three sum " + a[i] + " " + a[x] + " " + a[y]);
                    return;
                }else if(a[x] + a[y] > sumToFind){
                    y--;
                }else if(a[x] + a[y] < sumToFind){
                    x++;
                }
            }
            i--;
        }
    }
    //given numbers from 1 to n, some of them repeating and including all elements between 1 and n
    public static void duplicateElements(int a[], int n){
        for(int i=0;i<a.length;i++){
            int ix = Math.abs(a[i]);
            if(a[ix]<0)
                System.out.println(ix + " is duplicate");
            else
                a[ix] = -a[ix];
        }
    }

    public static void maxSumSubsequence(int a[]){
        int meh = 0,msf = 0,s=-1,e=-1;
        for(int i=0;i<a.length;i++){
            if(meh+a[i]<0){
                meh = 0;
                s = i+1;
            }else{
                meh = meh + a[i];
            }
            if(msf<meh){
                msf = meh;
                e = i;
            }
        }
        System.out.println("Max Sum Subsequence " + msf);
        System.out.println("Start:" + s + " End:" + e);
    }

    public static void sumPair(int a[],int sum){
        int i = 0;
        int j = a.length-1;
        java.util.Arrays.sort(a);
        while(i<j){
            if(a[i]+a[j] == sum){
                System.out.println("("+a[i]+","+a[j]+")");
                i++;
                j--;
            }
            else if(a[i]+a[j] < sum)
                i++;
            else if(a[i]+a[j] > sum)
                j--;
        }
    }
    
    public static void sumPairWithoutSort(int a[],int sum){
        boolean map[] = new boolean[100]; // use set instead
        for(int i=0;i<a.length;i++){
            int diff = sum - a[i];
            if(diff > 0 && map[diff])
                System.out.println("("+a[i]+","+diff+")");
            map[a[i]] = true;
        }
    }

    public static int wordDistanceFind(String in[], String a, String b){
        int index1 = -1, index2 = -1, minDistance = Integer.MAX_VALUE;
        for(int i=0;i<in.length;i++){
            if(in[i].equals(a)){
                index1 = i;
            }else if(in[i].equals(b)){
                index2 = i;
            }
            if(index1!=-1 && index2!=-1){
                minDistance = Math.min(minDistance, Math.abs(index1-index2));
            }
        }
        return minDistance;
    }
    
    public static void spiralDisplay(int a[][],int n,int m){
        for(int i=0;i<n;i++){
            if(i%2==0){
                for(int j=0;j<m;j++){
                    System.out.print(a[i][j]+" ");
                }
            }else{
                for(int j=m-1;j>=0;j--){
                    System.out.print(a[i][j]+" ");
                }
            }
        }
    }
    
//    O(lgn)
    public static int getMissingSorted(int a[],int n){
        int l = 0,r=n-1;
        while(l<=r){
            int m = (l+r)/2;
            if(a[m]!=m){
                if(m==0 || a[m-1]==m-1)
                    return m;
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return -1;
    }


//-8,-3,-2,-4,1, -6, -7,-3,-1  n = 7

    /**
     * Another way is to XOR all elements of array = XOR1
     * XOR all element from 1 till n = XOR2
     * XOR1 ^ XOR2 = missing element
     * @param a
     * @param n
     * @return
     */
    public static int findMissing(int a[],int n){
        for(int i=0;i<n;i++){
            if(Math.abs(a[i])-1 < n && a[Math.abs(a[i])-1] > 0){
                a[Math.abs(a[i])-1] = -a[Math.abs(a[i])-1];
            }
        }   
        for(int i=0;i<n;i++){
            if(a[i] > 0)
                return i+1;
        }
        return n+1;
    }
    
    public static int seggregate(int a[]){
        int n = a.length-1;
        int p = 0;
        while(p<n){
            if(a[p]>0){
                p++;
            }else if(a[p]<0){
                int temp = a[p];
                a[p] = a[n];
                a[n] = temp;
                p++;
                n--;
            }
        }
        return n;
    }

    public static Object[] union(int a1[],int a2[]){
        int i = 0,j=0;
        List<Integer> arr3 = new ArrayList<Integer>(); 
        while(i<a1.length && j<a2.length){
            if(a1[i] < a2[j]){
                arr3.add(a1[i]);
                i++;
            }else if(a1[i] > a2[j]){
                arr3.add(a2[j]);
                j++;
            }else{
                arr3.add(a1[i]);
                i++;
                j++;
            }
        }
        if(i!=a1.length){
            for(int k=i;k<a1.length;k++)
                arr3.add(a1[k]);
        }
        if(j!=a2.length){
            for(int k=j;k<a2.length;k++)
                arr3.add(a2[k]);
        }
        return arr3.toArray();
    }

    public static Object[] intersect(int a1[],int a2[]){
        int i = 0,j=0;
        List<Integer> arr4 = new ArrayList<Integer>(); 
        while(i<a1.length && j<a2.length){
            if(a1[i] < a2[j]){
            //    arr3.add(a1[i]);
                i++;
            }else if(a1[i] > a2[j]){
               // arr3.add(a2[j]);
                j++;
            }else{
                arr4.add(a1[i]);
                i++;
                j++;
            }
        }
        return arr4.toArray();
    }

    //2,5,8,7,6,1,1,9,6
    public static void evenOddPos(int a[]){
        int even = 0;
        int odd = 1;
        int i = 0;
        while(i<a.length) {
            if (i % 2 == 0) {
                if (a[i] % 2 != 0) {
                    int temp = a[i];
                    a[i] = a[odd];
                    a[odd] = temp;
                    }else{
                        even = even+2;
                        i++;
                    }
            }
            else {
                if (a[i] % 2 == 0) {
                    int temp = a[i];
                    a[i] = a[even];
                    a[even] = temp;
                    }else{
                        odd = odd+2;
                        i++;
                    }
            }
        }
    }

    /*
    Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n. Find the maximum repeating number in this array.
     */
    public static int mostFrequentInteger(int a[], int k){
        for(int i=0;i<a.length;i++){
            int ix = a[i]%k;
            a[ix] = a[ix] + k;
        }
        int max = Integer.MIN_VALUE;
        int maxIx = -1;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
                maxIx = i;
            }
        }

        // Restore array
        for(int i=0;i<a.length;i++){
            a[i] = a[i]%k;
        }
        display(a,a.length);
        return maxIx;
    }

    public static boolean isBalanced(String input) {
        java.util.Stack<Character> stack = new java.util.Stack();
        int i=0;
        while(i<input.length()){
            if(input.charAt(i) == ')') {
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
            if(input.charAt(i) == '(')
                stack.push('(');
            i++;
        }
        return stack.isEmpty();
    }

    public static int isValidMap(String a, String b) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        if (a.length() != b.length())
            return 0;
        else {
            for (int i = 0; i < a.length(); i++) {
                if (map.get(a.charAt(i)) == null) {
                    map.put(a.charAt(i), b.charAt(i));
                } else {
                    if (map.get(a.charAt(i)) != null
                            && map.get(a.charAt(i)) != b.charAt(i))
                        return 0;
                }
            }
            return 1;
        }
    }

    public static void productPair(int a[], int prod){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
            if(prod==0 && a[i]==0){
                System.out.println(a[i]);
                return;
            }else if(prod%a[i] == 0 && set.contains(prod/a[i])){
                System.out.println(a[i] + " " + prod/a[i]);
            }
            set.add(a[i]);
        }
    }

    // eg ABC => A B C, A BC, AB C,
    public static void insertSpaces(String input, String currentStr, int current, int end){
        if(current>end){
            System.out.println(currentStr);
        }else{
            insertSpaces(input, currentStr + input.charAt(current)+" ", current+1, end);
            if(current!=end)
                insertSpaces(input, currentStr + input.charAt(current)+"", current+1, end);
        }
    }

    public static int equilibriumIndex(int a[]){
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum = sum + a[i];
        }
        int leftSum = 0;
        int rightSum = sum;
        for(int i=0;i<a.length;i++){
            rightSum = rightSum - a[i];
            if(leftSum==rightSum)
                return i;
            leftSum = leftSum + a[i];
        }
        return -1;
    }

    /**
     *
     * @param a
     * @return int xor sum of all subarrays
     * eg. {1, 2, 3}
     * 1^2^3 0
     * (1^2) ^ (2^3) (11) ^ (01) (10) = 2
     * (1^2^3) = 0
     * output=2
     *
     * We can generate all subarrays but it will be expensive
     * so, all we need to do is find occurences of elements in creating subarrays
     * and then xor all elements having odd occurences
     * Occurence of an element at ith location is
     * (i+1) * (N-i)
     */
    public static int subarrayXORs(int a[]){
        int xor = 0;
        for(int i=0;i<a.length;i++){
            int occurences = (i+1) * (a.length-i);
            if(occurences%2!=0)
                xor = xor^a[i];
        }
        return xor;
    }

    /*
    push first element to stack
    start from element with index=1 call it next
    if next element is greater than popped element from stack then we have our number
    keep doing this until we can find such a number.
    When we cant find such a number, push the popped element back to stack
    probably it does not have greater number or it will come later
    also push the next element into stack, since we need to find greater element for this.
     */
    public static void printNextGreaterElement(int a[]){
        Stack<Integer> s = new Stack();
        s.push(a[0]);
        for(int i=1;i<a.length;i++){
            int next = a[i];
            if(!s.isEmpty()){
                int pop = s.pop();
                while(pop < next){
                    System.out.println(pop + " has greater " + next);
                    if(s.isEmpty())
                        break;
                    pop = s.pop();
                }
                if(next < pop)
                    s.push(pop);
            }
            s.push(next);
        }

        while(!s.isEmpty()){
            System.out.println(s.pop() + " has greater -1");
        }
    }

    /**
     * Given an array of positive integers. We need to make the given array a ‘Palindrome’. Only allowed operation on array is merge. Merging two adjacent elements means replacing them with their sum.
     * @param in
     * @return
     */
    public static int mergeOperationToMakePalindrome(int in[]){
        int count = 0;
        int i=0, j = in.length-1;
        while (i<=j){
            if(in[i] == in[j]){
                i++;
                j--;
            }else if(in[i] < in[j]){
                if(i+1 >= in.length)
                    break;
                in[i+1] = in[i] + in[i+1];
                i++;
                count++;
            }else {
                if(j-1 < 0)
                    break;
                in[j - 1] = in[j] + in[j - 1];
                j--;
                count++;
            }
        }
        return count;
    }

    /**
     *
     Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.

     Incremental operations:Choose 1 element from the array and increment its value by 1.
     Doubling operation: Double the values of all the elements of array.

     Instead of creating array we can reverse engineer and try to make array all zeros and count operations involved
     * @param in
     * @return
     */
    public static int countStepsToTransform(int in[]){
        int operations = 0;

        while (true){
            int countZero = 0;
            for(int i=0;i<in.length;i++){
                if(in[i]==0)
                    countZero++;
                else if(in[i]%2!=0){
                    in[i]--;
                    operations++;
                    if(in[i]==0)
                        countZero++;
                }
            }

            if(countZero==in.length)
                return operations;

            for(int i=0;i<in.length;i++){
                in[i] = in[i]/2;
            }
            operations++;
        }
    }

    /**
     * Idea is to find length of sorted subarray.
     * Number of subarrays that can be created is length * (length-1)/2
     * @param in
     * @return
     */
    public static int countStrictlyIncreasingSubarrays(int in[]){
        int i=0, count=0;
        while (i<in.length-1){
            int currentLength = 1;
            while (i<in.length-1 && in[i] < in[i+1]){
                currentLength++;
                i++;
            }
            count = count + currentLength * (currentLength-1)/2;
            i++;
        }
        return count;
    }

    public static void leaders(int a[]){
        int lastLeader = a[a.length-1];
        System.out.println(lastLeader);
        for(int i=a.length-2;i>=0;i--){
            if(a[i]>lastLeader) {
                System.out.println(a[i]);
                lastLeader = a[i];
            }
        }
    }

    public static void firstAndSecondSmallest(int a[]){
        int firstSmallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]<firstSmallest){
                secondSmallest = firstSmallest;
                firstSmallest = a[i];
            }
        }
        System.out.println("First Smallest " + firstSmallest + " and Second Smallest " + secondSmallest);
    }

    public static boolean hasConsecutiveIntegers(int a[]){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]>max)
                max = a[i];
            if(a[i]<min)
                min = a[i];
        }

        if(max-min+1 !=a.length)
            return false;

        for(int i=0;i<a.length;i++){
            int ix = Math.abs(a[i]) - min;
            if(a[ix]>0)
                a[ix] = -a[ix];
        }
        for(int i=0;i<a.length;i++){
            if(a[i]>0){
                System.out.println("Missing is " + (min+i));
                return false;
            }
        }
        return true;
    }

    public static void findUniqueStrings(String in[]){
        Set<String> uniq = new HashSet<>();
        Set<String> dups = new HashSet<>();
        for(int i=0;i<in.length;i++){
            if(!uniq.contains(in[i]))
                uniq.add(in[i]);
            else
                dups.add(in[i]);
        }

        uniq.removeAll(dups);
        for(String out: uniq){
            System.out.println(out);
        }
    }

    /**
     * Given an array A[0 … n-1] containing n positive integers, a subarray A[i … j] is bitonic if there is a k with i <= k <= j such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j]. Write a function that takes an array as argument and returns the length of the maximum length bitonic subarray.
     Expected time complexity of the solution is O(n)

     Idea is to store increasing lenght in inc
     and dec length from right to left in dec
     and find max for inc[i]+dec[i]-1
     * @param a
     * @return
     */
    public static int maxBitonicSubarrayLength(int a[]){
        int inc[] = new int[a.length];
        int dec[] = new int[a.length];
        inc[0] = 1;
        dec[a.length-1] = 1;
        for(int i=1;i<a.length;i++){
            if(a[i]>a[i-1])
                inc[i] = inc[i-1]+1;
            else
                inc[i] = 1;
        }

        for(int i=a.length-2;i>=0;i--){
            if(a[i]>a[i+1])
                dec[i] = dec[i+1]+1;
            else
                dec[i] = 1;
        }

        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<inc.length;i++){
            int sum = inc[i] + dec[i]-1;
            if(sum>maxLength)
                maxLength = sum;
        }
        return maxLength;
    }

    public static void moveZerosWithOrder(int in[]){
        for(int i=1;i<in.length;i++){
            if(in[i]==0)
                continue;
            int j = i;
            while (j>0){
                if(in[j-1] == 0) {
                    swap(in, j, j - 1);
                    j--;
                }else
                    break;
            }
        }
    }

    public static String flattenArray(Object in[]){
        for(int i=0;i<in.length;i++){
            if(in[i].getClass() == int[].class){
                int curr[] = (int [])in[i];
                for(int m=0;m<curr.length;m++){
                    System.out.println(curr[m]);
                }
            }else
                flattenArray((Object[]) in[i]);
        }
        return "";
    }

    public static void main(String[] args) {
        int a[] = {-3, 2,-4,5,-30};
        System.out.println(maxProductSubarray(a));
//        int in[][][] = {{{11,21,31},{41,51}},{{61}},{{71,81,91},{110,111,112,113,114}}};
//        System.out.println(flattenArray(in));
//        int in[] = {1,2,3};
//        moveZerosWithOrder(in);
//        display(in);
//        System.out.println(lengthOfLongestSubstring("p"));
//        int a[] = {12, 3, 4, 1, 6, 9};
//        threeSum(a, 19);
//        int a[] = {20, 4, 1, 2, 3, 4, 2, 10};
//        System.out.println(maxBitonicSubarrayLength(a));
//        String in[] = {"a","b","b","c","d","e","m","n","c","d","e"};
//        findUniqueStrings(in);
//        int a[] = {83,78,80,81,80,82};
//        System.out.println(hasConsecutiveIntegers(a));
//        int a[] = {16, 17, 4, 3, 5, 2};
//        firstAndSecondSmallest(a);
//        leaders(a);
//        int in[] = {1,2,2,4};
//        System.out.println(countStrictlyIncreasingSubarrays(in));
//        int in[] = {16,16,16};
//        System.out.println(countStepsToTransform(in));
//        int a[] = {2,5,8,10};
//        int b[] = {1,7,12,14}; // 1,2,5,7,8,10,12,14
//        System.out.println(sortedMedianUtil(a,b,0,a.length-1,0,b.length-1));
//        int a[] = {6,8,10,15,19,25,-3,1,4};
//        System.out.println(searchCircularSorted(a, 25));
//        int a[] = {5,8,2,7,1};
//        printNextGreaterElement(a);
//        int a[] = {1,2,3,4};
//        System.out.println(subarrayXORs(a));
//        int a[] = {7,-7,1,5,-7,2,0,-4,3,-2,2};
//        System.out.println(equilibriumIndex(a));
//        insertSpaces("ABC","",0,2);
//        int a[] = {-4,-3,2,8,1,9,-6};
//        productPair(a,0);
//        int a[] = {3,3,4,5,6,7,8,8,8,13,15,17,17,17,18};
//        int len = Arrays.removeDuplicates(a)+1;
//        Arrays.display(a,len);
//        int a[] = {3,0,0,4,0,5,0,6,7,8,0,0,9,0,0};
//        Arrays.shiftZerosWithOrder(a);
//        Arrays.display(a, a.length);
//        int a[] = {11, -12, 15, -3, 8, -9, 1, 8, 10, -2};
//        Arrays.maxSumSubsequence(a);
//        int a[] = {8,9,1,6,7,2,5,3,4,10,0};
//        Arrays.sumPair(a, 10);
//        Arrays.sumPairWithoutSort(a, 10);
//        int a[][] = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
//        Arrays.spiralDisplay(a,4,4);


//        int a[] = {2, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
//        Arrays.dutchFlag(a);
//        Arrays.display(a,a.length);
//        int input[] =  {8,3,2,4,1, -1, 7,-3,6};
//        System.out.println(findMissing(input,seggregate(input)));
//        int a[] = {2, 5, 7, 8, 1, 6, 9, 1, 6};
//        Arrays.evenOddPos(a);
//        Arrays.display(a, a.length);
//        int in[] = {2, 3, 3, 5, 3, 4, 1, 7};
//        System.out.println("\n" + Arrays.mostFrequentInteger(in,8));
//        int a[] = {2, 4, 1, 3, 5};
//        System.out.println(Arrays.countInversion(a,0,a.length-1));
//        int a[] = {1,2,3,4,5,6,7};
//        rotateArrayByK(a,3);
//        display(a);
//        int a[] ={30,20,45,34,23,12,21,89,14};
//        System.out.println(kthMin(a,0, a.length-1, 2));
//        int a[] = {3,4,5,5,3,2,5,5,2,4,5,5,6,5,5,5,6,5,25,3};
//        System.out.println(majorityElement(a));
//        int a[] = {1, 60, -10, 70, -80, 85,12,9,10};
//        sumClosestToZero(a);

//        int a[] = { 10,4,1,2,6,7,1,3,5,9,8,4};
//        duplicateElements(a,10);
//        int in[] = {1,5,4,1};
//        System.out.println(mergeOperationToMakePalindrome(in));

    }

}


