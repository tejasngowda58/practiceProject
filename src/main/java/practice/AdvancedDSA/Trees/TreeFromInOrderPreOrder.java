package practice.AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeFromInOrderPreOrder {
    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new  ArrayList<>(Arrays.asList(3, 9, 20, 15, 7));
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(9, 3, 15, 20, 7));
        TreeNode root = construct(preOrder, inOrder, 0, preOrder.size()-1, 0, inOrder.size()-1);
        System.out.println(PreOrderTraversal.preorderTraversal(root));
        System.out.println(InorderTraversal.inorderTraversal(root));
    }

    public static TreeNode construct(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder,
                                     int prs, int pre, int ins, int ine){
        if (prs>pre)
            return null;
        int rootVal = preOrder.get(prs);
        TreeNode root = new TreeNode(rootVal);
        int idx=0;
        for (int i=ins; i<=ine; i++){
            if (inOrder.get(i).equals(rootVal)){
                idx = i;
                break;
            }
        }
        int length = idx-ins;
        root.left = construct(preOrder, inOrder, prs+1, prs+length, ins, idx-1);
        root.right = construct(preOrder, inOrder, prs+length+1, pre,idx+1, ine);
        return root;
    }
}
