package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSearch {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 ));
        int B = 10;
        System.out.println(searchRange(A, B));
    }

    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int startIndex = -1;
        int endIndex = -1;
        startIndex = lowerBound(A, B);
        endIndex = upperBound(A, B);
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(startIndex, endIndex));
        return result;
    }

    public static int lowerBound(final List<Integer> A, int B){
        int l= 0;
        int h=A.size()-1;
        int m=0;
        int startIndex = -1;
        while (l<=h){
            m = (l+h)/2;
            if (A.get(m) == B) {
                startIndex = m;
                h = m-1;
            }
            if (A.get(m) < B){
                l=m+1;
            }
            else
                h=m-1;
        }
        return startIndex;
    }

    public static int upperBound(final List<Integer> A, int B){
        int l= 0;
        int h=A.size()-1;
        int m=0;
        int endIndex = -1;

        while (l<=h){
            m = (l+h)/2;
            if (A.get(m) == B) {
                endIndex = m;
                l = m+1;
                continue;
            }
            if (A.get(m) < B){
                l=m+1;
            }
            else {
                h = m - 1;
                System.out.println("Inside else " + "m is " + m + "A[m] is " + A.get(m));
            }
            System.out.print("Arr[m] is" + A.get(m) + " ");
            System.out.println("h is " + h);
        }
        return endIndex;
    }
}
