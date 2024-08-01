package practice.test2;

public class LList {
    public static void main(String[] args) {
        LNode node1 =  new LNode(1);
        LNode node5 =  new LNode(5);
        LNode node4 =  new LNode(4);
        LNode node3 =  new LNode(3);
        LNode node2 =  new LNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next= node5;
        node5.next= null;

        System.out.println(isCircularLinkPresent(node1));

    }

    public static boolean isCircularLinkPresent(LNode head){
        if (head== null || head.next==null)
            return false;
        LNode slowPointer = head;
        LNode fastPointer = head;
//        boolean flag = false;
        while (slowPointer!=null){
            slowPointer = slowPointer.next;

            if (fastPointer.next!=null && fastPointer.next.next!=null){
                fastPointer = fastPointer.next.next;
            }
            else {
                return false;
            }
            if (slowPointer==fastPointer)
                return true;
        }
        return false;
    }
}
