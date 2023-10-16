package practice.AdvancedDSA.LinkedList;

import practice.AdvancedDSA.LinkedList.LLUtils.ListNode;

public class AgainMergeTwoSortedLL {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        ListNode head1 = null;
        head1 = utils.insert(head1, 2);
        utils.insert(head1, 6);
        utils.insert(head1, 11);
        utils.insert(head1, 12);

        ListNode head2 = null;
        head2 = utils.insert(head2, 3);
        utils.insert(head2, 8);
        utils.insert(head2, 10);
        utils.insert(head2, 14);
        utils.insert(head2, 20);
        ListNode head = mergeTwoSortedLL(head1, head2);
        LLUtils.printLinkedList(head);
    }

    public static ListNode mergeTwoSortedLL(ListNode head1, ListNode head2) {
        ListNode head;
        if (head1.val <= head2.val)
            head = head1;
        else {
            head = head2;
            head2 = head1;
            head1 = head;
        }

        while (head1.next!= null){
            if (head1.next.val> head2.val) {
                ListNode temp = head1.next;
                head1.next=head2;
                head1=head2;
                head2=temp;
            }
            else {
                head1= head1.next;
            }
        }

        if (head1.next==null)
            head1.next=head2;

        return head;
    }
}
