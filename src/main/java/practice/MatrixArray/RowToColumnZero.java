package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class RowToColumnZero {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6,0)));
        A.add(new ArrayList<>(Arrays.asList(7,8,0,9)));
        System.out.println(solve(A));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B= new ArrayList<>();
        for (int i=0; i<A.size(); i++) {
            B.add(new ArrayList<>());
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(A.get(i).get(j));
            }
        }
        for (int i=0; i<A.size(); i++){
            for (int j=0; j<A.get(i).size(); j++){
                if(A.get(i).get(j) == 0){
                    for (int x=0; x<A.size(); x++){
                        B.get(x).set(j, 0);
                    }
                    for (int y=0; y<A.get(i).size(); y++){
                        B.get(i).set(y,0);
                    }
                }
            }
        }
        return B;
    }
}
