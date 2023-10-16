package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergePartiallySortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4,8,-1, 2, 6, 9, 11, 3, 4, 7, 13, 0));
        System.out.println(solve(A, 2, 6, 9));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int s, int m, int e) {
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

        return A;
    }
}
