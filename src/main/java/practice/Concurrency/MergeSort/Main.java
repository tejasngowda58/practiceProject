package practice.Concurrency.MergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> arrayToSort = List.of(8, 2, 4, 1, 9, 6, 0, 7);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(arrayToSort, executorService);
//        Future<List<Integer>> sortedArrayFuture = executorService.submit(sorter);
//        List<Integer> sortedArray = sortedArrayFuture.get();
        List<Integer> sortedArray = sorter.call();
        for (Integer in: sortedArray) {
            System.out.println(in);
        }

        executorService.shutdown();
    }
}
