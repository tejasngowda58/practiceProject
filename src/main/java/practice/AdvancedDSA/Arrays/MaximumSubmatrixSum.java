package practice.AdvancedDSA.Arrays;

/*
Row wise column wise sorted
 */
import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubmatrixSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println(solve(A));
    }

    public static Long solve(ArrayList<ArrayList<Integer>> A) {
        long max = Long.MIN_VALUE;
        long sum = 0;
ArrayList<ArrayList<Long>> B = new ArrayList<>();

        for (int i=0; i<A.size(); i++){
            B.add(new ArrayList<>());
            B.get(i).add(0, (long) A.get(i).get(0));
            for (int j=1; j<A.get(0).size(); j++){
                B.get(i).add(j, B.get(i).get(j-1)+A.get(i).get(j));
            }
        }
//        System.out.println(B);
        for(int i=0; i<B.get(0).size(); i++){
            for (int j=1; j<B.size(); j++){
                B.get(j).set(i, B.get(j-1).get(i) + B.get(j).get(i));
            }
        }

//        System.out.println(B);
        int x = A.size()-1;
        int y = A.get(0).size()-1;
        for (int i=0; i<A.size(); i++){
            for (int j=0;j<A.get(0).size(); j++){
                if(i==0 && j==0)
                    sum = B.get(x).get(y);
                if (j==0 && i>0)
                    sum = B.get(x).get(y) - B.get(i-1).get(y);
                if (i==0 && j>0)
                    sum = B.get(x).get(y) - B.get(x).get(j-1);
                if (j>0 && i>0)
                    sum = B.get(x).get(y) - B.get(i-1).get(y) - B.get(x).get(j-1) + B.get(i-1).get(j-1);
                max = Long.max(max, sum);
            }
        }
        return max;
    }
}
