package practice.AdvancedDSA.Stack;

import java.util.*;

public class LargestRectangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(0,0, 1, 1)));
//        A.add(new ArrayList<>(Arrays.asList(1,1, 1, 0)));
//        A.add(new ArrayList<>(Arrays.asList(1,1, 1, 1)));
//        A.add(new ArrayList<>(Arrays.asList(1,1, 1, 0)));
        System.out.println(solution(A));
        System.out.println(lowerTowardsLeft(new ArrayList<>(Arrays.asList(4,5,8,3,2,4, 6,1,1))));
        System.out.println(lowerTowardsRight(new ArrayList<>(Arrays.asList(4,5,8,3,2,4, 6,1,1))));

        //        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
    }

    public static int solution(ArrayList<ArrayList<Integer>> data){
        int[] level = new int[data.get(0).size()];
        ArrayList<Integer> lowerTowardsLeft = new ArrayList<>();
        ArrayList<Integer> lowerTowardsRight = new ArrayList<>();
        int ans = 0;
        for (int i=0; i<data.size(); i++){
            for (int j=0; j<data.get(0).size(); j++){
                if (!data.get(i).get(j).equals(0))
                    level[j]++;
                else
                    level[j] = 0;
            }

            ArrayList<Integer> levelsList = new ArrayList<>();
            for (int value: level)
                levelsList.add(value);
            lowerTowardsLeft = lowerTowardsLeft(levelsList);
            lowerTowardsRight = lowerTowardsRight(levelsList);
            for (int k=0; k<levelsList.size(); k++){
                ans = Math.max(ans, (lowerTowardsRight.get(k)-lowerTowardsLeft.get(k)-1)*levelsList.get(k));
            }
        }
        return ans;
    }

    private static ArrayList<Integer> lowerTowardsLeft(ArrayList<Integer> data){
        ArrayList<Integer> lowerTowardsLeft = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<data.size(); i++){
            while (!stack.isEmpty() && data.get(i)<=data.get(stack.peek()))
                stack.pop();
            if (!stack.empty())
                lowerTowardsLeft.add(stack.peek());
            else
                lowerTowardsLeft.add(-1);
            stack.add(i);
        }
        return lowerTowardsLeft;
    }

    private static ArrayList<Integer> lowerTowardsRight(ArrayList<Integer> data){
        ArrayList<Integer> lowerTowardsRight = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=data.size()-1; i>=0; i--){
            while (!stack.empty() && data.get(i)<=data.get(stack.peek()))
                stack.pop();
            if (!stack.empty())
                lowerTowardsRight.add(stack.peek());
            else
                lowerTowardsRight.add(data.size());
            stack.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=lowerTowardsRight.size()-1; i>=0; i--)
            result.add(lowerTowardsRight.get(i));
        return result;
    }
}
