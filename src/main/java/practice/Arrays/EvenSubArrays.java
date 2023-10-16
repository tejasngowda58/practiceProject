package practice.Arrays;
/*
You are given an integer array A.
Decide whether it is possible to divide the array
into one or more subarrays of even length such that the first and last element of all subarrays will be even.
Return "YES" if it is possible; otherwise, return "NO" (without quotes).
 */

import java.util.ArrayList;

public class EvenSubArrays {
    public static void main(String[] args) {
        System.out.println();
    }

    public static String solve(ArrayList<Integer> A) {
        String YES = "YES";
        String NO = "NO";
        int length = 0;
        if(A.size()%2 !=0){
            return NO;
        }

        for (int i=0; i<A.size(); i++){
//            if ()
        }

        return YES;
    }
}
