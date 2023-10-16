package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class RowSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<A.size(); i++){
            int sum = 0;
            for (int j=0; j<A.get(i).size(); j++){
                sum += A.get(i).get(j);
            }
            result.add(sum);
        }
        return result;
    }
}
