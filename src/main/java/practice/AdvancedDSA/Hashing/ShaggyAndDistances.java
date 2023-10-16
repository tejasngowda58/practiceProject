package practice.AdvancedDSA.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShaggyAndDistances {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for (int i=0; i<A.size(); i++){
            if (map.getOrDefault(A.get(i), -1) == -1){
                map.put(A.get(i), i);
            }
        }
        for (int i=0; i<A.size(); i++){
            int value = map.get(A.get(i));
            int count = 0;
            if (value!=i){
                count = i-value;
                ans=Integer.min(ans, count);
            }
        }
//        System.out.println(map);
        ans = ans==Integer.MAX_VALUE?-1 : ans;
        return ans;
    }
}
