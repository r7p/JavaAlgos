import java.util.Arrays;

/**
 * Two strings are anagram if they both contains same characters.  Order of character in string may be different
 */
public class Anagram {

    public static void main(String[] args) {
        String s1 = "orchestra", s2 = "carterhos";
        System.out.println(countingCharacter(s1, s2));
        System.out.println(sortingMethod(s1, s2));
    }

    public static boolean countingCharacter(String s1, String s2) {
        int NUM_OF_LETTERS = 256; //assume ascii string

        if (s1 == null || s2 == null) {
            return false;
        }

        int length = s1.length();
        if (length != s2.length() || length < 2) {
            return false;
        }

        int[] count = new int[NUM_OF_LETTERS];
        for (int i = 0; i < length; i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < NUM_OF_LETTERS; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean sortingMethod(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        char[] s1char = s1.toCharArray();
        char[] s2char = s2.toCharArray();
        if (s1char.length != s2char.length || s2char.length < 2) {
            return false;
        }


        Arrays.sort(s1char);
        Arrays.sort(s2char);

        for (int i = 0; i < s1char.length; i++) {
            if (s1char[i] != s2char[i]) {
                return false;
            }
        }
        return true;
    }

}
