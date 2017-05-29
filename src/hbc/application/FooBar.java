package hbc.application;

/**
 * Created by Raj on 4/25/2016.
 */
public class FooBar {

    public static void main(String[] args) {
        new FooBar().printFooBar();
    }

    public void printFooBar() {

        for(int i=1; i <= 100; i++) {
            boolean multipleOf3 = ((i % 3) == 0);

            boolean multipleOf5 = ((i % 5) == 0);

            if (multipleOf3 && multipleOf5) {
                System.out.println("FooBar");
            } else if (multipleOf3) {
                System.out.println("Foo");
            } else if (multipleOf5) {
                System.out.println("Bar");
            } else {
                System.out.println(i);
            }
        }

    }
}
