package neetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    /**
     * Find the longest substring in a given string without repeating characters.
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * @param s
     * @return
     */
    static int findLongestSubString(String s) {
        Map<Character, Integer> chars = new HashMap<>();

        int current = 0;
        int curSeqCount = 0;
        int result = 0;
        while (current < s.length()) {
            char c = s.charAt(current);
            chars.put(c, chars.getOrDefault(c, 0) + 1);

            if (chars.get(c) > 1) {
                Integer thisCharCount = chars.get(c);
                chars.put(c, thisCharCount - 1);
                result = Math.max(result, curSeqCount);
                curSeqCount = 1;
            } else {
                curSeqCount += 1;
            }
            current++;
        }

        return Math.max(result, curSeqCount);
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubString("pwwkew"));
        System.out.println(findLongestSubString("abcdabcbb"));
        System.out.println(findLongestSubString("bbbbbb"));
    }
}
