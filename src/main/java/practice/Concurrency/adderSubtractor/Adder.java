package practice.Concurrency.adderSubtractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    public Adder(Value value){
        this.value = value;
    }


    @Override
    public Void call() throws Exception {
        for (int i=1; i<=5000; i++){
            value.value+=i;
        }
        return null;
    }
}
