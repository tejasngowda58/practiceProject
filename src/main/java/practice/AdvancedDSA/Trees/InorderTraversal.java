package practice.AdvancedDSA.Trees;

import java.util.ArrayList;

public class InorderTraversal {
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
        System.out.println(inorderTraversal(A));
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(A, result);
        return result;
    }

    public static void traverse(TreeNode A, ArrayList<Integer> result) {
        if (A == null)
            return;
        traverse(A.left, result);
        result.add(A.val);
        traverse(A.right, result);
    }


}
