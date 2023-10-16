package practice.Concurrency.producerConsumerSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Store store = new Store();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore produceSemaphore = new Semaphore(5);
        Semaphore consumerSemaphore = new Semaphore(0);

        for (int i=0; i<5; i++){
            Producer producer = new Producer(store, produceSemaphore, consumerSemaphore, i+1);
            executorService.execute(producer);
        }

        for (int j=0; j<5; j++) {
            Consumer consumer = new Consumer(store, produceSemaphore, consumerSemaphore, j+1);
            executorService.execute(consumer);
        }
    }
}
