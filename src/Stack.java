import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by Raj on 4/21/2016.
 */
public class Stack {

    public static void main(String[] args) {
        Parser X=new Parser();
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(X.checkParenthesisBalance(in.next()));
        }

    }

    private static class Parser {

        public boolean checkParenthesisBalance(String inString) {
            if (inString.isEmpty()) {
                return true;
            }

            java.util.Stack<Character> stack = new java.util.Stack<>();
            stack.clear();
            boolean failed = false;
            char[] chars = inString.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                switch (chars[i]) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(chars[i]);
                        break;
                    case ']':
                        failed = stack.size() == 0 || (stack.pop() != '[');
                        break;
                    case ')':
                        failed = stack.size() == 0 || (stack.pop() != '(');
                        break;
                    case '}':
                        failed = stack.size() == 0 || (stack.pop() != '{');
                        break;
                    default:
                       return false;
                }
            }
            failed |= (stack.size() != 0);
            return !failed;
        }
    }
}
