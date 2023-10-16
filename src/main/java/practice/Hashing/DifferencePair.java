package practice.Hashing;

import java.util.*;

public class DifferencePair {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(41, 40));
        System.out.println(diffPossible(A, 2));
    }
    public static int diffPossible(final List<Integer> A, int B) {
        Map<Integer, Integer> data = new HashMap<>();
        if (A.size() == 1)
            return 0;
        for (int num : A){
            data.put(num, data.getOrDefault(num, 0)+1);
        }
        for (int num : A){
            int target = B+num;
            if (target==num && data.get(target)>1)
                return 1;
            else if(target!=num && data.containsKey(target))
                return 1;
        }
        return 0;
    }
}
