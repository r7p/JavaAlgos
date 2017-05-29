/**
 * Created by Raj on 4/18/2016.
 */
public class Recursion {

    public static void main(String[] args) {
        new Recursion().factorial(5);
    }

    private int factorial(int number) {
        if (number == 1) {
            System.out.println("Base condition met.");
            return 1;
        } else {
            System.out.println("Recursive call for number " + number);
            int result = number * factorial(number - 1);
            System.out.println("Result for recursive call for number " + number + " is " + result);
            return result;
        }
    }
}
