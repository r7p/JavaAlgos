package neetcode.arrays;

public class FindMinimumFromRotated {

    /**
     * Find minimum from rotated sorted array in O(logN) time
     *
     * @param nums
     * @return
     */
    static int findMinimum(int[] nums) {
        final int length = nums.length;
        if (length == 1)
            return nums[0];

        int left = 0;
        int right = length - 1;

        if (nums[right] > nums[0]) {
            // this array is not rotated
            // applicable only when there are no duplicates in array?
            return nums[0];
        }

        while (left <= right) {
            final int mid = left + (right - left) / 2;

            // the array is rotated this mid-point onwards, hence the next in sequence is minimum
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // the array is rotated just at this mid-point
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                // first half of the array is properly sorted, minimum is in right half
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
        System.out.println(findMinimum(nums));
    }
}
