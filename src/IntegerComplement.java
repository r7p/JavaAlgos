import java.util.Scanner;

/**
 * Created by Raj on 4/21/2016.
 */
public class IntegerComplement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine());

        res = getIntegerComplement(_n);
        System.out.println(res);

    }
    static int getIntegerComplement(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        char[] resultChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                resultChars[i] = '0';
            } else {
                resultChars[i] = '1';
            }
        }
        return Integer.parseInt(new String(resultChars), 2);

    }
}
