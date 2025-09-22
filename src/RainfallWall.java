public class RainfallWall {

    static int calculator(final int[] walls) {

        System.out.println("Start to calculate on below graph:");

        int left = 0;
        int right = walls.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int leftPool = 0;
        int rightPool = 0;

        while (left < right) {
            if (walls[left] >= leftMax) {
                leftMax = walls[left];
            } else {
                leftPool += leftMax - walls[left];
            }

            if (walls[right] >= rightMax) {
                rightMax = walls[right];
            } else {
                rightPool += rightMax - walls[right];
            }

            if (leftMax <= rightMax) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Result for this graph: " + (leftPool + rightPool));
        System.out.println();

        return leftPool + rightPool;
    }

    public static void main(String[] args) {
        final int[] test3 = { 3, 1, 2, 1 };
        System.out.println(calculator(test3));

        final int[] test1 = { 2, 4, 1, 2, 3, 6, 5 };
        System.out.println(calculator(test1));

    }
}
