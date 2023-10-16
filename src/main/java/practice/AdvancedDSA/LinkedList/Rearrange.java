package practice.AdvancedDSA.LinkedList;

public class Rearrange {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 3);
        utils.insert(head, 4);
        utils.insert(head, 5);
//        utils.insert(head, 6);
        rearrange(head);
        LLUtils.printLinkedList(head);
    }

    public static LLUtils.ListNode rearrange(LLUtils.ListNode head) {
        if (head==null || head.next==null ||head.next.next==null)
            return head;
        LLUtils.ListNode head1 = head;
        LLUtils.ListNode mid = findMid(head);
        LLUtils.ListNode head2 = mid.next;
        head2 = reverse(head2);
        mid.next=null;
        while (head2!=null){
            LLUtils.ListNode ref = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = ref;
            head1=ref;
        }
        return head;
    }

    private static LLUtils.ListNode reverse(LLUtils.ListNode head) {
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

    private static LLUtils.ListNode findMid(LLUtils.ListNode head) {
        LLUtils.ListNode fast = head;
        LLUtils.ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
