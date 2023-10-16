package practice.AdvancedDSA.LinkedList;

public class ReverseBetween {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 3);
//        utils.insert(head, 4);
//        utils.insert(head, 5);
//        utils.insert(head, 6);

        head = reverseBetween(head, 1,2);
        LLUtils.printLinkedList(head);
    }

    public static LLUtils.ListNode reverseBetween(LLUtils.ListNode head, int range1, int range2) {
        LLUtils.ListNode temp = head;
        LLUtils.ListNode A = null;
        LLUtils.ListNode B = null;
        LLUtils.ListNode C = null;
        int count = range2-range1;
        if (count == 0)
            return head;
        int val = 0;
        while (val<range1-2) {
            val++;
            temp = temp.next;
        }
        if (range1==1)
        {
            A = temp;
            B = temp.next;
            C = temp.next.next;
        }
        else {
            A = temp.next;
            B = temp.next.next;
            C = temp.next.next.next;
        }
        val = 0;
        while (B!=null && val<(count)) {
            val++;
            B.next = A;
            A=B;
            B=C;
            if (C!=null)
            C=C.next;
        }
        if (range1==1){
            temp.next=B;
            head = A;
            return head;
        }
        temp.next.next=B;
        temp.next=A;
        return head;
    }
}
