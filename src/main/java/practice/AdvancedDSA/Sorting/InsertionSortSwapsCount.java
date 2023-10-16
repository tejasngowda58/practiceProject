package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSortSwapsCount {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 3, 1, 9, 4));
        System.out.println(solve(A));
        for (int data: A){
            System.out.print(data);
            System.out.print(" ");
        }
    }

    public static int solve(ArrayList<Integer> A) {
        int count = 0;
        for (int i=0; i<A.size()-1; i++){
            for (int j=i; j>=0; j--){
                if (A.get(j) > A.get(j+1)){
                    swap(A, j, j+1);
                    count++;
                }
                else
                    break;
            }
        }
        return count;
    }

    public static void swap(ArrayList<Integer> A, int p1, int p2) {
        int temp = A.get(p2);
        A.set(p2, A.get(p1));
        A.set(p1, temp);
    }
}
