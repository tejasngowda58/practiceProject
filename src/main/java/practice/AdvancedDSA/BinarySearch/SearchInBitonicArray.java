package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInBitonicArray {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5,15, 17,101,105, 100, 11));
        System.out.println(solve(A, 11));
    }

    public static int solve(ArrayList<Integer> A, int B) {
//  Step 1: Find the peak of the bitonic array
        int l=0;
        int h=A.size()-1;
        int peak=0;
        while (l<=h){
            int mid = (l+h)/2;
            if (A.get(mid)>A.get(mid-1) && A.get(mid)>A.get(mid+1)){
                peak = mid;
                break;
            }
            if (A.get(mid)>A.get(mid-1)){
                l=mid+1;
            }
            else
                h=mid-1;
        }

        if (A.get(peak)==B)
            return peak;
        if (A.get(peak)<B)
            return -1;
//  Step 2: Search for the value in ascending part of the array
        l=0;
        h=peak;
        while (l<=h){
            int mid = (l+h)/2;
            if (A.get(mid) == B){
                return mid;
            }
            else if (A.get(mid) < B){
                l=mid+1;
            }
            else
                h=mid-1;
        }

//        Step3: Search in descending part of the array
        l=peak+1;
        h=A.size()-1;
        while (l<=h){
            int mid = (l+h)/2;
            if (A.get(mid) == B){
                return mid;
            }
            else if (A.get(mid) > B)
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }


}
