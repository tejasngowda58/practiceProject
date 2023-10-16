package practice.AdvancedDSA.LinkedList;

public class ReverseInPlaceRange {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 3);
        utils.insert(head, 4);
        utils.insert(head, 5);
        utils.insert(head, 6);

        head = reverseListRange(head, 3);
        LLUtils.printLinkedList(head);
    }

    public static LLUtils.ListNode reverseListRange(LLUtils.ListNode head, int range) {
        LLUtils.ListNode A = head;
        if (A==null || A.next==null)
            return A;

        LLUtils.ListNode B=head.next;
        LLUtils.ListNode C=head.next.next;

        int count = 0;
        while (B!=null && count<(range-1)){
            count++;
            B.next = A;
            A = B;
            B = C;
            if (C!=null)
                C = C.next;
        }

        head.next = reverseListRange(B, range);
        head = A;
        return head;
    }
}
