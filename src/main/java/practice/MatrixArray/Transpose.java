package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class Transpose {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2)));
        A.add(new ArrayList<>(Arrays.asList(1,2)));
        A.add(new ArrayList<>(Arrays.asList(1,2)));
        System.out.println(solve(A));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = A.size();
        int m = A.get(0).size();

        for(int j=0; j<m; j++){
            result.add(new ArrayList<>());
            for (int i=0; i<n; i++){
                result.get(j).add(A.get(i).get(j));
            }
        }
        return result;
    }
}
