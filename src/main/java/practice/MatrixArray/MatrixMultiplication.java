package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(62, -37, -49, 18, -53, 14, 51)));
        A.add(new ArrayList<>(Arrays.asList(62, -52, -11, -21, -62, -44, -95)));
        A.add(new ArrayList<>(Arrays.asList(20, 78, -29, -49, -17, 21, 83)));
        A.add(new ArrayList<>(Arrays.asList(-99, -69, -39, -47, 19, -50, -90)));
        A.add(new ArrayList<>(Arrays.asList(91, -96, 63, -23, 5, 94, 49)));
        A.add(new ArrayList<>(Arrays.asList(17, 1, 16, 63, -78, -13, -100)));
        A.add(new ArrayList<>(Arrays.asList(-7, 72, 16, 86, -53, 94, 85)));
        A.add(new ArrayList<>(Arrays.asList(-82, 78, 96, -45, -42, 38, 34)));
        A.add(new ArrayList<>(Arrays.asList(-88, 37, 12, 31, -91, 51, 23)));

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(90, 68, 2, 54, -59)));
        B.add(new ArrayList<>(Arrays.asList(78, -86, 8, -30, 24)));
        B.add(new ArrayList<>(Arrays.asList(-92, 84, -62, 13, 2)));
        B.add(new ArrayList<>(Arrays.asList(12, -73, -53, -91, -4)));
        B.add(new ArrayList<>(Arrays.asList(74, 85, -51, -4, 37)));
        B.add(new ArrayList<>(Arrays.asList(-30, -27, 10, -78, 29)));
        B.add(new ArrayList<>(Arrays.asList(-96, 39, -42, 93, 78)));
        System.out.println(solve(A,B));
    }
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int N = A.get(0).size();
        int M = A.size();
        int P = B.get(0).size();

        for (int i=0; i<M; i++){
            result.add(new ArrayList<>());
            for (int j=0; j<P; j++){
                int prod = 0;
                for (int k=0; k<N; k++){
                    prod = prod + (A.get(i).get(k)*B.get(k).get(j) );
                }
                result.get(i).add(prod);
            }
        }
        return result;
    }
}
