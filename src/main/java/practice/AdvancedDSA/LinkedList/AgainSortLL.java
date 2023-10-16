package practice.AdvancedDSA.LinkedList;

import practice.AdvancedDSA.LinkedList.LLUtils.ListNode;

public class AgainSortLL {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 4);
        utils.insert(head, 3);
        utils.insert(head, 6);
        utils.insert(head, 5);

        ListNode mid = findMid(head);
        head = mergeSort(head);
        LLUtils.printLinkedList(head);
        System.out.println("Mid is: " + mid.val);
    }

    public static ListNode mergeSort(ListNode head){
        if (head==null || head.next==null)
            return head;
        ListNode mid = findMid(head);
        ListNode head1 = mid.next;
        mid.next = null;
        head = mergeSort(head);
        head1 = mergeSort(head1);
        return AgainMergeTwoSortedLL.mergeTwoSortedLL(head, head1);
    }

    public static ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        if (head==null || head.next==null)
            return head;

        while (fast.next!=null && fast.next.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
