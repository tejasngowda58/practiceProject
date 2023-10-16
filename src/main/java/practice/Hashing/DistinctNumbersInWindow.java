package practice.Hashing;

import java.util.*;

public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        ArrayList<Integer> A = new  ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
        System.out.println(dNums(A, 3));
    }
    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<B; i++){
            map.put(A.get(i), map.getOrDefault(A.get(i), 0)+1);
        }
        result.add(map.size());
        int removeElement = 0;
        int addElement = B;
        while (addElement<A.size()){
            map.put(A.get(addElement), map.getOrDefault(A.get(addElement), 0)+1);
            if (map.get(A.get(removeElement))>1){
                int val = map.get(A.get(removeElement))-1;
                map.put(A.get(removeElement), val);
            }
            else {
                map.remove(A.get(removeElement));
            }
            addElement++;
            removeElement++;
            result.add(map.size());
        }
        return result;
    }
}
