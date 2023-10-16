package practice.AdvancedDSA.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 */
public class SingleNumber {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1));
        System.out.println(singleNumber(A));
    }

    public static int singleNumber(final List<Integer> A) {
        int result = 0;
        for (int num: A){
            result ^= num;
        }
        return result;
    }
}
