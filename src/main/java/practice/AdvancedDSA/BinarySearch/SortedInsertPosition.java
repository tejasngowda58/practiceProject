package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,3, 4, 6,8));
        System.out.println(searchInsert(A, 5));
    }

    public static int searchInsert(ArrayList<Integer> A, int B) {
        int l = 0;
        int h= A.size()-1;
        int m=0;

        while (l<=h){
            m = (l+h)/2;
            if (A.get(m)==B){
                return m;
            }
            if (A.get(m) < B)
                l=m+1;
            else
                h=m-1;
        }
        if (A.get(m)<B)
            return m+1;
        return m;
    }
}
