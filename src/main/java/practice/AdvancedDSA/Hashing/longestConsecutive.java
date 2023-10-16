package practice.AdvancedDSA.Hashing;

import java.util.*;

public class longestConsecutive {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2));
        System.out.println(solution(A));
    }

    public static int solution(final List<Integer> A) {
        Set<Integer> set = new HashSet<>();
        for (int data: A)
            set.add(data);
        int ans = 0;
        for (int data: set){
            int count = 1;
            if (!set.contains(data-1)){
                while (set.contains(data+1)){
                    count++;
                    data++;
                }
                ans = Integer.max(ans, count);
            }
        }
        return ans;
    }
}
