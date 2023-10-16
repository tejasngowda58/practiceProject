package practice.LinkedList;

public class DesignImplement {
    public static void main(String[] args) {
        insert_node(1, 23);
        print_ll();
        insert_node(2,24);
        insert_node(2,24);
        insert_node(2,24);
        print_ll();
        delete_node(3);
        delete_node(2);
        delete_node(2);
        delete_node(4);
        delete_node(1);
        delete_node(1);
        print_ll();
    }

//    public static class Node{
//        int value = 0;
//        Node next;
//        Node(int value) {
//            this.value = value;
//            this.next = null;
//        }
//    }
//
//    public static Node head = null;
//    public static Node tail = null;
//    public static int length = 0;
//
//    public static void insert_node(int position, int value) {
//        Node temp = new Node(value);
//        if (position == 1){
//            temp.next = head;
//            head = temp;
//        }
//        else if(position>1 && position<=length){
//            Node ref = head;
//            int count = 1;
//            if (count != position-1){
//                ref = ref.next;
//                count++;
//            }
//            temp.next = ref.next;
//            ref.next = temp;
//        }
//        else if(position == length+1) {
//            Node ref = head;
//            int count = 1;
//            if (count != length){
//                ref = ref.next;
//                count++;
//            }
//            ref.next = temp;
//        }
//        length++;
//    }
//
//    public static void delete_node(int position) {
//        if (length<=0)
//            return;
//        if (position==1){
//            head = head.next;
//        }
//        else if(position>1 && position<length){
//            Node ref = head;
//            int count=1;
//            while (count!= position-1){
//                count++;
//                ref = ref.next;
//            }
//            Node tempRef = ref.next;
//            ref.next = tempRef.next;
//        }
//        else if(position==length){
//            Node ref = head;
//            int count=1;
//            while (count!= position-1){
//                count++;
//                ref = ref.next;
//            }
//            ref.next = null;
//        }
//        length--;
//    }
//
//    public static void print_ll() {
//        // Output each element followed by a space
//        Node ref = head;
//        while (ref!=null){
//            System.out.print(ref.value);
//            System.out.print(" ");
//            ref = ref.next;
//        }
//    }


    public static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static Node head = null;
    public static int size = 0;


    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if(position >= 1 && position <= size + 1) {
            Node newNode = new Node(value);

            //at start
            if(position == 1) {
                newNode.next = head;
                head = newNode;
            } else {
                //at any position
                Node temp = head;
                for(int i = 0; i < position - 2; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
            size++;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position >= 1 && position <= size) {

            // at start
            if(position == 1) {
                head = head.next;
            } else {

                // at any position
                Node temp = head;
                for(int i = 1; i < position - 1; i ++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            size--;
        }




    }

    public static void print_ll() {
        // Output each element followed by a space
        Node temp = head;
        while(temp.next != null) {
            System.out.print(temp.value);
            System.out.print(" ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }

}
