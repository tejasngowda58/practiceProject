package practice.Concurrency.adderSubtractorWithLocks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value value = new Value();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(value, lock);
        Subtractor subtractor = new Subtractor(value, lock);
        Future<Void> add = executorService.submit(adder);
        Future<Void> sub = executorService.submit(subtractor);

        add.get();
        sub.get();

        System.out.println(value.value);
        executorService.shutdown();
    }
}
