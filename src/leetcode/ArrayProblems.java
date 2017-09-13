package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {
    public static void main(String[] args) {
//        System.out.println(new ArrayProblems().twoSum(new int[]{3,2,4},6));
        System.out.println(new ArrayProblems().reverseWords(" Hello How are you"));
    }

    public String reverseWords(String s) {
        int i = 0;
        int j = 0;
        char in[] = s.toCharArray();
        while(i<s.length()){
            while(j<s.length() && s.charAt(j)!=' '){
                j++;
            }
            s = reverse(in,i,j-1);
            i = j+1;
            j = i;
        }
        java.util.Arrays.deepToString(new Object[]{});
        return new String(in);
    }

    public String reverse(char in[], int x, int y){
        while(x<y){
            swap(in,x,y);
            x++;
            y--;
        }
        return new String(in);
    }

    public void swap(char in[], int x, int y){
        char temp = in[x];
        in[x] = in[y];
        in[y] = temp;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int out[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(map.containsKey(diff)){
                out[0] = i;
                out[1] = map.get(diff);
                return out;
            }else{
                map.put(nums[i],i);
            }
        }
        return out;
    }

    public int[] searchRange(int[] nums, int target) {
        int out[] = new int[2];
        out[0] = searchStart(nums, 0, nums.length-1, target);
        out[1] = searchEnd(nums, 0, nums.length-1, target);
        return out;
    }

    public int searchStart(int a[], int x, int y, int target){
        while(x<=y){
            int m = (x+y)/2;
            if(a[m]==target){
                if((m>=1 && a[m-1]!=target) || m==0)
                    return m;
                else
                    y = m-1;
            }else if(target>a[m])
                x = m+1;
            else
                y = m-1;
        }
        return -1;
    }

    public int searchEnd(int a[], int x, int y, int target){
        while(x<=y){
            int m = (x+y)/2;
            if(a[m]==target){
                if((m<a.length-1 && a[m+1]!=target) || m==y)
                    return m;
                else
                    x = m+1;
            }else if(target>a[m])
                x = m+1;
            else
                y = m-1;
        }
        return -1;
    }
}