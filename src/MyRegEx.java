import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Raj on 4/21/2016.
 */
public class MyRegEx {
    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inStr = in.next();
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        System.out.println(pattern.matcher(inStr).matches());
    }
}
