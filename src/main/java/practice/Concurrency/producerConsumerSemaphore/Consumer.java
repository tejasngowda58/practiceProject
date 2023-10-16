package practice.Concurrency.producerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    int consumerId;

    public Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore, int consumerId) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.consumerId = consumerId;
    }

    public void consumeItem() throws InterruptedException {
        consumerSemaphore.acquire();
        Thread.sleep(2000);
        store.removeItem(consumerId);
        producerSemaphore.release();
    }

    @Override
    public void run() {
        while (true){
            try {
                consumeItem();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
