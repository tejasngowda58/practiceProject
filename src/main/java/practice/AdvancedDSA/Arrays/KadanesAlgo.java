package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KadanesAlgo {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        System.out.println(maxSubArray(A));
    }

    public static int maxSubArray(final List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<A.size(); i++){
            sum += A.get(i);
            max = Integer.max(max, sum);
            if (sum<0){
                sum = 0;
            }
        }
        return max;
    }
}
