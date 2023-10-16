package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArraysWithBitwiseOR1 {
    public static void main(String[] args) {
        int A = 3;
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,0,1,1));
        System.out.println(solution(A,B));
    }
    public static Long solution(int A, ArrayList<Integer> B){
        Long ans = 0L;
        int N=B.size();
        int i=0;
        while (i<N){
            if(B.get(i) == 1) {
                ans = ans + (N - i);
//                System.out.println("In if: " + (N - i));
            }
            else {
                int zerothIndex = i;
                while (zerothIndex<N && B.get(zerothIndex)==0){
                    zerothIndex++;
                }
                if (zerothIndex<N)
                    ans = ans + (N-zerothIndex);
            }
            i++;
        }
        return ans;
    }
}
