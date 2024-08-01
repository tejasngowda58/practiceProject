package practice.Test1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
//    OutPut : Stadium Cricket is This

//    String = This is Cricket Stadium

    public static void main(String[] args) {
        reverseAString("hi how are you");
    }

    public static String reverseAString(String data){
        String[] strings = data.split(" ");
        String collect = Arrays.stream(strings).map(val -> val.substring(0, 1).toUpperCase() + val.substring(1) + " ")
                .collect(Collectors.joining());
        System.out.println(collect.substring(0, collect.length()-1));
        System.out.println(collect);
        String value = "value";

        System.out.println(value.substring(0,1).toUpperCase() + value.substring(1));
        System.out.println();
//        Arrays.stream(strings).map();
        return null;
    }
}
