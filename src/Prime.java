/**
 * Algorithm to check if one or more non-consecutive (random sequence) is prime ot not.
 */
public class Prime {

    public void checkPrime(int... n) {
        for (int i = 0; i < n.length; i++) {
            int thisNum = n[i];
            if (thisNum == 2) {
                System.out.println(thisNum);
            }
            if ((thisNum%2)==0) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 3; j * j < thisNum; j+=2) {
                if (thisNum % j == 0) {
                    isPrime = false;
                    break;
                }
             }
            if (isPrime)
                System.out.println(thisNum);
        }

    }

    public static void main(String[] args) {
        new Prime().checkPrime(2,1,3,4,5, 10, 13, 15, 18, 17, 6, 309);
    }
}
