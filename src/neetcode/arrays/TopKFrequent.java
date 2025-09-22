package neetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    /**
     * Time Complexity: O(nlog(k))
     * Space Complexity: O(n)
     */
    static int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) ->
                        a.getValue() - b.getValue()
        );
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
            if (pq.size() > k) {
                // remove from the heap minimum value to keep heap size equals to k
                pq.poll();
            }
        }
        int i = k;
        while (!pq.isEmpty()) {
            arr[--i] = pq.poll().getKey();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
