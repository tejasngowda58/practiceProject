package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumOfSquare {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println(solve(A, 2));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A, int B){
        int sum = 0;
        int max =Integer.MIN_VALUE;
        for (int i=0; i<B; i++){
            for (int j=0; j<B; j++){
                sum += A.get(i).get(j);
            }
        }

        for (int i=B; i<A.size(); i++){
            for (int j=B; j<A.get(i).size(); j++){
                for (int k=0; k<B;k++){
                    sum += A.get(i+k).get(j);
                }
                for (int k=0; k<B;k++){
                    sum -= A.get(i+k).get(j-B);
                }
                max = Integer.max(max, sum);
            }
            for (int k=0; k<B; k++){
                sum += A.get(i).get(k);
            }
            for (int k=0; k<B; k++){
                sum += A.get(i-B).get(k);
            }
            max = Integer.max(max, sum);
        }
        return sum;

//        for (int k=0; k<B; k++){
//            sum += A.get(i).get(j+k);
//        }
//
//        for (int k=0; k<B; k++){
//            sum += A.get(i-B).get(j+k);
//        }

        /*
        add(i)(j+0)
        add(i)(j+1)

        sub(i-B)(j+0)

         */

//        b=2
//        0 1 2 3 4
//
//        1 2 3 1
//        1 1 1 1
//        1 1 1 1
//        1 1 1 1

//        for (int k=0; k<B;k++){
//            sum += A.get(i+k)(j)
//        }
//        for (int k=0; k<B;k++){
//            sum -= A.get(i+k)(j-B)
//        }


        /*
        add a(i)(j)
        add a(i+1)(j)
        add a(i+2)(j)
         */
//        b = 3
//                n = 10;
//        0 1 2 3 4 5 6 7 8 9
//                10 - 3 -1;
//        length < N- B+1;
//
//        initial i=1;
//        subtract i-1
//                add i+B-1 (2)

    }

}
