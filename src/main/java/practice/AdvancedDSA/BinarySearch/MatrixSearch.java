package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,   3,  5,  7)));
        A.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        A.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(22, 32, 67)));
        System.out.println(searchMatrix(A,93));
    }

    public static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int rowSize = A.size();
        int columnSize = A.get(0).size();
        int l=0;
        int h = (rowSize*columnSize)-1;
        while (l<=h){
            int mid = (l+h)/2;
            int row = mid/columnSize;
            int col = mid%columnSize;
            if (A.get(row).get(col) == B){
                return 1;
            }
            else if (A.get(row).get(col) < B){
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return 0;
    }
//    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(new ArrayList<>(Arrays.asList(1,   3,  5,  7)));
//        A.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
//        System.out.println(searchMatrix(A,3));
//    }
//
//    public static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
//        int rowSize = A.size();
//        int columnSize = A.get(0).size();
//
//        int columnLow = 0;
//        int columnHigh = columnSize-1;
//        int rowLow = 0;
//        int rowHigh = rowSize-1;
//
//        while ((rowLow<rowHigh) || (rowLow==rowHigh && columnLow<=columnHigh)){
//            int columnMid = (columnLow+columnHigh)/2;
//            int rowMid = (rowHigh+rowLow)/2;
//            if (A.get(rowMid).get(columnMid) == B){
//                return 1;
//            }
//            if (A.get(rowMid).get(columnMid) > B){
//                columnHigh = columnMid-1;
//                rowHigh = rowMid;
//                if (columnHigh==-1){
//                    columnHigh = columnSize-1;
//                    rowHigh = rowMid-1;
//                }
//            }
//            else {
//                columnLow = columnMid+1;
//                rowLow = rowMid;
//                if (columnLow == columnSize){
//                    columnLow = 0;
//                    rowLow = rowMid+1;
//                }
//            }
//        }
//        return 0;
//    }
}
