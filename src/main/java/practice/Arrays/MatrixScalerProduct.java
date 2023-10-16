package practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixScalerProduct {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println(solve(A, 2));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {

        for (int i=0; i<A.size(); i++){
            for (int j=0; j<A.get(i).size(); j++){
                int product = A.get(i).get(j) * B;
                A.get(i).set(j, product);
            }
        }
        return A;
    }
}
