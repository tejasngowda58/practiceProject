package practice.AdvancedDSA.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Unique2DPoints {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(5,6)));
        A.add(new ArrayList<>(Arrays.asList(2,8)));
        A.add(new ArrayList<>(Arrays.asList(-1,-1)));
        A.add(new ArrayList<>(Arrays.asList(2,-3)));
        A.add(new ArrayList<>(Arrays.asList(2,8)));
        A.add(new ArrayList<>(Arrays.asList(7,7)));
        A.add(new ArrayList<>(Arrays.asList(2,-3)));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        Set<String> set = new HashSet<>();
        for (int i=0; i<A.size(); i++){
            String point = A.get(i).get(0).toString() + " " + A.get(i).get(1);
            set.add(point);
        }
        return set.size();
    }
}
