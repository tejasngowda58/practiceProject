package practice.AdvancedDSA.Queue;

import java.util.*;
import java.util.Queue;

public class SumOfMinMax {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 5, -1, 7, -3, -1, -2));
        System.out.println(sumOfMinimums(A, 4));
        System.out.println(sumOfMaximums(A, 4));
        System.out.println(solve(A, 4));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        long minimumSum = sumOfMinimums(A, B);
        long maximumSum = sumOfMaximums(A, B);
        long mod = 1000*1000*1000+7;
        return (int) ((((maximumSum%mod)+(minimumSum%mod))%mod) + mod);
    }

    public static long sumOfMinimums(ArrayList<Integer> data, int B) {
        Deque<Integer> deque = new ArrayDeque<>();
        int kCount = 0;
        long minSum = 0;
        long mod = 1000*1000*1000+7;
        for (int i=0; i<data.size(); i++){
            if (deque.isEmpty()) {
                deque.add(data.get(i));
                kCount++;
            }
            else {
                while (!deque.isEmpty() && deque.peekLast()>data.get(i))
                    deque.removeLast();
                deque.add(data.get(i));
                kCount++;
            }
            if (kCount>=B){
                if ((kCount-B)>0 && data.get(i-B).equals(deque.peekFirst()))
                    deque.removeFirst();
                minSum = (((minSum%mod) + (deque.peekFirst()%mod))%mod);
            }
        }
        return minSum;
    }

    public static long sumOfMaximums(ArrayList<Integer> data, int B) {
        Deque<Integer> deque = new ArrayDeque<>();
        int kCount = 0;
        long maxSum = 0;
        long mod = 1000*1000*1000+7;
        for (int i=0; i<data.size(); i++){
            if (deque.isEmpty()) {
                deque.add(data.get(i));
                kCount++;
            }
            else {
                while (!deque.isEmpty() && deque.peekLast()<data.get(i))
                    deque.removeLast();
                deque.add(data.get(i));
                kCount++;
            }
            if (kCount>=B){
                if ((kCount-B)>0 && data.get(i-B).equals(deque.peekFirst()))
                    deque.removeFirst();
                maxSum = ((maxSum%mod) + (deque.peekFirst()%mod))%mod;
            }
        }
        return maxSum;
    }
}
