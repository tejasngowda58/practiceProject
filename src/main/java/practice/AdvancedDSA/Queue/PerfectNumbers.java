package practice.AdvancedDSA.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
Given an integer A, you have to find the Ath Perfect Number.
A Perfect Number has the following properties:
It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 */
public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println(solve(8));
    }

    public static String solve(int A) {
        String one = "11";
        String two = "22";
        Queue<String> queue = new LinkedList<>();
        queue.add(one);
        queue.add(two);
        int count = 2;
        if (A==1)
            return one;
        else if (A==2)
            return two;
        else {
            while (count<A){
                String data = queue.remove();
                final int midLength = data.length() / 2;
                String mid1 = data.substring(0, midLength);
                String mid2 = data.substring(midLength);
                String firstData = mid1 + one + mid2;
                count++;
                if (count==A)
                    return firstData;
                queue.add(firstData);
                String secondData = mid1 + two + mid2;
                count++;
                if (count==A)
                    return secondData;
                queue.add(secondData);
            }
        }
        return "";
    }
}
