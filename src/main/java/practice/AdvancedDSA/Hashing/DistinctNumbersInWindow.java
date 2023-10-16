package practice.AdvancedDSA.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
        System.out.println(dNums(A, 3));
    }

    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<B; i++){
            map.put(A.get(i), map.getOrDefault(A.get(i), 0)+1);
        }
        result.add(map.size());
        for (int i=B; i<A.size(); i++){
            map.put(A.get(i), map.getOrDefault(A.get(i), 0)+1);
            int value = map.get(A.get(i-B));
            if (value == 1)
                map.remove(A.get(i-B));
            else
                map.put(A.get(i-B), value-1);

            result.add(map.size());
        }
//        System.out.println(map);
        return result;
    }
}
