package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndKthSmallestElement {
    public static void main(String[] args) {
        final ArrayList<Integer> A = new ArrayList<>(Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 ));
        int B = 9;
        System.out.println(kthsmallest(A, B));
    }

    public static int kthsmallest(final List<Integer> A, int B) {
        for (int i=0; i< B; i++){
            int min = A.get(i);
            int minPos = i;
            for (int j=i; j<A.size(); j++){
                if (min> A.get(j)) {
                    min = A.get(j);
                    minPos = j;
                }
            }
            swap(A, i, minPos);
        }
        return A.get(B-1);
    }

    public static void swap(final List<Integer> A, int p1, int p2) {
        int temp = A.get(p1);
        A.set(p1, A.get(p2));
        A.set(p2, temp);
    }

}
