package practice.AdvancedDSA.LinkedList;

public class MergeTwoLists {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head1 = null;
        head1 = utils.insert(head1, 2);
        utils.insert(head1, 6);
//        utils.insert(head1, 11);
//        utils.insert(head1, 12);

        LLUtils.ListNode head2 = null;
        head2 = utils.insert(head2, 3);
        utils.insert(head2, 8);
        utils.insert(head2, 10);
        utils.insert(head2, 14);
        utils.insert(head2, 20);
        LLUtils.ListNode head = merge(head1, head2);
        LLUtils.printLinkedList(head);
    }

    public static LLUtils.ListNode merge(LLUtils.ListNode h1, LLUtils.ListNode h2){
        LLUtils.ListNode head;
        if (h1.val <= h2.val){
            head = h1;
        }
        else {
            head = h2;
            h2=h1;
            h1=head;
        }

        while (h1.next!=null){
            if (h1.next.val > h2.val){
                LLUtils.ListNode temp = h1.next;
                h1.next = h2;
                h1 = h2;
                h2 = temp;
            }
            else {
                h1 = h1.next;
            }
        }

        if (h1.next == null) {
            h1.next = h2;
        }
        return head;
    }
}
