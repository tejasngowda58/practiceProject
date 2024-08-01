package practice.StaticMethodsBehaviour;

public class RemoveDuplicatesFromSortedArray
{
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
        int n = arr.length;
//        arr[0]=10;
        // removeDuplicates() returns new size of array
        n = removeDuplicates(arr, n);

        // Print updated array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    static int removeDuplicates(int arr[], int n){
        int copy[] = new int [n];

        for(int i=0; i<n; i++){
            copy[i] = arr[i];
            System.out.print(copy[i] + " ");
        }

        int prev = -1;
        int count = 0;
        int i = 0;
        int j = 0;
        while(i<n){
            while(i<n && copy[i]==prev){
                prev = copy[i];
                i++;
                count++;
            }
            if (i<n) {
                arr[j] = copy[i];
                prev = copy[i];
                j++;
                i++;

            }

        }

        for(int k=n-count; k<n; k++){
            arr[k] = 0;
        }
        return n-count;
    }
}

