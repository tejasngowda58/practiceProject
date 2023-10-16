package practice.Concurrency.producerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    private int producerId;

    public Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore, int producerId){
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.producerId = producerId;
    }

    private void produceItem() throws InterruptedException {
        producerSemaphore.acquire();
        Thread.sleep(2000);
        store.addItem(producerId);
        consumerSemaphore.release();
    }

    @Override
    public void run() {
        while (true){
            try {
                produceItem();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
