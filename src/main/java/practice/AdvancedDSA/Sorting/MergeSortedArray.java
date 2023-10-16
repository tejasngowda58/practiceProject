package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {
    public static void main(String[] args) {
        final ArrayList<Integer> A = new ArrayList<>(Arrays.asList( 4, 7, 9 ));
        final ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 11, 19));
        System.out.println(solve(A, B));
    }

    public static ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> C = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1<A.size() && p2<B.size()){
            if (A.get(p1) < B.get(p2)){
                C.add(A.get(p1));
                p1++;
            }
            else {
                C.add(B.get(p2));
                p2++;
            }
        }
        while (p1<A.size()){
            C.add(A.get(p1));
            p1++;
        }

        while (p2<B.size()){
            C.add(B.get(p2));
            p2++;
        }

        return C;
    }
}
