package practice.AdvancedDSA.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountRightTriangles {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 2));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2, 1));
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        int count = 0;
        for (int i=0; i<A.size(); i++){
            xMap.put(A.get(i), xMap.getOrDefault(A.get(i), 0)+1);
        }

        for (int i=0; i<B.size(); i++){
            yMap.put(B.get(i), yMap.getOrDefault(B.get(i), 0)+1);
        }
//        System.out.println(xMap);
//        System.out.println(yMap);

        for (int i=0; i< A.size(); i++){
            int pointOnXAxis = xMap.get(A.get(i))-1;
            int pointOnYAxis = yMap.get(B.get(i))-1;
            count += pointOnXAxis*pointOnYAxis;
        }
        return count;
    }
}
