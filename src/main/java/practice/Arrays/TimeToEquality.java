package practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class TimeToEquality {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,4,1,3,2));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int max = 0;
        int sum = 0;
        for(int num : A){
            if (num > max)
                max = num;
        }
        for (int num : A){
            sum += max-num;
        }
        return sum;
    }
}
