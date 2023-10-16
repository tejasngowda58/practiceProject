package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumOfSubMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(-6, -21, 27, 19, 19)));
        A.add(new ArrayList<>(Arrays.asList(0, 0, 5, -21, 19)));
        A.add(new ArrayList<>(Arrays.asList(18, -27, -2, -7, 13)));
        A.add(new ArrayList<>(Arrays.asList(-21, -17, -25, -1, 3)));
        A.add(new ArrayList<>(Arrays.asList(0, -9, -6, -16, -5)));
        A.add(new ArrayList<>(Arrays.asList(29, 9, -25, -7, -25)));
        B.add(new ArrayList<>(Arrays.asList(-6, -13)));
        B.add(new ArrayList<>(Arrays.asList(-19, -18)));
        System.out.println(solve(B));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A){
        int max = Integer.MIN_VALUE;
        for (int i=0; i<A.size(); i++){
            for (int j=1; j<A.get(0).size(); j++){
                A.get(i).set(j, A.get(i).get(j-1)+A.get(i).get(j));
            }
        }
        for(int i=0; i<A.get(0).size(); i++){
            for (int j=1; j<A.size(); j++){
                A.get(j).set(i, A.get(j-1).get(i) + A.get(j).get(i));
            }
        }

//        int x = A.size()-1;
//        int y = A.get(0).size()-1;

        for (int x=0; x<A.size(); x++) {
            for (int y=0; y<A.get(0).size(); y++) {
                for (int i = 0; i < A.size(); i++) {

                    for (int j = 0; j < A.get(0).size(); j++) {

                        if(i<=x && j<=y) {
                            int sum = 0;
//                            System.out.println("x:"+ x + " y:"+y+" i:"+i+" j:"+j);
                            if (i == 0 && j == 0)
                                sum = A.get(x).get(y);
                            if (j == 0 && i > 0)
                                sum = A.get(x).get(y) - A.get(i - 1).get(y);
                            if (i == 0 && j > 0)
                                sum = A.get(x).get(y) - A.get(x).get(j - 1);
                            if (j > 0 && i > 0)
                                sum = A.get(x).get(y) - A.get(i - 1).get(y) - A.get(x).get(j - 1) + A.get(i - 1).get(j - 1);
//                            System.out.println(sum);
                            max = Integer.max(max, sum);
                        }
                    }
                }
            }
        }
return max;
    }
}
