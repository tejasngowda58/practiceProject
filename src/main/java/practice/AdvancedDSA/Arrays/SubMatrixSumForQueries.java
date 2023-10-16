package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SubMatrixSumForQueries {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1000000017,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));

        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,2));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(1,2));
        ArrayList<Integer> D = new ArrayList<>(Arrays.asList(2,3));
        ArrayList<Integer> E = new ArrayList<>(Arrays.asList(2,3));

        System.out.println(solve(A, B, C, D, E));
    }

    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        ArrayList<Integer> result = new ArrayList<>();
        int modValue = (int) (Math.pow(10,9)+7);
        System.out.println(modValue);
        System.out.println(999999470%modValue);
//        Construct a prefix sum matrix;
        for (int i=0; i<A.size(); i++){
            for (int j=1; j<A.get(0).size(); j++){
                int val = ( (A.get(i).get(j-1))%(modValue) + (A.get(i).get(j))%(modValue) )%modValue;
                A.get(i).set(j, val);
            }
        }
        for(int i=0; i<A.get(0).size(); i++){
            for (int j=1; j<A.size(); j++){
                int val = (A.get(j-1).get(i)%modValue + A.get(j).get(i)%modValue) % modValue;
                A.get(j).set(i, val);
            }
        }

        for (int k=0; k<B.size(); k++){
            int x = D.get(k)-1;
            int y = E.get(k)-1;
            int i = B.get(k)-1;
            int j = C.get(k)-1;
            int sum = 0;

            if(i==0 && j==0)
                sum = A.get(x).get(y);
            if (j==0 && i>0)
                sum = A.get(x).get(y) - A.get(i-1).get(y);
            if (i==0 && j>0)
                sum = A.get(x).get(y) - A.get(x).get(j-1);
            if (j>0 && i>0)
                sum = (A.get(x).get(y) - A.get(i-1).get(y) - A.get(x).get(j-1) + A.get(i-1).get(j-1))%modValue;

            result.add(sum);
        }

        return result;
    }
}
