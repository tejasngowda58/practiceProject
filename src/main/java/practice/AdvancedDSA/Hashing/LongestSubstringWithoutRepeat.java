package practice.AdvancedDSA.Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String A = "AaaA";
        System.out.println(lengthOfLongestSubstring(A));
    }

    public static int lengthOfLongestSubstring(String A) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i=0;
        int j=0;
        while (j<A.length()){
            if (!set.contains(A.charAt(j))){
                set.add(A.charAt(j));
                j++;
                ans =Math.max(set.size(), ans);
            }
            else {
                set.remove(A.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
