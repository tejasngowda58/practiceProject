package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AggressiveCows {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 17, 100, 11 ));
        System.out.println(solve(A, 2));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int l = findMinimum(A);
        int h = A.get(A.size()-1);
        int result = 0;
        while (l<=h){
            int mid = (l+h)/2;
            if (isDistanceValid(A, B, mid)){
                result = mid;
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return result;
    }

    public static int findMinimum(ArrayList<Integer> A){
        int diff=0;
        diff = A.get(1)-A.get(0);
        for (int i=2; i<A.size(); i++){
            int val = A.get(i) - A.get(i-1);
            if (diff>val)
                diff=val;
        }
        return diff;
    }

    public static boolean isDistanceValid(ArrayList<Integer> A, int B, int distance){
        int cowCount = 0;
        int sub = A.get(0);
        for (int i=1; i<A.size(); i++){
            int diff = A.get(i)-sub;
            if (diff>=distance){
                cowCount++;
                sub = A.get(i);
            }
        }
        if (cowCount < (B-1))
            return false;
        return true;
    }
}
