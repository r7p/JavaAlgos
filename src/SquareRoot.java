/**
 * Created by rpatel on 5/23/17.
 */
public class SquareRoot {

    /**
     *
     * Find square root of any integer by Babylonian method.
     *
     * Find initial estimate x0 (closer the better)
     * Calculate new estimate : average of (x0 + input/x0) = (x0 + input/x0)/2
     * repeate until you find new estimate that is equals to previous estimate
     *
     * @param inputNumber
     * @return
     */
    double findSqrt(int inputNumber) {

        if (inputNumber == 0) {
            return 0;
        }

        double curEstimate = inputNumber / 2 ;
        double newEstimate = (curEstimate + (inputNumber/curEstimate)) / 2;

        int countAttempt = 1;
        while (newEstimate != curEstimate) {
            curEstimate = newEstimate;
            newEstimate = (curEstimate + (inputNumber/curEstimate)) / 2;
            countAttempt++;
        }

        System.out.println("Total " + countAttempt + " attempts made");
        return newEstimate;
    }

    public static void main(String[] args) {
        SquareRoot sqrt = new SquareRoot();
        double sqrt1 = sqrt.findSqrt(12345);
        System.out.println("Square root of 12345 is : " + sqrt1 + " == " + sqrt1 * sqrt1);
    }

}
