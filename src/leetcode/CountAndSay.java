package leetcode;

/**
 * Created by shobhanksharma on 8/22/17.
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n){
        String lastTerm = "1";
        String curr = "";
        for(int i=1;i<n;i++){
            curr = "";
            for(int j=0;j<lastTerm.length();j++){
                char key = lastTerm.charAt(j);
                int count = 0;
                while(j<lastTerm.length() && key == lastTerm.charAt(j)){
                    j++;
                    count++;
                }
                j--;
                curr = curr + count + key;
            }
            lastTerm = curr;
        }
        return lastTerm;
    }
}
