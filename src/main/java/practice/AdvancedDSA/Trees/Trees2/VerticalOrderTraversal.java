package practice.AdvancedDSA.Trees.Trees2;

import HackerRank.scaler.AdvancedDSA.Trees.TreeNode;
import practice.AdvancedDSA.Trees.TreeNode;
import practice.scaler.AdvancedDSA.Trees.TreeNode;

import java.util.*;

//import javafx.util.Pair;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        TreeNode A9 = new TreeNode(9);
        TreeNode A20 = new TreeNode(20);
        TreeNode A15 = new TreeNode(15);
        TreeNode A7 = new TreeNode(7);
        A.left = A9;
        A.right = A20;
        A20.left =A15;
        A20.right = A7;
        System.out.println(verticalOrderTraversal(A));
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<AbstractMap.SimpleEntry<Integer, TreeNode>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(0, A));
        int minLevel = 0;
        int maxLevel = 0;
        while (!queue.isEmpty()){
            AbstractMap.SimpleEntry<Integer, TreeNode> pair = queue.remove();
            if (map.get(pair.getKey())!=null){
                map.get(pair.getKey()).add(pair.getValue().val);
            }
            else {
                map.put(pair.getKey(), new ArrayList<>(Arrays.asList(pair.getValue().val)));
            }
            if (pair.getValue().left!=null) {
                int leftLevel = pair.getKey()-1;
                minLevel = Math.min(leftLevel, minLevel);
                AbstractMap.SimpleEntry<Integer, TreeNode> left = new AbstractMap.SimpleEntry<>(leftLevel, pair.getValue().left);
                queue.add(left);
            }
            if (pair.getValue().right!=null) {
                int rightLevel = pair.getKey()+1;
                maxLevel = Math.max(rightLevel, maxLevel);
                AbstractMap.SimpleEntry<Integer, TreeNode> right = new AbstractMap.SimpleEntry<>(rightLevel, pair.getValue().right);
                queue.add(right);
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i=minLevel; i<=maxLevel; i++){
            res.add(map.get(i));
        }
        return res;
    }
}
