package practice.AdvancedDSA.LinkedList;

public class ReverseInPlace {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 3);
        utils.insert(head, 4);
        utils.insert(head, 5);
        utils.insert(head, 6);
//        LLUtils.printLinkedList(head);
        head = reverseList(head);
        LLUtils.printLinkedList(head);
    }

    public static LLUtils.ListNode reverseList(LLUtils.ListNode A) {
        LLUtils.ListNode head = A;
        if (A==null || A.next==null)
            return A;

        LLUtils.ListNode B=head.next;
        LLUtils.ListNode C=head.next.next;

        while (B!=null){
            B.next = A;
            A = B;
            B = C;
            if (C!=null)
                C = C.next;
        }

        head.next = null;
        head = A;
        return head;
    }
}
