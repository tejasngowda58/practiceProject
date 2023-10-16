package practice.MatrixArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class AntiDiagonals {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println(solve(A));
    }
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int N = 2*(A.size()-1);
        for (int j=0; j<A.size(); j++){
            result.add(new ArrayList<>());
            int i=0;
            int c = j;
            while (i<A.size() && c >=0){
                result.get(j).add(i, A.get(i).get(c));
                i++;
                c--;
            }
            int zeroes = j;
            while (zeroes < A.size()-1){
                result.get(j).add(0);
                zeroes++;
            }
        }

        for (int i=1, resultSize = A.size(); i<A.size(); i++, resultSize++){
            result.add(new ArrayList<>());
//            int resultSize = A.size();
            int r = i;
            int j = A.size()-1;
            while (r<A.size() && j>=0){
                result.get(resultSize).add(A.get(r).get(j));
                r++;
                j--;
//                resultSize++;
            }
            int zeroes = result.get(resultSize).size();
            while (zeroes < A.size()){
                result.get(resultSize).add(0);
                zeroes++;
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2 * l - 1; ++i) {
            int offset = i < l ? 0 : i - l + 1;
            ArrayList<Integer> row = new ArrayList<Integer>();
            int k=0;
            for (int j = offset; j <= i - offset; ++j) {
                row.add(A.get(j).get(i - j));
                k++;
            }
            for(int j = k; j< l ;j++){
                row.add(0);
            }
            res.add(row);
        }
        return res;
    }
}
