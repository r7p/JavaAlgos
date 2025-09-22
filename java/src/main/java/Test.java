import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        String[] logins = new String[] {"bag","cbh","sfe", "red","cbh"};
        int ans = 0;

        Set<String> family = new HashSet<>();
        for(String w: logins) {

            StringBuilder sb = new StringBuilder();
            for(char c: w.toCharArray()) {
                sb.append(getNextChar(c));
            }
            family.add(sb.toString());
        }
        for(String w: logins) {
            if (family.contains(w))
                ans++;
        }

        System.out.println("Pairs are " + ans);

    }

    static char getNextChar(char c) {
        if (c == 'z') {
            return 'a';
        } else {
            return (char) (c + 1);
        }
    }
}
