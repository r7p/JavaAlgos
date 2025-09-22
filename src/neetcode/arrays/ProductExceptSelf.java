package neetcode.arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int right=1, left=1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left *= nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3};
        // ans = {12, 6, 24, 8}
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
