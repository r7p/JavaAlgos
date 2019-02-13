public class BinaryExponential {

    public static void main(String[] args) {

        System.out.println(binpow(3, 13));
    }

    static long binpow(int a, int n) {
        long result = 1;
        while (n > 0) {
            if ( (n & 1) == 1) {
                result = result * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return result;
    }
}
