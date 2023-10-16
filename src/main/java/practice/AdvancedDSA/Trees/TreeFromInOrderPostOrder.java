package practice.AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeFromInOrderPostOrder {
    public static void main(String[] args) {
        ArrayList<Integer> postOrder = new  ArrayList<>(Arrays.asList(9, 15, 7, 20, 3));
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(9, 3, 15, 20, 7));
        TreeNode root = construct(postOrder, inOrder, 0, postOrder.size()-1, 0, inOrder.size()-1);
        System.out.println(PostOrderTraversal.postorderTraversal(root));
        System.out.println(InorderTraversal.inorderTraversal(root));
    }

    public static TreeNode construct(ArrayList<Integer> postOrder, ArrayList<Integer> inOrder,
                                     int pos, int poe, int ins, int ine){
        if (pos>poe)
            return null;
        int rootVal = postOrder.get(poe);
        TreeNode root = new TreeNode(rootVal);
        int idx=0;
        for (int i=ins; i<=ine; i++){
            if (inOrder.get(i).equals(rootVal)){
                idx = i;
                break;
            }
        }
        int length = idx-ins;
        root.left = construct(postOrder, inOrder, pos, pos+length-1, ins, idx-1);
        root.right = construct(postOrder, inOrder, pos+length, poe-1,idx+1, ine);
        return root;
    }
}
