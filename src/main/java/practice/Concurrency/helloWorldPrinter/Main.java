package practice.Concurrency.helloWorldPrinter;

public class Main {
    public static void main(String[] args) {

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        Thread thread = new Thread(helloWorldPrinter);
        thread.start();

        System.out.println("Hello from " + Thread.currentThread().getName());
        System.out.println("Hello again from " + Thread.currentThread().getName());
    }
}
