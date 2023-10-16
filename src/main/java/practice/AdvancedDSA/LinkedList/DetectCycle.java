package practice.AdvancedDSA.LinkedList;

public class DetectCycle {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 3);
        LLUtils.ListNode temp= head;
        while (temp.next!= null){
            temp=temp.next;
        }
        utils.insert(head, 4);
        utils.insert(head, 5);
        utils.insert(head, 6);
        utils.insert(head, 7);
        utils.insert(head, 8);
        LLUtils.ListNode tail = temp;
        while (tail.next!= null){
            tail=tail.next;
        }
        tail.next=temp;
        LLUtils.ListNode listNode = detectCycle(head);
        if (listNode!=null)
        System.out.println(listNode.val);
    }

    public static LLUtils.ListNode detectCycle(LLUtils.ListNode head){
        LLUtils.ListNode fast = head;
        LLUtils.ListNode slow = head;

        while (fast!=null && fast.next!= null){
            fast= fast.next.next;
            slow=slow.next;
            if (slow==fast)
                break;
        }

        if (slow!=fast)
            return null;
        else {
            slow = head;
            while (slow!=fast) {
                slow = slow.next;
                fast=fast.next;
            }
            return slow;
        }
    }
}
