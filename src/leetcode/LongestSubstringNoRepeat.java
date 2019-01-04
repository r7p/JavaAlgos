package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeat {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("tmmzutx"));
    }

    static int lengthOfLongestSubstring(String s) {
        int i = 0, longest = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0; j < s.length(); j++) {
            Character thisChar = Character.valueOf(s.charAt(j));
            if (map.containsKey(thisChar)) {
                i = Math.max(map.get(thisChar) + 1, i);
            }
            longest = Math.max(longest, j - i + 1);
            map.put(thisChar, j);
        }
        return longest;
/*        char[] chars = s.toCharArray();
        Set<Character> charsSoFar = new HashSet<>();
        ArrayDeque<Character> seq = new ArrayDeque<>();
        int longest = 0;

        for (int i = 0; i < chars.length; i++) {
            Character thisChar = Character.valueOf(chars[i]);
            if (charsSoFar.contains(thisChar)) {
                longest = Math.max(longest, seq.size());
                //remove Characters from linked list upto thisChar
                while (!seq.isEmpty() && seq.pop() != thisChar) {

                }
                charsSoFar = new HashSet<>();
                Iterator<Character> iterator = seq.iterator();
                while (iterator.hasNext()) {
                    charsSoFar.add(iterator.next());
                }
            }
            charsSoFar.add(thisChar);
            seq.offer(thisChar);
        }

        return Math.max(longest, seq.size());*/
    }
}
