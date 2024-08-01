package practice.test5;
/**
 * 1) Given a list of integers, filter out the even numbers and collect them into a new list.
 * 2) Given a list of integers, convert each integer to it's square and collect them into a new list.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        solution();
    }

    public static void solution(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        List<Integer> evenNumbers = numbers.stream().filter(n -> n%2==0).collect(Collectors.toList());

        System.out.println(evenNumbers);

        List<Integer> squaredNumber = numbers.stream().map(n -> n*n).collect(Collectors.toList());

        System.out.println(squaredNumber);

    }

//   "Out from inner finally";
}
