package practice.AdvancedDSA.LinkedList;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 3);
        utils.insert(head, 4);
        utils.insert(head, 5);
        utils.insert(head, 6);

        head = removeNthFromEnd(head, 7);
        LLUtils.printLinkedList(head);
    }

    public static LLUtils.ListNode removeNthFromEnd(LLUtils.ListNode head, int B) {
        int count = 0;
        if (head == null) return null;
        if (head.next==null && B>0)
            return null;

        LLUtils.ListNode temp = head;
        while (temp!=null){
            count++;
            temp=temp.next;
        }

        temp = head;
        int nodeToBeDeleted = count-B;
        if (nodeToBeDeleted<0) {
            head =head.next;
        }
            int val=1;
            while (val<nodeToBeDeleted){
                val++;
                temp = temp.next;
            }
            temp.next  = temp.next.next;

//        else {
//
//        }
        return head;
    }
}
