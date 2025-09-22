package sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * Partitions the array around pivot (represented by index low).
     * In other words, first element of the array is ALWAYS chosen as a pivot (naive method)
     *
     * @param nums  Array to be sorted
     * @param low   Index of pivot in array
     * @param high  Array length
     * @return  Index of pivot in re-arranged array, such that elements before pivots are less
     * than pivot (but nor sorted), and elements after pivot is greater than pivot (also not sorted)
     */
    static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int pivot_index = low;

        for(int j = low + 1; j < high; j++) {
            if (nums[j] < pivot) {
                pivot_index += 1;
                swap(nums, j, pivot_index);
            }
        }
        swap(nums, low, pivot_index);
        return pivot_index;
    }

    static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    static void quicksort(int[] nums, int low, int high) {
        if(low < high){
            int p = partition(nums, low, high);
            // p is new pivot position
            System.out.println(p + " : " + Arrays.toString(nums));
            quicksort(nums, low, p-1);
            quicksort(nums, p+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 1, 10, 13, 5, 2, 7};
        // System.out.println(partition(arr, 0, arr.length) + " : " + Arrays.toString(arr));
        int[] arr1 = {3, 8, 2, 5, 1, 4, 7, 6};
        // System.out.println(partition(arr1, 0, arr1.length) + " : " + Arrays.toString(arr1));
        quicksort(arr1, 0, arr1.length);
        System.out.println("Sorted array: " + Arrays.toString(arr1));
    }
}
