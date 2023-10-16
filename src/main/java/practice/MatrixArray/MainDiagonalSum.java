package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainDiagonalSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,-2,-3)));
        A.add(new ArrayList<>(Arrays.asList(-4,5,-6)));
        A.add(new ArrayList<>(Arrays.asList(-7,-8,9)));
        System.out.println(solve(A));
    }

    public static int solve(final List<ArrayList<Integer>> A) {
        int sum = 0;
        for (int i=0; i<A.size(); i++){
            sum += A.get(i).get(i);
        }
        return sum;
    }
}
