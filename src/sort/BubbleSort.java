package sort;

import java.util.Arrays;

/**
 * O(N^2) comparisons and O(N^2) swaps
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arInt = {77, 99, 44, 55, 22, 88, 11, 0, 66, 33};
        bubbleSort1(arInt);
        System.out.println(Arrays.toString(arInt));
    }

    public static void bubbleSort1(int[] arInt) {
        for(int out=arInt.length - 1; out > 1; out--) {
            for(int in=0; in < out; in++) {
                if ( arInt[in] > arInt[in+1]) {
                    int tmp = arInt[in];
                    arInt[in] = arInt[in+1];
                    arInt[in+1] = tmp;
                }
            }
        }
    }
}
