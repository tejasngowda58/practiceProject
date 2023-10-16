package practice.AdvancedDSA.LinkedList;

public class ReverseComplete {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 3);
        utils.insert(head, 4);
        utils.insert(head, 5);
        utils.insert(head, 6);

        head = reverseList(head);
        LLUtils.printLinkedList(head);
    }

    public static LLUtils.ListNode reverseList(LLUtils.ListNode head) {
        if (head==null || head.next==null)
            return head;
        LLUtils.ListNode A = null;
        LLUtils.ListNode B= head;
        LLUtils.ListNode C = head.next;

        while (B!=null){
            B.next = A;
            A=B;
            B=C;
            if (C!=null)
                C = C.next;
        }
        head = A;
        return head;
    }
}
