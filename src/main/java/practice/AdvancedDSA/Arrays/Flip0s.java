package practice.AdvancedDSA.Arrays;
/*
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN.
In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR.
By flipping, we mean changing character 0 to 1 and vice-versa.
Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R.
If there are multiple solutions, return the lexicographically smallest pair of L and R.
NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 */
import java.util.ArrayList;

public class Flip0s {
    public static void main(String[] args) {
        System.out.println(flip("111"));
    }

    public static ArrayList<Integer> flip(String A) {

        int FS = 0;
        int FE = 0;
        int TS = 0;
        int TE = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int onesCount= 0;

        for (int i=0; i<A.length(); i++) {
            int num = A.charAt(i) - 48;
            onesCount+=num;
            int val = num == 0 ? 1 : -1;
            sum+=val;
            if (max<sum){
                max= sum;
                FE = i;
                FS = TS;
            }
            if(sum<0){
                sum = 0;
                TS = i+1;
            }
            System.out.println(A.length());
            System.out.println("Sum " +sum);
            if(onesCount==A.length())
                return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(FS+1);
        res.add(FE+1);
        return res;
    }

    public static ArrayList<Integer> flip1(String A) {
        ArrayList<Integer> FArray = new ArrayList<>();
        ArrayList<Integer> NArray = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i=0; i<A.length(); i++){
            int num = A.charAt(i) - 48;
            NArray.add(num);
            int val = num == 0 ? 1 : -1;
//            System.out.println(val);
//            System.out.println("Max: " + max);
//            System.out.println("Max: " + max);
            sum+=val;
//            System.out.println("sum: " + sum);
            if (max<sum){
                max= sum;
                FArray = (ArrayList<Integer>) NArray.clone();
            }
            if (sum<0){
                sum=0;
                NArray = new ArrayList<>();
            }
        }
//        System.out.println(NArray);
        return FArray;
    }
}
