package practice.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array
// a special if elements at those indices in the array are equal.
//Shaggy wants you to find a special pair such that the distance between that pair is minimum.
// Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
public class ShaggyDistance {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> Amap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i=0; i<A.size(); i++){
            if (!Amap.containsKey(A.get(i)))
                Amap.put(A.get(i), i);
            else {
                int index = Amap.get(A.get(i));
                int distance = i-index;
                if (distance<min)
                    min=distance;
            }
        }
        if (min==Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
