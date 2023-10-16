package practice.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubArraySum0 {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 1));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> AMap = new HashMap<>();
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(0, A.get(0));
        for (int i=1; i<A.size(); i++){
            if ((prefixSum.get(i-1)+A.get(i)) == 0)
                return 1;
            prefixSum.add(i, prefixSum.get(i-1)+A.get(i));
        }
        for (int num: prefixSum){
            AMap.put(num, AMap.getOrDefault(num,0)+1);
        }
        if (AMap.size() != prefixSum.size())
            return 1;

        return 0;
    }
}
