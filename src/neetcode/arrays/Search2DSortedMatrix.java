package neetcode.arrays;

public class Search2DSortedMatrix {
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        final int rows = matrix.length;
        final int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;
        while (start <= end) {
            final int mid = (start + end) / 2;
            final int thisRow = mid / cols;
            final int thisCol = mid % cols;
            if (matrix[thisRow][thisCol] == target) {
                return true;
            }
            if (matrix[thisRow][thisCol] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 2;
        System.out.println("Is " + target + " in matrix? " + searchMatrix(matrix, target));
        target = 3;
        System.out.println("Is " + target + " in matrix? " + searchMatrix(matrix, target));
    }
}
