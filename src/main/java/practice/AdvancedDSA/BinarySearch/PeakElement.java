package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PeakElement {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        System.out.println(solve(A));

    }

    public static int solve(ArrayList<Integer> A) {
        if (A.size()==1)
            return A.get(0);
        int l=1;
        int h = A.size()-2;
        int m=0;
        if (A.get(0) >= A.get(1))
            return A.get(0);
        if (A.get(A.size()-1) >= A.get(A.size()-2))
            return A.get(A.size()-1);

        while (l<=h){
            m = (l+h)/2;
            if(A.get(m) >= A.get(m+1) && A.get(m) >= A.get(m-1)) {
                return A.get(m);
            }
            if (A.get(m)<A.get(m+1))
                l=m+1;
            else
                h=m-1;
        }
        return A.get(m);
    }
}
