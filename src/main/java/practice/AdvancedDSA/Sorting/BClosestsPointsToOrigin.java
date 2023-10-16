package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class BClosestsPointsToOrigin {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(26, 41)));
        A.add(new ArrayList<>(Arrays.asList(40, 47)));
        A.add(new ArrayList<>(Arrays.asList(47, 7)));
        A.add(new ArrayList<>(Arrays.asList(50, 34)));
        A.add(new ArrayList<>(Arrays.asList(18, 28)));
        System.out.println(solve(A, 5));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

//        for (int i=0; i< A.size()-1; i++){
//            for (int j=i; j>=0; j--){
//                if (euclideanDistance(A.get(j)) > euclideanDistance(A.get(j+1))){
//                    swap(A, j, j+1);
//                }
//                else break;
//            }
//        }

        mergeSort(A,0, A.size()-1);

        for (int i=0; i<B; i++)
            result.add(A.get(i));
        return result;
    }

    public static double euclideanDistance(ArrayList<Integer> point){
        double distance;
        int a  = point.get(0);
        int b = point.get(1);
        distance = Math.sqrt((a*a) + (b*b));
        return distance;
    }

    public static void swap(ArrayList<ArrayList<Integer>> A, int p1, int p2) {
        ArrayList<Integer> temp = A.get(p2);
        A.set(p2, A.get(p1));
        A.set(p1, temp);
    }

    public static void mergeSort(ArrayList<ArrayList<Integer>> A, int s, int e) {
        if (s==e)
            return;
        int m = (s+e)/2;
        mergeSort(A, s, m);
        mergeSort(A, m+1, e);
        mergePartiallySortedArray(A, s, m, e);
    }

    public static void mergePartiallySortedArray(ArrayList<ArrayList<Integer>> A, int s, int m, int e) {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        int p1 = s;
        int p2 = m+1;

        while (p1<=m && p2<=e){
            if (euclideanDistance(A.get(p1)) <= euclideanDistance(A.get(p2))) {
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
