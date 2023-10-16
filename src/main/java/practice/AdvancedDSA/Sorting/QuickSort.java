package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(18, 8, 6, 3, 11, 14, 23, 20, 31, 27));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 10, 2, 1, 5));
        quick(A, 0, A.size()-1);
        for (int data: A){
            System.out.print(data);
            System.out.print(" ");
        }
    }

    public static void quick(ArrayList<Integer> A, int s, int e){
        if (s>=e) return;
        int level = rearrange(A, s, e);
        quick(A, s, level-1);
        quick(A, level+1, e);
    }

    public static int rearrange(ArrayList<Integer> A, int s, int e){
        int p1 = s+1;
        int p2 = e;
        while (p1 <= p2) {
            if(A.get(p1) <= A.get(s))
                p1++;
            else if (A.get(p2) > A.get(s))
                p2--;
            else {
                swap(A, p1, p2);
                p1++;
                p2--;
            }
        }
        swap(A, s, p2);
        return p2;
    }

    public static void swap(ArrayList<Integer> A, int p1, int p2) {
        int temp = A.get(p2);
        A.set(p2, A.get(p1));
        A.set(p1, temp);
    }
}
