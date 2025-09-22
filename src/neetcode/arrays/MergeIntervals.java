package neetcode.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    static int[][] mergeIntervals(int[][] intervals) {

        // Sort intervals by first element
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> result = new LinkedList<>();

        for (int[] interval: intervals) {

            if (result.isEmpty() || interval[0] > result.getLast()[1]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}};
        int[][] mergedIntervals = mergeIntervals(intervals);

        StringBuilder sb = new StringBuilder();
        for (int[] interval: mergedIntervals) {
            sb.append(Arrays.toString(interval));
        }

        System.out.println("Merged intervals are " + sb);
    }
}
