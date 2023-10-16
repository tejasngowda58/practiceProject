package practice.AdvancedDSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println(towerOfHanoi(2));
    }

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        solve(1, 1, 2, 3, result);
        return result;
    }

    public static void solve(int A, int src, int temp, int dest, ArrayList<ArrayList<Integer>> result){
        if (A==0)
            return;
        solve( A-1, src, dest, temp, result);
        ArrayList<Integer> output = new ArrayList<>();
        output.add(A);
        output.add(src);
        output.add(dest);
        result.add(output);
        solve( A-1, temp, src, dest, result);
    }
}
