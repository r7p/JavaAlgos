/**
 * Created by Raj on 4/18/2016.
 */
public class OnDeck {

    public static void main(String[] args) {
        System.out.printf(reverse("the sky is blue"));
    }

    public static String reverse(String s) {
        String resultStr = "";
        int lastSpace = s.lastIndexOf(' ');
        int prevLastSpace = s.length();
        while (lastSpace != -1) {
            resultStr += s.substring(lastSpace+1, prevLastSpace);
            resultStr +=  " ";
            prevLastSpace = lastSpace;
            lastSpace = s.lastIndexOf(' ', lastSpace - 1);
            if (lastSpace == -1) {
                resultStr +=  s.substring(0, prevLastSpace);
            }
        }
        return resultStr;
    }
}
