package practice.AdvancedDSA.Trees.Trees2.BST;

import practice.AdvancedDSA.Trees.TreeNode;

/**
 * Using post order traversal i.e., left, right, root and coming from bottom to up
 * Find max value of LSt and min of RST, the root node value should be greater than
 * max value of LST and less than min of RST
 * *
 */
public class CheckTreeIsBSTUsingPostOrder {
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

        if (checkTree(A6).isBST)
            System.out.println("Tree is a BST");
        else
            System.out.println("Tree is not a BST");
    }


    public static TreeInfo checkTree(TreeNode root) {
        if (root == null){
            return new TreeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }

        TreeInfo leftSubTree = checkTree(root.left);
        TreeInfo rightSubTree = checkTree(root.right);

        if (leftSubTree.isBST==true && rightSubTree.isBST==true &&
                root.val> leftSubTree.max && root.val< rightSubTree.min){
            return new TreeInfo(Math.max(rightSubTree.max, root.val),
                    Math.min(leftSubTree.min, root.val), true);
        }
        return new TreeInfo(Integer.max(rightSubTree.max, root.val),
                Integer.min(leftSubTree.min, root.val), false);
    }

    static class TreeInfo {
        public int max;
        public int min;
        public boolean isBST;
        public TreeInfo(int max, int min, boolean isBST){
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
}
