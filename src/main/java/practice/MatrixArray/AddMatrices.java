package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class AddMatrices {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(9,8,7)));
        B.add(new ArrayList<>(Arrays.asList(6,5,4)));
        System.out.println(solve(A, B));
    }
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<A.size();i++){
            result.add(new ArrayList<>());
            for (int j=0; j<A.get(0).size(); j++){
                result.get(i).add(j, A.get(i).get(j)+B.get(i).get(j));
            }
        }
//        System.out.println(A.size());
        return result;
    }
}
