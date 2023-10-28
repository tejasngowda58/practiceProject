package practice.Concurrency.adderSubtractorWithLocks;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Value value;
    private Lock lock;

    public Adder(Value value, Lock lock){
        this.value = value;
        this.lock = lock;
    }


    @Override
    public Void call() throws Exception {
        for (int i=1; i<=5000; i++){
            lock.lock();
            value.value+=i;
            lock.unlock();
        }
        return null;
    }
}
