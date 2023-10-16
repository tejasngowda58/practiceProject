package practice.AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
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
        System.out.println(solution(A));
    }

    public static ArrayList<Integer> solution(TreeNode A){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node!=null) {
                res.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.add(-1);
        }
        return res;
    }
}
