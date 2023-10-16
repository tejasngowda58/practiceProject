package practice.AdvancedDSA.LinkedList;

import practice.AdvancedDSA.LinkedList.LLUtils.ListNode;

public class PartitionList {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        ListNode head = null;
        head = utils.insert(head, 2);
//        utils.insert(head, 2);
        utils.insert(head, 3);
        utils.insert(head, 4);
        utils.insert(head, 5);
//        utils.insert(head, 2);
        head = partition(head, 1);
        LLUtils.printLinkedList(head);
    }

    public static ListNode partition(ListNode A, int B) {
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode bigHead = null;
        ListNode bigTail = null;
        ListNode temp = A;
        if (A == null || A.next==null){
            return A;
        }
        if (temp.val < B){
            smallHead = temp;
            smallTail = temp;
        } else {
            bigHead = temp;
            bigTail = temp;
        }

        while (temp.next != null){
            if (temp.next.val <B ){
                if (smallHead==null){
                    smallHead = temp.next;
                    smallTail = temp.next;
                }
                else {
                    smallTail.next = temp.next;
                    smallTail = smallTail.next;
                }
            }
            else {
                if (bigHead == null){
                    bigHead = temp.next;
                    bigTail = temp.next;
                }
                else {
                    bigTail.next = temp.next;
                    bigTail = bigTail.next;
                }
            }
            temp = temp.next;
        }

        if (smallHead != null)
            smallTail.next = bigHead;
        else
            return bigHead;
        if (bigHead != null)
        bigTail.next = null;
        return  smallHead;
    }
}
