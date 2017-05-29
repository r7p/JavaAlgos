import java.util.Arrays;

/**
 * Created by Raj on 5/2/2016.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 2, 4, 7, 3, 7, 10 };
        quicksort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) {
            return;
        }

        int mid = low + (high - low)/2;
        int pivot = arr[mid];

        int i = low, j = high;
        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println("quicksort " + Arrays.toString(arr));

        if (low < j) {
            quicksort(arr, low, j);
        }

        if (high > i) {
            quicksort(arr, i, high);
        }

    }
}
