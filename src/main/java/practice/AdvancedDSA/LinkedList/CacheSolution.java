package practice.AdvancedDSA.LinkedList;

import java.util.HashMap;
import java.util.Map;


public class CacheSolution {
    private int capacity;
    private Map<Integer, DoubleNode> map;
    private DoubleNode LRU;
    private DoubleNode MRU;

    public static void main(String[] args) {
        CacheSolution cacheSolution = new CacheSolution(7);
//        System.out.println(cacheSolution.get(2));
//        cacheSolution.set(2,6);
//        System.out.println(cacheSolution.get(1));
//        cacheSolution.set(1, 5);
//        cacheSolution.set(1, 2);
//        System.out.println(cacheSolution.get(1));
//        System.out.println(cacheSolution.get(2));

        cacheSolution.set(2,1);
        cacheSolution.set(1,10);
        cacheSolution.set(8,13);
        System.out.println(cacheSolution.get(12));
        cacheSolution.set(2,8);
        System.out.println(cacheSolution.get(11));
        System.out.println(cacheSolution.get(7));
        cacheSolution.set(14,7);
        cacheSolution.set(12,9);
        cacheSolution.set(7,10);
        System.out.println(cacheSolution.get(11));
        cacheSolution.set(9,3);
        cacheSolution.set(14,15);
        System.out.println(cacheSolution.get(15));
        System.out.println(cacheSolution.get(9));
        cacheSolution.set(4,13);
        System.out.println(cacheSolution.get(3));
        cacheSolution.set(13,7);
        System.out.println(cacheSolution.get(2));
        cacheSolution.set(5,9);
        System.out.println(cacheSolution.get(6));
        System.out.println( cacheSolution.get(13));
        cacheSolution.set(4,5);
        cacheSolution.set(3,2);
        cacheSolution.set(4,12);
        System.out.println(cacheSolution.get(13));
        System.out.println(cacheSolution.get(7));
        cacheSolution.set(9,7);
        System.out.println(cacheSolution.get(3));
        System.out.println(cacheSolution.get(6));
        System.out.println(cacheSolution.get(2));
        cacheSolution.set(8,4);
        cacheSolution.set(8,9);
        cacheSolution.set(1,4);
        cacheSolution.set(2,9);
        cacheSolution.set(8,8);
        System.out.println(cacheSolution.get(13));
        System.out.println(cacheSolution.get(3));
        System.out.println(cacheSolution.get(13));
        System.out.println(cacheSolution.get(6));
        cacheSolution.set(3,8);
        System.out.println(cacheSolution.get(4));
        System.out.println(cacheSolution.get(14));
        cacheSolution.set(5,6);
        cacheSolution.set(10,15);
        System.out.println(cacheSolution.get(12));
        cacheSolution.set(13,5);
        cacheSolution.set(10,9);
        cacheSolution.set(3,12);
        cacheSolution.set(14,15);
        System.out.println(cacheSolution.get(4));
        cacheSolution.set(10,5);
        System.out.println(cacheSolution.get(5));
        System.out.println(cacheSolution.get(15));
        cacheSolution.set(7,6);
        System.out.println(cacheSolution.get(1));
        cacheSolution.set(5,12);
        cacheSolution.set(1,6);
        cacheSolution.set(11,8);


//        cacheSolution.set(1, 1);
//        System.out.println("LRU is: " + cacheSolution.LRU.val);
//        System.out.println("MRU is: " + cacheSolution.MRU.val);
//        cacheSolution.set(2,2);
//        System.out.println("LRU is: " + cacheSolution.LRU.val);
//        System.out.println("MRU is: " + cacheSolution.MRU.val);
//        cacheSolution.set(3,3);
//        System.out.println("LRU is: " + cacheSolution.LRU.val);
//        System.out.println("MRU is: " + cacheSolution.MRU.val);
//        System.out.println(cacheSolution.get(1));
//        System.out.println("LRU is: " + cacheSolution.LRU.val);
//        System.out.println("MRU is: " + cacheSolution.MRU.val);
    }

    public CacheSolution(int capacity){
        this.capacity = capacity;
        LRU=null;
        MRU=null;
        map = new HashMap<>();
    }

    public int get(int key){
        if (map.containsKey(key)){
            DoubleNode temp = map.get(key);
            if (temp == MRU)
                return temp.val;
            if (temp == LRU){
                LRU = LRU.next;
                LRU.prev = null;
                MRU.next = temp;
                temp.prev = MRU;
                MRU = temp;
                return temp.val;
            }
            DoubleNode tempPrev = temp.prev;
            DoubleNode tempNext = temp.next;
            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;
            MRU.next = temp;
            temp.prev = MRU;
            MRU = temp;
            MRU.next = null;
            return temp.val;
        }
        else
            return -1;
    }

    public void set(int key, int value) {
        DoubleNode temp = new DoubleNode(value);
        if (map.isEmpty()){
            map.put(key, temp);
            MRU = temp;
            LRU = temp;
        }
        else {
            if (this.capacity == 1) {
                map.values().remove(LRU);
                map.put(key, temp);
                MRU = temp;
                LRU = temp;
                return;
            }

            if (map.containsKey(key)) {
                DoubleNode temp1 = map.get(key);
                temp1.val = value;
                if (temp1 == MRU){
                    return;
                }
                else if(temp1 == LRU){
                    LRU = LRU.next;
                    LRU.prev = null;
                    MRU.next = temp1;
                    temp1.prev = MRU;
                    MRU = temp1;
                    return;
                }
                else {
                    DoubleNode tempPrev = temp1.prev;
                    DoubleNode tempNext = temp1.next;
                    tempPrev.next = tempNext;
                    tempNext.prev = tempPrev;
                    MRU.next = temp1;
                    temp1.prev = MRU;
                    MRU = temp1;
                    MRU.next = null;
                }
            } else {
                if (map.size() == this.capacity) {
                    map.values().remove(LRU);
                    LRU = LRU.next;
                    LRU.prev = null;
                }
                MRU.next = temp;
                temp.prev = MRU;
                MRU = temp;
                map.put(key, temp);
            }
        }
    }

    class DoubleNode{
        int val;
        DoubleNode next;
        DoubleNode prev;

        public DoubleNode(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
}
