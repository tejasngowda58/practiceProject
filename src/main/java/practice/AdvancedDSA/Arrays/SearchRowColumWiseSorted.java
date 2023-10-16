package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchRowColumWiseSorted {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
//        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
//        A.add(new ArrayList<>(Arrays.asList(7,8,9)));

        A.add(new ArrayList<>(Arrays.asList(2, 8, 8, 8)));
        A.add(new ArrayList<>(Arrays.asList(2, 8, 8, 8)));
        A.add(new ArrayList<>(Arrays.asList(2, 8, 8, 8)));
        int B = 8;
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int result = Integer.MAX_VALUE;
        int i = 0;
        int j = A.get(0).size()-1;

        while (i<A.size() && j>=0){
            if(B > A.get(i).get(j))
                i++;
            else if(B < A.get(i).get(j))
                j--;
            else{
                int value = (i+1)*1009+(j+1);
                result = Integer.min(result, value);
//                result = value;
                j--;
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
