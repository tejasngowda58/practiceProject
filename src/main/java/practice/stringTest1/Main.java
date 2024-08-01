package practice.stringTest1;

public class Main {
    public static void main(String[] args) {
        testString();
    }

    public static void testString(){
        String s1 = "String";
        String s2 = new String("String");
        System.out.println(s1==s2);
        String s3 = "Data";
        String s4 = new String("Data");

        System.out.println("Hi");
    }
}
