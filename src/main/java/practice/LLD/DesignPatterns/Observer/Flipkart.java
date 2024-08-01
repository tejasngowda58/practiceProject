package practice.LLD.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Flipkart {
    private static Flipkart flipkart = null;

    private static Lock lock = new ReentrantLock();

    private List<OrderPlacedSubscriber> orderPlacedSubscriberList;

    private Flipkart(){
        orderPlacedSubscriberList = new ArrayList<>();
    }


    public static Flipkart createInstance(){
        if (flipkart==null){
            lock.lock();
            if (flipkart==null)
                flipkart = new Flipkart();
            lock.unlock();
        }
        return flipkart;
    }

    public void registerToOrderPlacesEvent(OrderPlacedSubscriber orderPlacedSubscriber){
        orderPlacedSubscriberList.add(orderPlacedSubscriber);
    }

    public void unRegisterToOrderPlacesEvent(OrderPlacedSubscriber orderPlacedSubscriber){
        orderPlacedSubscriberList.remove(orderPlacedSubscriber);
    }

    public void orderPlaced(){
        for (OrderPlacedSubscriber orderPlacedSubscriber: orderPlacedSubscriberList){
            System.out.println(orderPlacedSubscriber.orderPlaced().getStatus());
        }
    }
}
