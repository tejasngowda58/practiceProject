package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralPrinting {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        solve(A);
    }

    public static void solve(ArrayList<ArrayList<Integer>> A){
        int k=0;
        int j=0;
        int i=0;
        int N = A.size()-1;
        while (N>0) {
            while (k < N) {
                System.out.println(A.get(i).get(j));
                k++;
                j++;
            }
            k = 0;
            while (k < N) {
                System.out.println(A.get(i).get(j));
                k++;
                i++;
            }
            k = 0;
            while (k < N) {
                System.out.println(A.get(i).get(j));
                k++;
                j--;
            }
            k = 0;
            while (k < N) {
                System.out.println(A.get(i).get(j));
                k++;
                i--;
            }
            i++;
            j++;
            N=N-2;
        }
        if (N==0){
            System.out.println(A.get(i).get(j));
        }
    }
}
