package practice.exception;

import java.io.IOException;

public class EpsilonTest {
    public int test(){
        try {
            throw new IOException();
        }
        catch (Exception e){
            System.out.println("Caught exception" + e);
            return 1;
        }
        finally {
            System.out.println(" Hello from finally");
            return 2;
        }
    }
}
