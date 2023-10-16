package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class InversionSort {
    static int count = 0;
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2697, 1073, 3424, 197, 394, 4034, 2380, 3591, 3243, 1157, 1530, 3252, 4454, 2742, 725, 2066, 2242, 838, 1749, 1013, 2836, 2654));
//        mergePartiallySortedArray(A, 0, 2, A.size()-1);
        sort(A, 0, A.size()-1);
        System.out.println("count is " + count);
        for (int data: A){
            System.out.print(data);
            System.out.print(" ");
        }
    }

    public static void sort(ArrayList<Integer> A, int start, int end){
        if(start==end)
            return;
        int mid = (start+end)/2;
        sort(A, start, mid);
        sort(A, mid+1, end);
        mergePartiallySortedArray(A, start, mid, end);
    }

    public static void mergePartiallySortedArray(ArrayList<Integer> A, int start, int middle, int end){
        int p1 = start;
        int p2 = middle+1;
        int mod = (int) Math.pow(10, 9) + 7;
        ArrayList<Integer> res = new ArrayList<>();
        while (p1<=middle && p2<=end){
            if (A.get(p1) <= A.get(p2)){
                res.add(A.get(p1));
                p1++;
            }
            else {
                count = count + middle - p1 + 1;
                count = count%mod;
                res.add(A.get(p2));
                p2++;
            }
        }

        while (p1<=middle){
            res.add(A.get(p1));
            p1++;
        }
        while (p2<=end){
            res.add(A.get(p2));
            p2++;
        }

        for (int i=start; i<=end; i++){
            A.set(i, res.get(i-start));
        }
    }
}
