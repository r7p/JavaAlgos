package neetcode.bloomberg;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 *
 */
public class BalanceParenthesis {

    static String makeValidString(String str) {
        int n = str.length();

        // removes invalid ')'
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for(int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            } else if (c == ')') {
                if (balance == 0)
                    continue;
                else
                    balance--;
            }
            sb.append(c);
        }

        // remove rightmost invalid '('
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) continue;
            }
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeValidString("a(b(a(c)fg)9"));
    }
}
