package practice;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {

        Map<Integer, Integer> data = new HashMap<>();
        int pairs=0;
        for (int i=0; i<ar.size(); i++){
            if (data.containsKey(ar.get(i))){
                int count = data.get(ar.get(i));
                count++;
                data.put(ar.get(i), count);
            }
            else {
                data.put(ar.get(i), 1);
            }
        }

        for (Integer key : data.keySet()){
            if (data.get(key)/2 >=1 ){
//                System.out.println("data.get(key)/2 = " + data.get(key)/2);
                pairs =  pairs + data.get(key)/2;
            }
        }
        return pairs;
    }

}

public class SocksStock {
    public static void main(String[] args) throws IOException {
        int n = 0;
        List<Integer> ar = Arrays.asList(0, 20, 20, 10, 10, 30, 50, 10, 20);
        int result = Result.sockMerchant(n, ar);

        System.out.println("Pairs are " + result);

    }
}
