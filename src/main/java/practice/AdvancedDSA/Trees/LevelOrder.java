package practice.AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
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
        System.out.println(solve(A));
    }

    public static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A!=null) {
            queue.add(A);
            queue.add(null);
            result.add(new ArrayList<>());
        }
        while (queue.size()>1) {
            TreeNode data = queue.remove();
            if (data != null) {
                if (data.left!=null)
                    queue.add(data.left);
                if (data.right!=null)
                    queue.add(data.right);
                result.get(result.size()-1).add(data.val);
            }
            else {
                if (queue.size()!=0)
                    result.add(new ArrayList<>());
                queue.add(null);
            }
        }
        return result;
    }
}
