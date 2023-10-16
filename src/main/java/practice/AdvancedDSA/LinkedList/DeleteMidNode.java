package practice.AdvancedDSA.LinkedList;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class DeleteMidNode {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 3);
        utils.insert(head, 4);
        utils.insert(head, 5);
        utils.insert(head, 6);
        LLUtils.printLinkedList(head);
        int length = LLUtils.length(head);
        System.out.println("length is " + length);

        solve(head);
        LLUtils.printLinkedList(head);
        length = LLUtils.length(head);
        System.out.println("length is " + length);
    }

    public static LLUtils.ListNode solve(LLUtils.ListNode A) {
//        int length = LLUtils.length(A);
        LLUtils.ListNode temp = A;
        int length = 0;
        while (temp != null){
            length++;
            temp = temp.next;
        }

        if (length==1)
            return null;

        int mid = length/2;
        temp = A;
        int count = 0;
        while (count<mid-1){
            count++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return A;
    }

}


