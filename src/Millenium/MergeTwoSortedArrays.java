package Millenium;

import java.util.Arrays;

/**
 * Given two sorted arrays a and b such that a.length = 2 * b.length, but both have b.length elements
 * filled in sorted.  Fill in array a to merge both array into one, resulting in one sorted array.
 *
 * a = [4,5,6,0,0,0]
 * b = [1,2,3]
 * then a = [1,2,3,4,5,6]
 *
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[]   a = {4,5,6,0,0,0},
                b = {1,2,3};
        mergeInPlace(a, b);
        System.out.println(Arrays.toString(a));

        int[] arr1 = { 1, 18, 22, 100, 105, 1002 };
        int[] arr2 = { 16, 17, 19, 21, 1001 };
        System.out.println(Arrays.toString(mergeIntoThirdArray(arr1, arr2)));
    }


    private static void mergeInPlace(int[] a, int[] b) {
        int     n = b.length,
                m = a.length - n, //LAST elements in first array, excluding unoccupied elements.  This is where comparison starts
                k = a.length - 1;

        while (m > 0 && n > 0) {
            if (a[m - 1] > b[n -1]) {
                a[k--] = a[m - 1];
                m--;
            } else {
                a[k--] = b[n -1];
                n--;
            }
        }

        while (n > 0) {
            a[k--] = b[n -1];
            n--;
        }

    }

    private static int[] mergeIntoThirdArray(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        int ptrA = 0, ptrB = 0, ptrResult = 0;
        while(ptrA < a.length && ptrB < b.length) {
            if (a[ptrA] < b[ptrB]) {
                result[ptrResult] = a[ptrA];
                ptrResult++;
                ptrA++;
            } else {
                result[ptrResult] = b[ptrB];
                ptrResult++;
                ptrB++;
            }
        }

        if (ptrA < a.length) {
            System.arraycopy(a, ptrA, result, ptrResult, a.length - ptrA);
        }

        if (ptrB < b.length) {
            System.arraycopy(b, ptrB, result, ptrResult, b.length - ptrB);
        }

        return result;
    }
}
