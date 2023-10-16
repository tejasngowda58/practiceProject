package practice.AdvancedDSA.Trees.Trees2;

import HackerRank.scaler.AdvancedDSA.Trees.TreeNode;
import practice.AdvancedDSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
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

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        result.add(A.val);

        while (queue.size()>1){
            TreeNode node = queue.remove();
            if (node!=null){
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            else {
                queue.add(null);
                TreeNode peek = queue.peek();
                result.add(peek.val);
            }
        }
        return result;
    }
}
