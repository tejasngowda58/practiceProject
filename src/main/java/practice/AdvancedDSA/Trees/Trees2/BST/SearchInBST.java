package practice.AdvancedDSA.Trees.Trees2.BST;

import practice.AdvancedDSA.Trees.TreeNode;

public class SearchInBST {
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
        if (isBST(A10, 20))
            System.out.println("Present");
        else
            System.out.println("Absent");
    }

    public static boolean isBST(TreeNode root, int k){
        TreeNode temp = root;

        while (temp!=null){
            if (temp.val==k)
                return true;
            else if (k<temp.val)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return false;
    }
}
