package Dataminr;

import java.util.ArrayList;
import java.util.List;

/**
 * Print matrix in spiral order
 */
public class SpiralOrder {

    List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;


    }

    public static void main(String[] args) {
        SpiralOrder x = new SpiralOrder();
        //define matrix
        int[][] matrix = new int[5][4];
        int valCount = 0;
        for(int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                matrix[i][j] = valCount++;
            }
        }
        x.printMatrix(matrix);

        List<Integer> result = x.spiralOrder(matrix);
        System.out.println(result);

    }

    void printMatrix(int[][] matrix) {
        for(int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                System.out.print(String.format("%5s", matrix[i][j]));
            }
            System.out.println("");
        }
    }
}
