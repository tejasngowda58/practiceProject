package practice.AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {
    public static void main(String[] args) {
        TreeNode A1 = new TreeNode(1);
        TreeNode A2 = new TreeNode(2);
        TreeNode A3 = new TreeNode(3);
        TreeNode A4 = new TreeNode(4);
        TreeNode A5 = new TreeNode(5);
        A1.left=A2;
        A1.right=A3;
        A2.left=A4;
        A2.right=A5;
        ArrayList<ArrayList<Integer>> result = zigzagLevelOrder(A1);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size()>1){
            TreeNode node = queue.remove();
            if (node==null){
                //  change flag state to modify insertion order. i.e. to put to stack or array
                queue.add(null);
                if (flag){
                    ArrayList arrayList1 = (ArrayList) arrayList.clone();
                    result.add(arrayList1);
                    arrayList = new ArrayList<>();
                }
                else {
                    ArrayList arrayList1 = new ArrayList();
                    while (!stack.isEmpty()){
                        arrayList1.add(stack.pop());
                    }
                    result.add(arrayList1);
                    stack=new Stack<>();
                }
                flag = !flag;
            }
            else {
                int data = node.val;
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                if (flag)
                    arrayList.add(data);
                else
                    stack.push(data);
            }
        }
        if (flag){
            ArrayList arrayList1 = (ArrayList) arrayList.clone();
            result.add(arrayList1);
            arrayList = new ArrayList<>();
        }
        else {
            ArrayList arrayList1 = new ArrayList();
            while (!stack.isEmpty()){
                arrayList1.add(stack.pop());
            }
            result.add(arrayList1);
            stack=new Stack<>();
        }
        return result;
    }
}
