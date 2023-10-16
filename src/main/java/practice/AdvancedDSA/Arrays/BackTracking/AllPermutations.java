package practice.AdvancedDSA.Arrays.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPermutations {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(permute(A));
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tempArray = new ArrayList<>();
        generatePermutations(A, tempArray, 0, A.size(), result);
        return result;
    }

    public static void generatePermutations(ArrayList<Integer> inputArray, ArrayList<Integer> tempArray, int index, int inputLength, ArrayList<ArrayList<Integer>> result) {
        if (index==inputLength){
            ArrayList<Integer> subset = new ArrayList<>();
            for (int i=0; i< inputArray.size(); i++){
                subset.add(inputArray.get(i));
            }
            result.add(subset);
            return;
        }
        for (int i=index; i< inputArray.size(); i++){
            swap(index, i, inputArray);
            generatePermutations(inputArray, tempArray, index+1, inputLength, result);
            swap(index, i, inputArray);
        }
    }

    public static void swap(int a, int b, ArrayList<Integer> arrayList){
        int temp = arrayList.get(a);
        arrayList.set(a, arrayList.get(b));
        arrayList.set(b, temp);
    }
}
