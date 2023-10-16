package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class EqualMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,2)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(1,2,3)));
        B.add(new ArrayList<>(Arrays.asList(4,5,6)));
        B.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println(solve(A, B));
    }

    public static boolean solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B){
        int m = A.size();
        int n = A.get(1).size();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if(A.get(i).get(j) != B.get(i).get(j))
                    return false;
            }
        }
        return true;
    }
}
