package sort;

import java.util.Arrays;

public class MergeSort {
    /**
     * Basically (ignoring base case):
     *      Split incoming array in to two half
     *      C = recursively sort first half of the array
     *      D = recursively sort second half of the array
     *      return Merge(C, D)
     *
     */
    static int[] mergeSort(int[] nums) {
        // Base case
        int array_length = nums.length;
        if (array_length < 2)
            return nums;

        // Split incoming array into half
        int mid = array_length / 2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[array_length - mid];

        int split_index = 0;
        for (int i = 0; i < array_length; i++) {
            if (i < mid) {
                // goes in to left array
                left_arr[i] = nums[i];
            } else {
                // goes in to right array
                right_arr[split_index++] = nums[i];
            }
        }

        // recursively sort left and right half of the array
        int [] sorted_left_arr = mergeSort(left_arr);
        int [] sorted_right_arr = mergeSort(right_arr);

        // merge left and right half of the array
        return merge(sorted_left_arr, sorted_right_arr);
    }

    static int[] merge(int[] left_arr, int[] right_arr) {
        int left_size = left_arr.length;
        int right_size = right_arr.length;
        int[] result = new int[left_size + right_size];

        int left = 0;
        int right = 0;
        int result_idx = 0;
        while (left < left_size && right < right_size) {
            if (left_arr[left] < right_arr[right]) {
                result[result_idx++] = left_arr[left++];
            } else {
                result[result_idx++] = right_arr[right++];
            }
        }

        // merge remaining from left
        while (left < left_size) {
            result[result_idx++] = left_arr[left++];
        }
        // merge remaining right half
        while (right < right_size) {
            result[result_idx++] = right_arr[right++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        int[] result = mergeSort(actual);
        System.out.println(Arrays.toString(result));
    }
}
