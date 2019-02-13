/**
 * Given unsorted array of integers, find longest increasing subsequence
 * a = [2 6 3 4 1 2 9 5 8]
 * longest increasing subsequence is 2, 3, 4, 5, 8 with length 5.  So answer is 5.
 * https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 * https://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
 *
 */

public class LongestIncreasingSubsequence {

    static int nextHighestIndexOfValue(int[] tail, int tailSize, int key) {
        int low = 0, high = tailSize;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (tail[mid] == key) {
                return mid + 1;
            } else if (tail[mid] > key) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    static int findSequenceLength(int[] a) {

        int[] tail = new int[a.length];
        tail[0] = a[0];
        int tailNextPtr = 1; //next empty slot in tail array

        for (int i = 1; i < a.length; i++) {
            if (a[i] < tail[0]) {
                //new smallest value
                tail[0] = a[i];
            } else if (a[i] > tail[tailNextPtr - 1]) {
                //new largest value
                tail[tailNextPtr++] = a[i];
            } else {
                //somewhere between smallest value and largest value
                //replace next highest value in tail array with this value
                int index = nextHighestIndexOfValue(tail, tailNextPtr - 1, a[i]);
                tail[index] = a[i];
            }
        }

        return tailNextPtr;
    }

    public static void main(String[] args) {
        int[] a = {-1, 3, 5, 6, 8, 9, 10};
        System.out.println(nextHighestIndexOfValue(a, a.length- 1, 7));
        int[] b = {2, 6, 3, 4, 1, 2, 9, 5, 8};
        System.out.println(findSequenceLength(b));
    }
}
