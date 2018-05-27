/**
 * Created by rpatel on 5/23/17.
 */
public class Palindrome {

    boolean isPalindrome(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int length = s1.length();
        if (length != s2.length()) {
            return false;
        }

        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();

        for (int i = 0; i < length; i++) {
            int backward = length - 1 - i;
            if (char1[i] != char2[backward]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome x = new Palindrome();
        String s1 = "CAFMT", s2 = "TMDAC";
        System.out.println("Is palindrome " + x.isPalindrome(s1, s2));
    }
}
