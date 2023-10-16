package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedSearch {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(7, 67, 133, 178,1 ));
        System.out.println(search(A, 1));
    }

    public static int search(final List<Integer> A, int B) {
        int l=0;
        int h= A.size()-1;
        int pivot = Integer.MIN_VALUE;
        if (A.size()==1){
            if (A.get(0) == B)
                return 0;
            return -1;
        }
        if (A.get(0)<A.get(1) && A.get(0)<A.get(A.size()-1))
            pivot=0;
        if (A.get(A.size()-1)<A.get(A.size()-2) && A.get(A.size()-1)<A.get(0))
            pivot=A.size()-1;
//        find pivot
        while (l<=h && pivot==Integer.MIN_VALUE) {
            int mid = (l+h)/2;
            if (A.get(mid) < A.get(mid-1) && A.get(mid) < A.get(mid+1)){
                pivot = mid;
                break;
            }
            if (A.get(mid) > A.get(0)){
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
//        Find pivot in first half of the seq.
        l=0;
        h=pivot-1;
        while (l<=h && h>=0){
            int mid = (l+h)/2;
            if (A.get(mid) == B){
                return mid;
            }
            else if (A.get(mid)>B)
                h=mid-1;
            else
                l=mid+1;
        }

        l=pivot;
        h= A.size()-1;
        while (l<=h){
            int mid = (l+h)/2;
            if (A.get(mid) == B){
                return mid;
            }
            else if (A.get(mid)>B)
                h=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
}
