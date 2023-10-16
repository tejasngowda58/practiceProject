package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfAllSubMatrices {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,1)));
        A.add(new ArrayList<>(Arrays.asList(1,1)));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int sum = 0;
        for (int i=0; i<A.size(); i++){
            for (int j=0; j<A.get(i).size(); j++){
                sum += (A.get(i).get(j)*(i+1)*(j+1)*(A.size()-i)*(A.get(i).size()-j));
            }
        }
        return sum;
    }
}
