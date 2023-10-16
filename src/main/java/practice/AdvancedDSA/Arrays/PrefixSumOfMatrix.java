package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PrefixSumOfMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println(solve(A));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A){
        for (int i=0; i<A.size(); i++){
            for (int j=1; j<A.get(0).size(); j++){
                A.get(i).set(j, A.get(i).get(j-1)+A.get(i).get(j));
            }
        }
        for(int i=0; i<A.get(0).size(); i++){
            for (int j=1; j<A.size(); j++){
                A.get(j).set(i, A.get(j-1).get(i) + A.get(j).get(i));
            }
        }
        return A;
    }
}
