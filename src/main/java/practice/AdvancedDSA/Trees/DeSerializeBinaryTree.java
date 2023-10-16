package practice.AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeSerializeBinaryTree {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1));
        TreeNode node = solution(data);
        ArrayList<Integer> integers = SerializeBinaryTree.solution(node);
        System.out.println(integers);
    }

    public static TreeNode solution(ArrayList<Integer> data) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(data.get(0));
        queue.add(root);

        for (int i=1; i< data.size();){
            TreeNode node = queue.remove();
            if (data.get(i)!=-1){
                TreeNode left = new TreeNode(data.get(i));
                node.left = left;
                queue.add(left);
            }
            else {
                node.left = null;
            }
            i++;

            if (data.get(i)!=-1){
                TreeNode right = new TreeNode(data.get(i));
                node.right = right;
                queue.add(right);
            }
            else {
                node.right = null;
            }
            i++;

        }
        return root;
    }
}
