package practice.AdvancedDSA.Trees.Trees2.BST;

import practice.AdvancedDSA.Trees.TreeNode;

public class CheckIsBinaryTreeUsingInOrder {
    public static void main(String[] args) {
        TreeNode A10 = new TreeNode(10);
        TreeNode A5 = new TreeNode(5);
        TreeNode A20 = new TreeNode(20);
        TreeNode A2 = new TreeNode(2);
        TreeNode A7 = new TreeNode(7);
        TreeNode A22 = new TreeNode(22);
        A10.left = A20;
//        A10.right = A20;
//        A5.right = A7;
//        A5.left = A2;
//        A20.right = A22;
        if (checkTree(A10))
            System.out.println("Tree is a BST");
        else
            System.out.println("Tree is not a BST");
    }

    public static TreeNode prev = null;
    public static boolean checkTree(TreeNode root) {
        if (root == null)
            return true;

        Boolean lst = checkTree(root.left);
        if (prev!=null && prev.val>=root.val){
            prev=root;
            return false;
        }
        else{
            prev = root;
        }
        Boolean rst = checkTree(root.right);
        return lst&&rst;
    }

}
