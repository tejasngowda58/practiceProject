package practice.Concurrency.helloWorldPrinter;

public class HelloWorldPrinter implements Runnable{

    private void doSomething(){
        System.out.println("Hello world from " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        doSomething();
        System.out.println("Hi world  from " + Thread.currentThread().getName());
    }
}
