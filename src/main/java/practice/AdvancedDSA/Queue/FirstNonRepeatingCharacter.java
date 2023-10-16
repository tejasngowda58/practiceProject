package practice.AdvancedDSA.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * *Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
 * B is formed such that we have to find the first non-repeating character each time a character
 * is inserted to the stream and append it at the end to B. If no non-repeating character
 * is found, append '#' at the end of B.
 */
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(solve("abcabc"));
    }

    public static String solve(String A) {
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<A.length(); i++){
            Character dataChar = A.charAt(i);
            String data = dataChar.toString();
            map.put(data, map.getOrDefault(data, 0)+1);
            queue.add(data);
            while (!queue.isEmpty() && map.get(queue.peek())>1)
                queue.remove();
            if (!queue.isEmpty())
                result.append(queue.peek());
            else
                result.append("#");
        }
        return result.toString();
    }
}
