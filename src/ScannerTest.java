import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Raj on 4/18/2016.
 */
public class ScannerTest {
    public static void main(String[] args) {
        //Input
//
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n];
        for(int i=0;i<n;i++)
        {
            s[i]=sc.next();
        }


       // String[] s = {"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};
        //Write your code here
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (new BigDecimal(o2)).compareTo(new BigDecimal(o1));
            }
        });


        //Output
        for(int i=0;i<s.length;i++)
        {
            System.out.println(s[i]);
        }
    }
}
