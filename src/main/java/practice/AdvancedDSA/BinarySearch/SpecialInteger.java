package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialInteger {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        System.out.println(solve(A, 130));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int result = 0;
        int l=0;
        int h=A.size()-1;
        while (l<=h){
            int mid=(l+h)/2;
            if (maxSumOfSubArrayOfLengthK(A,mid) <= B){
                result = mid;
                l = mid+1;
            }
            else {
                h = mid-1;
            }
        }
        return result;
    }
    private static long maxSumOfSubArrayOfLengthK(ArrayList<Integer> A, int k){
        long sum =0;
        for (int i=0; i<k; i++)
            sum += A.get(i);

        long max = sum;
        for (int i=k; i< A.size(); i++){
            sum -= A.get(i-k);
            sum += A.get(i);

            if (max<sum)
                max = sum;
        }
        return max;
    }
}
