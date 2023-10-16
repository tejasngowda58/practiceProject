package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinorDiagonalSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, -2, -3)));
        A.add(new ArrayList<>(Arrays.asList(-4,5,-6)));
        A.add(new ArrayList<>(Arrays.asList(-7,-8,9)));

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(3, 2)));
        B.add(new ArrayList<>(Arrays.asList(2, 3)));
        System.out.println(solve(B));
    }

    public static int solve(final List<ArrayList<Integer>> A) {
        int sum = 0;
        for(int i=0; i<A.size(); i++){
          sum += A.get(i).get(A.size()-i-1);
        }
        return sum;
    }
}
