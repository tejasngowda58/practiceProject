package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeggarsInStreet {
    public static void main(String[] args) {
        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        B.add(new ArrayList<>(Arrays.asList(2, 3, 20)));
        B.add(new ArrayList<>(Arrays.asList(2, 5, 25)));
        System.out.println(solve(A, B));
    }

    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        Integer[] result = new Integer[A];
        for(int i=0; i<A; i++)
            result[i] = 0;

        for (int i=0; i<B.size(); i++){
            result[B.get(i).get(0)-1] += B.get(i).get(2);
            if (B.get(i).get(1)<A) {
                result[B.get(i).get(1)] += -B.get(i).get(2);
            }
        }

        for(int i=1; i<A; i++)
            result[i] +=result[i-1];

        return new ArrayList<>(Arrays.asList(result));
    }
}
