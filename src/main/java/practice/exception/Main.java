package practice.exception;

import practice.exception.src.Test;

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        String data = null;
        try {
            data = test.getData(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hi");
        System.out.println(data);
    }
}
