package practice.MatrixArray;

import java.util.ArrayList;

public class SpiralFilling {
    public static void main(String[] args) {
        System.out.println(solve(5));
    }
    public static ArrayList<ArrayList<Integer>> solve(int A){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<A; i++){
            res.add(new ArrayList<>());
            for (int j=0; j<A; j++){
                res.get(i).add(0);
            }
        }
        
        int data = 1;
        int k=0;
        int j=0;
        int i=0;
        int N = A-1;
        while (N>0) {
            while (k < N) {
                res.get(i).remove(j);
                res.get(i).add(j, data);
                data++;
                k++;
                j++;
            }
            k = 0;
            while (k < N) {
                res.get(i).remove(j);
                res.get(i).add(j, data);
                data++;
                k++;
                i++;
            }
            k = 0;
            while (k < N) {
                res.get(i).remove(j);
                res.get(i).add(j, data);
                data++;
                k++;
                j--;
            }
            k = 0;
            while (k < N) {
                res.get(i).remove(j);
                res.get(i).add(j, data);
                data++;
                k++;
                i--;
            }
            i++;
            j++;
            N=N-2;
            k=0;
        }
        if (N==0){
            res.get(i).remove(j);
            res.get(i).add(j, data);
        }
        return res;
    }
}
