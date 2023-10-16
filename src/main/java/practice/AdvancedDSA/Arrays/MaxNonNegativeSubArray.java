package practice.AdvancedDSA.Arrays;
/*
Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
Find and return the required subarray.
NOTE:
    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671));
        System.out.println(maxset(A));
        System.out.println(maxset1(A));
    }
    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long max = Integer.MIN_VALUE;
        long sum = 0l;
        int fS=0, fE=0, tS=0, tE=0;
        int i =0;
        while (i<A.size()){
            if (A.get(i)>=0){
                sum += A.get(i);
            }
            else {
                tE = i-1;
                if (max<sum){
                    max = sum;
                    fS = tS;
                    fE = tE;
                }
                else if(max==sum){
                    if((fE-fS)<(tE-tS)) {
                        fS = tS;
                        fE = tS;
                    }
                }
                tS = i+1;
                sum = 0;
            }
            if(i==A.size()-1){
                tE = i;
                if (sum>max) {
                    fS = tS;
                    fE = tE;
                }
            }
            else if(max==sum){
                if((fE-fS)<(tE-tS)) {
                    fS = tS;
                    fE = tS;
                }
            }
            i++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int j=fS; j<=fE; j++) {
            if (A.get(j) <0)
                break;
            res.add(A.get(j));
        }
        return res;
    }

    public static ArrayList<Integer> maxset1(ArrayList<Integer> A) {
        long max = Integer.MIN_VALUE;
        long sum = 0l;
        ArrayList<Integer> FArray = new ArrayList<>();
        ArrayList<Integer> NArray = new ArrayList<>();

        for (int num: A){
            if(num>=0){
                sum += num;
                NArray.add(num);
            }
            else {
                if (max<sum){
                    max = sum;
                    FArray = NArray;
                }
                else if(max==sum){
                    if (NArray.size()>FArray.size()) {
                        FArray = NArray;
                    }
                }
                sum = 0;
                NArray = new ArrayList<>();
            }
        }

        if (max<sum){
            FArray = NArray;
        }
        else if (max == sum && NArray.size() > FArray.size())
            FArray = NArray;
        return  FArray;
    }

    public ArrayList<Integer> maxset2(ArrayList<Integer> a) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (Integer i : a) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<Integer>();
            }
            if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }
}
