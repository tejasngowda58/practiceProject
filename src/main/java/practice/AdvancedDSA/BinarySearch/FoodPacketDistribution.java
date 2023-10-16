package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodPacketDistribution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(8, 7, 1, 5, 5, 10, 10, 1, 5, 3));
        System.out.println(solve(A, 17));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int l=1;
        int h = minOfArray(A);
        int ans = 0;
        long sumOfElements = sumOfElements(A);
        if (sumOfElements<B)
            return 0;
        while (l<=h){
            int mid = (l+h)/2;
            if (isPersonsValid(A, B, mid)){
                l=mid+1;
                ans = mid;
            }
            else {
                h=mid-1;
            }
        }
        return ans;
    }

    public static long sumOfElements(ArrayList<Integer> C){
        long sum = 0;
        for (int data: C){
            sum = sum + (long) data;
        }
        return sum;
    }

    public static boolean isPersonsValid(ArrayList<Integer> A, int B, int persons){
        long k=0;
        for (int i=0; i<A.size(); i++){
            k= k+ (long)(A.get(i)/persons);
        }
        if (k>=B)
            return true;
        else
            return false;
    }

    public static int minOfArray(ArrayList<Integer> A){
        int min = A.get(0);
        for (int val: A){
            min = Integer.min(min, val);
        }
        return min;
    }
}
