import java.util.Arrays;

/**
 * Created by rajeshpatel on 5/30/17.
 */
public class PrimeSieve {
    void sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n+1];

        //Initially set all number to be prime
        Arrays.fill(isPrime, true);

        //0 and 1 is not prime
        isPrime[0] = false;
        isPrime[1] = false;

        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                //mark all multiples of this number as not prime
                for (int j = factor; factor * j <= n; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i <= n; i++) {
            if (isPrime[i]) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(i);
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        PrimeSieve x = new PrimeSieve();
        x.sieveOfEratosthenes(10_000);
    }
}
