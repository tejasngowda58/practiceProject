package practice.AdvancedDSA.LinkedList;

public class RemoveDuplicatesInSortedList {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 2);
        utils.insert(head, 2);
        utils.insert(head, 3);
        utils.insert(head, 3);
        utils.insert(head, 3);
        utils.insert(head, 4);
        utils.insert(head, 5);
        utils.insert(head, 6);

        head = deleteDuplicates(head);
        LLUtils.printLinkedList(head);
    }

    public static LLUtils.ListNode deleteDuplicates(LLUtils.ListNode head) {
        LLUtils.ListNode temp = head;

        while (temp.next != null){
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }
}
