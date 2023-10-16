package practice.AdvancedDSA.Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class MaxElementInSubArrayLengthK {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7));

        System.out.println(solution(A, 3));
    }

    public static ArrayList<Integer> solution(ArrayList<Integer> data, int k){
        ArrayList<Integer> result = new ArrayList<>();
        int kCount = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<data.size(); i++){
            if (deque.isEmpty())
                deque.addLast(data.get(i));
            else {
                while (!deque.isEmpty() && deque.peekLast()<data.get(i))
                    deque.removeLast();
                deque.addLast(data.get(i));
            }
            kCount++;
            if (kCount>=k){
                if ((kCount-k)>0 && data.get(i-k).equals(deque.peekFirst()))
                    deque.removeFirst();
                result.add(deque.peekFirst());
            }
        }
        return result;
    }
}
