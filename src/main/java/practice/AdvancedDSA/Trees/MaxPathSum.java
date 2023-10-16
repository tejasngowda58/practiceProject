package practice.AdvancedDSA.Trees;

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode A1 = new TreeNode(1);
        TreeNode A2 = new TreeNode(2);
        TreeNode A3 = new TreeNode(3);
        TreeNode A4 = new TreeNode(4);
        TreeNode A5 = new TreeNode(5);
        A1.left=A2;
        A2.left=A3;
        A2.right=A4;
        maxPathSum(A1);
        System.out.println(maxValue);
    }
    public static int maxValue = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root==null)
            return 0;
        int lst = maxPathSum(root.left);
        int rst = maxPathSum(root.right);
        lst = Math.max(0, lst);
        rst = Math.max(0, rst);
        maxValue = Math.max(maxValue, (root.val + lst + rst));
//        return root.val+Math.max(lst, rst);
        return Math.max(lst+root.val,+rst+root.val);
    }
}
