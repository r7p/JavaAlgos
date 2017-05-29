/**
 * You're given an unsorted array of integers where every integer appears exactly twice, except for one integer which appears only once.
 * Write an algorithm (in a language of your choice) that finds the integer that appears only once.
 */
public class OddManOut {
    int oddManOut(int[] array) {
        int val = 0;
        for (int i = 0; i < array.length; i++) {
            val ^= array[i];
        }

        return val;
    }

    public static void main(String[] args) {
        OddManOut object = new OddManOut();
        int[] input = new int[] {1, 3, 4, 5, 6, 5, 6, 4, 3, 2, 1};
        int i = object.oddManOut(input);
        System.out.println("Non dup element " + i);
    }
}
