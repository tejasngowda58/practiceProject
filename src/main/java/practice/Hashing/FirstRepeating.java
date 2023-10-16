package practice.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstRepeating {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(6, 10, 5, 4, 9, 120));
        System.out.println(solve(A));
    }
    public static int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> AMap = new HashMap<>();
        for (int num: A){
            AMap.put(num, AMap.getOrDefault(num, 0)+1);
        }
        for (int num : A){
            if (AMap.get(num) > 1)
                return num;
        }
        return -1;
    }
}
