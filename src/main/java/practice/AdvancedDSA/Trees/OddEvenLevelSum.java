package practice.AdvancedDSA.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * *Given a binary tree of integers.
 * * Find the difference between the sum of nodes at odd level and sum of nodes at even level.
 */
public class OddEvenLevelSum {
    public static void main(String[] args) {
        TreeNode A1 = new TreeNode(1);
        TreeNode A2 = new TreeNode(2);
        TreeNode A3 = new TreeNode(3);
        TreeNode A4 = new TreeNode(4);
        TreeNode A5 = new TreeNode(5);
        TreeNode A6 = new TreeNode(6);
        TreeNode A7 = new TreeNode(7);
        TreeNode A8 = new TreeNode(8);
        A1.left = A2;
        A1.right = A3;
        A2.left = A4;
        A2.right = A5;
        A3.left = A6;
        A3.right = A7;
        A4.right = A8;
        System.out.println(solve(A1));
    }

    public static int solve(TreeNode A){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        boolean flag = true;
        int oddSum = 0;
        int evenSum = 0;
        while (queue.size()>1){
            TreeNode node = queue.remove();
            if (node==null) {
                queue.add(null);
                flag = !flag;
            }
            else {
                if (flag)
                    oddSum += node.val;
                else
                    evenSum += node.val;
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
        }
        return oddSum-evenSum;
    }
}
