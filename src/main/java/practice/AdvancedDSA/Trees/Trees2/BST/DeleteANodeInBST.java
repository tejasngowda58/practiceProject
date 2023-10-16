package practice.AdvancedDSA.Trees.Trees2.BST;

import practice.AdvancedDSA.Trees.LevelOrder;
import practice.AdvancedDSA.Trees.TreeNode;

public class DeleteANodeInBST {
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
        delete(A10, 5);
        System.out.println(LevelOrder.solve(A10));
    }

    public static TreeNode delete(TreeNode root, int B) {
        if (root == null)
            return null;
        if (B < root.val)
            root.left = delete(root.left, B);
        else if (B> root.val)
            root.right = delete(root.right, B);
        else {
            if (root.right==null && root.left==null)
                return null;
            else if (root.left==null)
                return root.right;
            else if (root.right==null)
                return root.left;
            else {
                TreeNode toBeReplaced = findMaxNodeToBeReplaced(root.left);
                root.val = toBeReplaced.val;
                root.left = delete(root.left, toBeReplaced.val);
            }
        }
        return root;
    }

    private static TreeNode findMaxNodeToBeReplaced(TreeNode node) {
        while (node.right!=null)
            node = node.right;
        return node;
    }
}
