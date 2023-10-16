package practice.AdvancedDSA.Arrays.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllPossibleSubset {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collections.sort(A);
        System.out.println(subsets(A));
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tempArray = new ArrayList<>();
        generateSubsets(A, tempArray, 0, A.size(), result);
        Collections.sort(result , (l1 , l2) -> resultNonDescendingOrder(l1 , l2));
        return result;
    }

    public static void generateSubsets(ArrayList<Integer> input, ArrayList<Integer> tempArray, int index, int inputLength, ArrayList<ArrayList<Integer>> result){
        if (inputLength==index){
            ArrayList<Integer> subset = new ArrayList<>();
            for (int i=0; i< tempArray.size(); i++){
                subset.add(tempArray.get(i));
            }
            result.add(subset);
            return;
        }
        tempArray.add(input.get(index));
        generateSubsets(input, tempArray, index+1, inputLength, result);
        tempArray.remove(input.get(index));
        generateSubsets(input, tempArray, index+1, inputLength, result);
    }

    public static int resultNonDescendingOrder(List<Integer> l1 , List<Integer> l2){
        for(int i = 0 ; i < l1.size() &&  i < l2.size() ; i++){
            if(l1.get(i) < l2.get(i)){
                return -1;
            }
            if(l1.get(i) > l2.get(i)){
                return  1;
            }
        }
        if(l1.size() < l2.size()){
            return  -1;
        }else{
            return 1;
        }

    }
}
