package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class ImpRev {
    static int count = 0;
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2000000000, 2000000000, -2000000000));
        impRev(A, 0, A.size()-1);
        System.out.println(count);
        System.out.println(A);
        System.out.println(2*2000000000);
    }

    public static void impRev(ArrayList<Integer> A, int start, int end){
        if (start==end)
            return;
        int mid = (start+end)/2;
        impRev(A, start, mid);
        impRev(A, mid+1, end);
        merge(A, start,mid, end);
    }

    public static void merge(ArrayList<Integer> A, int start, int mid, int end){
        int p1 = start;
        int p2 = mid+1;
        ArrayList<Integer> res = new ArrayList<>();

        while (p1<=mid && p2<=end){
            long a = A.get(p1);
            long b = A.get(p2);
            if (a > 2*b){
                count += (mid - p1 + 1);
                p2++;
            }
            else{
                p1++;
            }
        }

        p1 = start;
        p2 = mid+1;

        while (p1<=mid && p2<=end){
            if (A.get(p1) > A.get(p2)){
                res.add(A.get(p2));
                p2++;
            }
            else {
                res.add(A.get(p1));
                p1++;
            }
        }

        while (p1<=mid){
            res.add(A.get(p1));
            p1++;
        }
        while (p2<=end){
            res.add(A.get(p2));
            p2++;
        }

        for (int i=0; i< res.size(); i++)
            A.set(start+i, res.get(i));
    }
}
