package practice.AdvancedDSA.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NIntegersContaining123 {
    public static void main(String[] args) {
        System.out.println(solve(15));
    }

    public static ArrayList<Integer> solve(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int count = 3;
        if (A<=3){
            int val=0;
            while (val<A){
                val++;
                res.add(val);
            }
            return res;
        }
        res.add(1);
        res.add(2);
        res.add(3);

        while (count<A){
            int data = queue.remove();
            int first = data*10+1;
            res.add(first);
            queue.add(first);
            count++;
            if (count==A){
                return res;
            }
            int second = data*10+2;
            res.add(second);
            queue.add(second);
            count++;
            if (count==A){
                return res;
            }
            int third = data*10+3;
            res.add(third);
            queue.add(third);
            count++;
            if (count==A){
                return res;
            }
        }
        return res;
    }
}
