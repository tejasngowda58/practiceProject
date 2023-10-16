package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4,8,-1, 2, 6, 9, 11, 3, 4, 7, 13, 0));
        mergeSort(A, 0, A.size()-1);
        System.out.println(A);
    }

    public static void mergeSort(ArrayList<Integer> A, int s, int e) {
        if (s==e)
            return;
        int m = (s+e)/2;
        mergeSort(A, s, m);
        mergeSort(A, m+1, e);
        mergePartiallySortedArray(A, s, m, e);
    }

    public static void mergePartiallySortedArray(ArrayList<Integer> A, int s, int m, int e) {
        ArrayList<Integer> temp = new ArrayList<>();
        int p1 = s;
        int p2 = m+1;

        while (p1<=m && p2<=e){
            if (A.get(p1) <= A.get(p2)) {
                temp.add(A.get(p1));
                p1++;
            }
            else {
                temp.add(A.get(p2));
                p2++;
            }
        }
        while (p1<=m){
            temp.add(A.get(p1));
            p1++;
        }
        while (p2<=e){
            temp.add(A.get(p2));
            p2++;
        }

        for (int i=s; i<=e; i++){
            A.set(i, temp.get(i-s));
        }
    }
}
