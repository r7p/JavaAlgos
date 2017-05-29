import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Raj on 4/18/2016.
 */
public class Loop {
    public static void main(String[] args) {
        List<InputParam> params = new ArrayList<>();

        //Gather all inputs
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if (t < 0 || t > 500) {
            System.exit(0);
        }
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            if (a < 0 || a > 50 || b < 0 || b > 50 || n < 0 || n > 15) {
                continue;
            }
            params.add(new InputParam(a, b, n));
        }

        //Compute and print output
        for(InputParam param: params) {
            int a = param.getA();
            int b = param.getB();
            int n = param.getN();
            int thisResult = a;
            for(int i = 0; i < n; i++) {
                int v = ((int) Math.pow(2, i) * b);
                thisResult += v;
                System.out.print(thisResult + " ");
            }
            System.out.print("\n");
        }

    }

    private static class InputParam {
        private final int a, b, n;

        private InputParam(int a, int b, int n) {
            this.a = a;
            this.b = b;
            this.n = n;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getN() {
            return n;
        }
    }
}


