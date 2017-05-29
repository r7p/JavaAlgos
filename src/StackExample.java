import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Raj on 4/19/2016.
 */
public class StackExample {
    public static void main(String[] args) {
        int [] a[];
        //Gather all inputs
        Scanner in = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while (in.hasNext()) {
            String input = in.next();
            inputs.add(input);
        }
        for(String input:inputs) {
            char[] chars = input.toCharArray();
            int parenthesis = 0, bracket = 0, curly = 0;
            for (int i = 0; i < chars.length; i++) {
                switch (chars[i]) {
                    case '(':
                        parenthesis++;
                        break;
                    case ')':
                        parenthesis--;
                        break;
                    case '[':
                        bracket++;
                        break;
                    case ']':
                        bracket--;
                        break;
                    case '{':
                        curly++;
                        break;
                    case '}':
                        curly--;
                        break;
                }
            }
            if (parenthesis == 0 && bracket == 0 && curly == 0) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }

}
