import java.util.ArrayList;
import java.util.List;

/**
 * Parse comma separated string, take into consideration double-quotes (") used as escape sequence: ignore commas
 * inside double-quotes
 *
 */
public class ParseCSV {

    private static List<String> parseString(String input) {
        List<String> result = new ArrayList<>();

        int tokenStartIndex = 0;
        boolean inQuote = false;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '\"') {
                inQuote = !inQuote;
            }
            if (i == input.length() - 1) {
                result.add(input.substring(tokenStartIndex));
            } else if (c == ',' && !inQuote) {
                result.add(input.substring(tokenStartIndex, i));
                tokenStartIndex = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "foo,bar,c;qual=\"baz,blurb\",d;junk=\"quux,syzygy\"";
        System.out.println(parseString(input));
    }
}
