package practice.Concurrency.adderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        Value value = new Value();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Adder adder = new Adder(value);
        Subtractor subtractor = new Subtractor(value);
        Future<Void> add = executorService.submit(adder);
        Future<Void> sub = executorService.submit(subtractor);

        add.get();
        sub.get();

        System.out.println(value.value);
        executorService.shutdown();
    }
}
