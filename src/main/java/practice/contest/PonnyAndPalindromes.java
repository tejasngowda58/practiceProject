package practice.contest;

import java.util.HashMap;
import java.util.Map;

public class PonnyAndPalindromes {
    public static void main(String[] args) {
        System.out.println(solve("aaba"));
    }

    public static int solve(String A) {
        int value = 1;
        HashMap<Character, Integer> data = new HashMap<>();
        int len = A.length();
        for(int i=0; i<len; i++){
            data.put(A.charAt(i), data.getOrDefault(A.charAt(i), 0)+1);
        }
        int count = 0;
        for (Integer val : data.values()) {
            if(val%2 != 0)
                count++;
            if(count>1)
                return 0;
        }
        return value;
    }
}
