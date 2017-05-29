package Spotify;

import java.util.Arrays;

/**
 * [8,9,9,8] -> [9,0,0,0]

 [9,8,7,6,5,4,3,2,1,0] -> [9,8,7,6,5,4,3,2,1,1]

 [9,9,9] -> [1,0,0,0]
 */
public class AddOneToIntArray {

    int[] addToArray(int[] input) {
        int carry = 1;
        int[] result = new int[input.length];

        for (int i = input.length - 1; i >= 0; i--) {
            int val = input[i] + carry;
            result[i] = val % 10;
            carry = val / 10;
        }

        if (carry == 1) {
            result = new int[input.length + 1];
            result[0] = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        AddOneToIntArray x = new AddOneToIntArray();
        System.out.println(Arrays.toString(x.addToArray(new int[] {8, 9, 9, 9})));
        System.out.println(Arrays.toString(x.addToArray(new int[] {9,8,7,6,5,4,3,2,1,0})));
        System.out.println(Arrays.toString(x.addToArray(new int[] {9, 9, 9})));
    }

}
