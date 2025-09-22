package neetcode.bloomberg;

import java.util.Objects;
import java.util.Stack;

public class CandyCrush {
    static String crush(String candy) {
        Stack<Tuple<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < candy.length(); i++) {
            Character thisChar = candy.charAt(i);

            if (stack.isEmpty()) {
                stack.push(new Tuple<>(thisChar, 1));
                continue;
            }

            if (stack.peek().x.compareTo(thisChar) == 0) {
                Tuple<Character, Integer> top = stack.pop();
                stack.push(new Tuple<>(thisChar, top.y + 1));
            } else {
                // change of character at this position
                if (stack.peek().y >= 3) {
                    // previous character appeared consecutively >= 3 times; crush it
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek().x.compareTo(thisChar) == 0) {
                        // thisChar has appeared previously, increment its count
                        Tuple<Character, Integer> top = stack.pop();
                        stack.push(new Tuple<>(thisChar, top.y + 1));
                    } else {
                        stack.push(new Tuple<>(thisChar, 1));
                    }
                } else {
                    stack.push(new Tuple<>(thisChar, 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Tuple<Character, Integer> top = stack.pop();
            if (top.y < 3) {
                // append to final result if only count is < 3
                sb.append(top.x);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String[] candies = {"aaaabbbc", "aabbccddeeedcba", "aaabbbacd", "aaaabbbc", "aabbbacd", "aabbbaacd", "dddabbbbaccccaax"};
        for (String candy: candies) {
            System.out.println(crush(candy));
        }
    }


    static class Tuple<X, Y> {
        final X x;
        final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple<?, ?> tuple = (Tuple<?, ?>) o;
            return x.equals(tuple.x) && y.equals(tuple.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
