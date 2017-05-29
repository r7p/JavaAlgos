import java.util.Scanner;

/**
 * Created by Raj on 4/19/2016.
 */
public class Array1D1 {

    public static void main(String[] args) {
        //Gather all inputs
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 0 || n > 500) {
            System.exit(0);
        }
        int[] ar = new int[n];
        for (int i = 0; i < n ; i++) {
            ar[i] = in.nextInt();
        }

        int subArrayCount = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += ar[j];
                if (sum < 0) {
                    subArrayCount++;
                }
            }
        }
        System.out.println(subArrayCount);

    }
}
