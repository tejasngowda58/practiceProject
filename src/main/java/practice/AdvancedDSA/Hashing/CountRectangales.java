package practice.AdvancedDSA.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountRectangales {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 2, 2));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2, 1, 2));
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Set<String> points = new HashSet<>();
        int count=0;
        for (int i=0; i< A.size(); i++){
            String point = A.get(i).toString() + " " + B.get(i).toString();
            points.add(point);
        }
        for (int i=0; i< A.size(); i++){
            for (int j=i+1; j< A.size(); j++){
                if (!A.get(i).equals(A.get(j)) && !B.get(i).equals(B.get(j))){
                    String p1 = A.get(i).toString() + " " + B.get(j).toString();
                    String p2 = A.get(j).toString() + " " + B.get(i).toString();
                    if (points.contains(p1) && points.contains(p2))
                        count++;
                }
            }
        }
//        System.out.println(points);
        return count/2;
    }
}
