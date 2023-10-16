package practice.AdvancedDSA.Trees.Trees2.BST;

import practice.AdvancedDSA.Trees.TreeNode;

public class CheckIsBSTUsingPreOrder {
    public static void main(String[] args) {
        TreeNode A10 = new TreeNode(10);
        TreeNode A5 = new TreeNode(5);
        TreeNode A20 = new TreeNode(20);
        TreeNode A2 = new TreeNode(2);
        TreeNode A7 = new TreeNode(7);
        TreeNode A22 = new TreeNode(22);
        A10.left = A5;
        A10.right = A20;
        A5.right = A7;
        A5.left = A2;
        A20.right = A22;

        TreeNode A6 = new TreeNode(6);
        TreeNode A9 = new TreeNode(9);
        TreeNode A4 = new TreeNode(4);
        TreeNode A8 = new TreeNode(8);
        TreeNode A3 = new TreeNode(3);
        A6.left = A9;
        A6.right = A4;
        A4.right = A8;
        A8.left = A3;
        System.out.println(isValidBST(A10));
    }
    public static int isValidBST(TreeNode A) {
        if (isValid(A, Long.MIN_VALUE, Long.MAX_VALUE))
            return 1;
        return 0;
    }
    public static boolean isValid(TreeNode A, long l, long r) {
        if (A == null)
            return true;
        if (A.val > l && A.val < r) {
            boolean left = isValid(A.left, l, A.val);
            boolean right = isValid(A.right, A.val, r);
            return (left && right);
        } else
            return false;
    }
}