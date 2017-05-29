import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Raj on 4/21/2016.
 */
public class Combination {
    static String inputstring;
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) {
        String inStr = "bac";
        char[] chars = inStr.toCharArray();
        Arrays.sort(chars);
        inputstring = new String(chars);
        //combine(0);
       // System.out.println(allStringsI(inStr));
        comb1("", "abc");

    }

    private static void comb1(String prefix, String s) {
        if (s.length() > 0) {
            System.out.println(prefix + s.charAt(0));
           // comb1(prefix + s.charAt(0), s.substring(1));
            comb1(prefix,               s.substring(1));
            comb1(prefix + s.charAt(0), s.substring(1));
        }
    }




    public static ArrayList<String> allStringsI(String s) {
        ArrayList<String> retVal = new ArrayList<String>();
        retVal.add("");

        if (s == null || s.length() == 0)
            return retVal;

        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            ArrayList<String> loop = retVal;
            retVal = new ArrayList<String>();

            for (String st: loop){
                retVal.add(c+st);

                for (int j = 1; j <= st.length(); j++)
                    retVal.add(st.substring(0, j) + c + st.substring(j));
            }
        }
        return retVal;
    }
}
