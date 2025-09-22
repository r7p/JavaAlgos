package neetcode.arrays;

import java.util.Arrays;
import java.util.Objects;

public class CountInversions {
    /**
     * This is basically modified mergesort algo (nLogn)
     * if n < 2 then
     *      return (A, 0)
     * else
     *      (C, leftInv) = Sort_and_CountInv(Left half of A)
     *      (D, rightInv) = Sort_and_CountInv(Right half of A)
     *      (B, splitInv) = Sort_and_CountSplitInv(C, D)
     *      return (B, leftInv + rightInv + splitInv)
     */
    static Tuple<int[], Integer> sortAndCountInversions(int[] nums) {
        int array_length = nums.length;

        // Base case
        if (array_length < 2) {
            return new Tuple<>(nums, 0);
        }

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

        Tuple<int[], Integer> leftInv = sortAndCountInversions(left_arr);
        Tuple<int[], Integer> rightInv = sortAndCountInversions(right_arr);
        Tuple<int[], Integer> splitInv = sortAndSplitCountInversions(leftInv.x, rightInv.x);
        int totalInversions = leftInv.y + rightInv.y + splitInv.y;
        return new Tuple<>(splitInv.x, totalInversions);
    }

    static Tuple<int[], Integer> sortAndSplitCountInversions(int[] left_arr, int[] right_arr) {
        int left_size = left_arr.length;
        int right_size = right_arr.length;
        int[] result = new int[left_size + right_size];

        int left = 0;
        int right = 0;
        int result_idx = 0;
        int splitInversions = 0;
        while (left < left_size && right < right_size) {
            if (left_arr[left] < right_arr[right]) {
                result[result_idx++] = left_arr[left++];
            } else {
                result[result_idx++] = right_arr[right++];
                int tmp = left_size - left; // elements left in left half of the array
                splitInversions += tmp;
            }
        }

        // merge remaining from left
        while (left < left_size) {
            result[result_idx++] = left_arr[left++];
        }
        while (right < right_size) {
            result[result_idx++] = right_arr[right++];
        }
        return new Tuple<>(result, splitInversions);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4, 6};
        Tuple<int[], Integer> result = sortAndCountInversions(nums);
        System.out.println(Arrays.toString(result.x) + ":" + result.y);
    }

    static class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple<?, ?> tuple = (Tuple<?, ?>) o;
            return x.equals(tuple.x) && y.equals(tuple.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
