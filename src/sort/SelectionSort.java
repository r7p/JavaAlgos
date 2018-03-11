package sort;

import java.util.Arrays;

/**
 * Has same time complexity (O(N^2)) as bubble sort, but requires fewer
 * swaps (O(N)).
 *
 * Note that, inner for loop mearly note the index of array which is minimum. Swap happens in outer loop
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arInt = {77, 99, 44, 55, 22, 88, 11, 0, 66, 33};
        selectionSort1(arInt);
        System.out.println(Arrays.toString(arInt));
    }

    public static void selectionSort1(int[] arInt) {
        int maxIndex = arInt.length - 1;
        for(int outer = 0; outer < maxIndex - 1; outer++) {
            int curMin = outer;
            for(int inner = outer + 1; inner < maxIndex; inner++) {
                if (arInt[inner] < arInt[curMin]) {
                    curMin = inner;
                }
            }
            int tmp = arInt[outer];
            arInt[outer] = arInt[curMin];
            arInt[curMin] = tmp;
        }
    }
}
