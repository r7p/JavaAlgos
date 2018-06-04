import java.util.Arrays;

/**
 * Given MxN matrix, print all possible paths from (0,0) to (M, N)
 *
 */
public class PrintAllPaths {

    public static void main(String[] args) {
        int M = 3, N = 3;
        int[][] a = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = (i * 3) + (j + 1);
            }
        }
        int[] result = new int[a.length + a[0].length - 1];
        computeAllPaths(a, 0, 0, result, 0);

    }

    private static void computeAllPaths(int[][] input, int row, int col, int[] result, int resultPos) {

        if (row >= input.length || col >= input[0].length) {
            return;
        }

        //We reached end of the matrix, we're done - print the result array
        if (row == input.length -1 && col == input[0].length -1) {
            result[resultPos] = input[row][col];
            System.out.println(Arrays.toString(result));
            return;
        }

        result[resultPos] = input[row][col];
        computeAllPaths(input, row, col + 1, result, resultPos + 1);
        computeAllPaths(input, row + 1, col, result, resultPos + 1);

    }
}
