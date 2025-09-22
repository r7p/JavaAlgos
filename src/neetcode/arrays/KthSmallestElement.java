package neetcode.arrays;


public class KthSmallestElement {
    /**
     * Basically reduced QuickSort, called RSelect or QuickSelect algorithm.
     * Can be used in variants such as TopKthElement (or Frequency), The Closest point to the origin etc.
     *
     */
    static int partition(int[] nums, int low, int high, int pivot_index) {
        final int pivot = nums[pivot_index];
        int new_pivot_index = low;
        // put pivot to the end of the array
        swap(nums, pivot_index, high);

        for(int j = low; j <= high; j++) {
            if (nums[j] < pivot) {
                swap(nums, j, new_pivot_index);
                new_pivot_index += 1;
            }
        }
        // move pivot from end of the array to its rightful position
        swap(nums, high, new_pivot_index);
        return new_pivot_index;
    }

    static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    static int kthSmallest(int[] nums, int kSmallest) {
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            int pivot_index = partition(nums, left, right, left + (right - left) / 2);

            if (kSmallest == pivot_index)
                return nums[kSmallest];

            if (pivot_index > kSmallest) {
                right = pivot_index - 1;
            } else {
                left = pivot_index + 1;
            }
        }
        return nums[kSmallest];
    }

    public static void main(String[] args) {
        int[] nums = {3, 8, 2, 5, 1, 4, 7, 6};
        System.out.println("6th smallest is: " + kthSmallest(nums, 5));
    }
}
