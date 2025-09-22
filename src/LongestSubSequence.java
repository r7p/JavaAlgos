import java.util.HashSet;
import java.util.Set;

/**
 * Created by rpatel on 5/26/17.
 */
public class LongestSubSequence {

    void longestSubSequence(int[] a) {
        int curSubSeqLength = 1, longestSubSeqLength = 1;
        int startIndex = 0, endIndex = 0;

        for(int i = 0; i < a.length -1; i++) {
            if (a[i] == a[i+1] - 1) {
                curSubSeqLength++;
                if (curSubSeqLength > longestSubSeqLength) {
                    longestSubSeqLength = curSubSeqLength;
                    startIndex = i + 2 - curSubSeqLength;
                    endIndex = i + 2;
                }
            } else {
                curSubSeqLength = 1;
            }
        }

        for (int i = startIndex; i < endIndex; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    public static void main(String[] args) {
        LongestSubSequence x = new LongestSubSequence();
        int[] arr = {3, 6, 5, 1, 9, 3, 2, 3, 4, 5, 1};
        x.longestSubSequence(arr);
        System.out.println(x.longestConsecutive(arr));
    }

}
