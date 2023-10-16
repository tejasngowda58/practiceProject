package practice.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonElement {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 4, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3, 6, 2, 10, 10));
        System.out.println(solve(A, B));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> AMap = new HashMap<>();
        Map<Integer, Integer> BMap = new HashMap<>();
        for (int i =0; i<A.size(); i++){
            if(AMap.containsKey(A.get(i))){
                int val = AMap.get(A.get(i));
                val++;
                AMap.put(A.get(i), val);
            }
            else
                AMap.put(A.get(i), 1);
        }

        for (int i =0; i<B.size(); i++){
            if(BMap.containsKey(B.get(i))){
                int val = BMap.get(B.get(i));
                val++;
                BMap.put(B.get(i), val);
            }
            else
                BMap.put(B.get(i), 1);
        }

        for (Map.Entry<Integer, Integer> entry : AMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if (BMap.containsKey(key)) {
                int value1 = BMap.get(key);
                if (value1<value)
                    value=value1;
            }
            else
                value=0;

//            System.out.println("key is " + key + " value is " + value);
            while (value!=0) {
                result.add(key);
                value--;
            }

        }
//        System.out.println(AMap);
//        System.out.println(BMap);
        return result;
    }
}
