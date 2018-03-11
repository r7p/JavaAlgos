package sort;

import java.util.Arrays;

/**
 * Runs in O(N^2) and requires same number of copies (not swap).  Copy is faster than swap.
 * This algorithm does better when items are partially sorted.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arInt = {77, 99, 44, 55, 22, 88, 11, 0, 66, 33};
        insertionSort1(arInt);
        System.out.println(Arrays.toString(arInt));
    }

    public static void insertionSort1(int[] arInt) {

        for(int markedPos = 1; markedPos < arInt.length; markedPos++) {
            int markedItem = arInt[markedPos]; //take out marked item from array
            int comparePos = markedPos; //start comparing from marked position

            while (comparePos > 0 && arInt[comparePos-1] > markedItem) {
                arInt[comparePos] = arInt[comparePos-1];
                comparePos = comparePos - 1;
            }
            arInt[comparePos] = markedItem;
        }

    }
}
