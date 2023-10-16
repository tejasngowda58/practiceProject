package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateBy90degree {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        solve(A);
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A){
        int N = A.get(0).size();

        for(int i=0; i<N; i++){
            for (int j=i+1;j<N; j++){
                int temp = A.get(i).get(j);
                A.get(i).remove(j);
                A.get(i).add(j, A.get(j).get(i));
                A.get(j).remove(i);
                A.get(j).add(i, temp);
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<N/2; j++){
                int temp1 = A.get(i).get(j);
                int temp2 = A.get(i).get(N-1-j);
                A.get(i).remove(j);
                A.get(i).add(j, temp2);
                A.get(i).remove(N-1-j);
                A.get(i).add(N-1-j, temp1);
            }
        }

//        System.out.println(A);
        return A;
    }
}
