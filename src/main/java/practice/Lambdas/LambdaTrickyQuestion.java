package practice.Lambdas;

/**
 * Replace below with lambda*
 */

public class LambdaTrickyQuestion {
    public static void main(String[] args) {
        decider("test").print("data");
    }

    public static Printable decider(String text){
        String value = "upper";
        if (value.equals("upper")){
            return printUpper(text);
        }
        else if (value.equals("lower")){

            return printLower(text);
        }
        else {
            return print(text);
        }
    }

    public static Printable printUpper(String text){
        return new Printable() {
            @Override
            public void print(String textData) {
                System.out.println(text);
            }
        };
    }

    public static Printable printLower(String text){
        return text1 -> System.out.println(text.toLowerCase());
    }

    public static Printable print(String text){
        return text1 -> System.out.println(text);
    }

    @FunctionalInterface
    public interface Printable{
        void print(String textData);
    }
}
