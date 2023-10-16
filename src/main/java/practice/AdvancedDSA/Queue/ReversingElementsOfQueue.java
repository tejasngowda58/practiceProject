package practice.AdvancedDSA.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReversingElementsOfQueue {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(solve(A, 3));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i=B-1; i>=0; i--)
            queue.add(A.get(i));

        while (!queue.isEmpty())
            res.add(queue.remove());

        for (int i=B; i<A.size(); i++)
            res.add(A.get(i));

        return res;
    }
}
