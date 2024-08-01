package practice.Test6;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//{3, 1, 4, 7, 5, 6} , target = 9

//"i am an indian"
public class Main {
    public static void main(String[] args) {

//        List<Integer> input = Arrays.asList(3, 1, 4, 7, 5, 6);
//        int target = 9;
//        System.out.println(solution(input, target));

        printChar("i am an indian");
    }

    public static List<List<Integer>> solution(List<Integer> data, int target){
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> integerSet = new HashSet<>();
        for (int i=0; i< data.size(); i++){
            integerSet.add(data.get(i));
        }

        Iterator<Integer> iterator = integerSet.iterator();

        while (iterator.hasNext()){
            Integer next = iterator.next();
            int requiredVal = target - next;
            if (integerSet.contains(requiredVal)){
                List<Integer> array = new ArrayList<>();
                array.add(next);
                array.add(requiredVal);
                result.add(array);
            }
        }
        return result;
    }

    public static void printChar(String input){
        Map<Character, Integer> charMap =  new HashMap<>();

        for (int i=0;i<input.length(); i++){
            if (input.charAt(i) != ' ')
                charMap.put(input.charAt(i), charMap.getOrDefault(input.charAt(i), 0) +1);
        }

        for (Map.Entry<Character, Integer> entry: charMap.entrySet()){
//            entry.getValue();
            if (entry.getValue()>1)
                System.out.println(entry.getKey() + ": " + entry.getValue());
        }


//        IntStream chars = input.chars();

//        chars.map(i-> charMap.put((Character) i, charMap.getOrDefault(i, 0) + 1))

    }

//    public void soltuion1(){
//        employees.stream().collect(Collectors.groupingBy(Employee::getAge));
//        employees.stream().map(e->e.getName()).collect(Collectors.toList());
//
//        employees.stream().collect(Collectors.maxBy(Emplyee::getSalary));
//        employees.stream().collect(Collectors.minBy(Emplyee::getSalary));
//    }
}
