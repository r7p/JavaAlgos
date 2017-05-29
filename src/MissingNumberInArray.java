/**
 * Given an unsorted array of 1...n integers, find missing number
 */
public class MissingNumberInArray {

    public static void main(String[] args) {
        int[] a = {3, 6, 7, 1, 2, 4, 0, 9, 8};
        System.out.println("Should be 5 : " + tradeWebGetMissingNumber(a));
        System.out.println("Should be 5 : " + withXor(a));
    }

    /**
     * Sum of integers 1...N can be represented as N*(N+1)/2.  Sum given array and subtract from N*(N+1)/2 to get the number
     * Downside of this approach is, integer can overflow
     *
     * @param a array containing integers 1..n in random order.  One of the integer has been replaced with 0
     * @return
     */
    public static int tradeWebGetMissingNumber(int[] a) {
        int sum = 0, idx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                idx = i;
            } else {
                sum += a[i];
            }
        }
        int sumOfNumbers = (a.length * (a.length + 1))/2;
        return sumOfNumbers - sum;
    }

    public static int withXor(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                result ^= a[i];
            }
        }
        for (int i = 1; i <= a.length; i++) {
            result ^= i;
        }
        return result;
    }
}
