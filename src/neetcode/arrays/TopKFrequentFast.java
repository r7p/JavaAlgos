package neetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentFast {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static int[] topKFrequent(int[] numbers, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(
                    number,
                    map.getOrDefault(number, 0) + 1
            );
        }

        int size = map.size();
        int[] keys = select(map, size - k);
        return Arrays.copyOfRange(keys, size - k, size);
    }

    // Modified implementation of Hoare's selection algorithm:
    static int[] select(Map<Integer, Integer> map, int kSmallest) {
        int size = map.size();
        int[] keys = new int[size];
        int i = 0;
        for (int key : map.keySet()) {
            keys[i++] = key;
        }

        int left = 0;
        int right = size - 1;
        while (left != right) {
            int pivot = partition(keys, map, left, right, left + (right - left) / 2);
            System.out.println(pivot + ": " + Arrays.toString(keys));

            if (kSmallest == pivot) return keys;

            if (kSmallest < pivot) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return keys;
    }

    static int partition(
            int[] keys,
            Map<Integer, Integer> map,
            int left,
            int right,
            int pivot
    ) {
        int pivotValue = map.get(keys[pivot]);
        swap(keys, pivot, right);
        int i = left;

        for (int j = left; j <= right; j++) {
            if (map.get(keys[j]) < pivotValue) {
                swap(keys, j, i);
                i++;
            }
        }
        swap(keys, right, i);
        return i;
    }

    static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

}
