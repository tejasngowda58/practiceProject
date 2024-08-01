package practice.JP;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        sortData();
    }

    public static void sortData() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Messi",21);
        map.put("Ronaldo",16);
        map.put("Neymar",20);
        map.put("Neymar1",2);
        map.put("Neymar2",201);

        Map<Integer, String> sortedMap = new TreeMap<>();

        for (var entry: map.entrySet()){
            sortedMap.put(entry.getValue(), entry.getKey());
        }

        System.out.println(sortedMap);
    }
}
