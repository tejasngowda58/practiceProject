package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class TransposeInSameMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println();
        solve(A);
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A){
        int m = A.get(0).size();
        int n = A.size();

        for(int i=0; i<n; i++){
            for (int j=i+1;j<m; j++){
                int temp = A.get(i).get(j);
                A.get(i).remove(j);
                A.get(i).add(j, A.get(j).get(i));
                A.get(j).remove(i);
                A.get(j).add(i, temp);
            }
        }
        System.out.println(A);
        return A;
    }

    public static void swap(ArrayList<ArrayList<Integer>> A, int i, int j){
        int temp = A.get(i).get(j);
        A.get(i).remove(j);
        A.get(i).add(j, A.get(j).get(i));
        A.get(j).remove(i);
        A.get(j).add(i, temp);
    }
}
