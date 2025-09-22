package neetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    static boolean isValid(String[][] board) {
        Set<String> tracker = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // when cell on the board is pre-filled
                String cellValue = board[i][j];
                if (cellValue != ".") {
                    // check if this row/column doesn't contain duplicate
                    if (tracker.contains("row" + i + cellValue) || tracker.contains("col" + j + cellValue)) {
                        return false;
                    }
                    tracker.add("row" + i + cellValue);
                    tracker.add("col" + j + cellValue);
                    // check if current box (3 x 3 cell) doesn't contain duplicate
                    if (tracker.contains("box" + (i/3) + (j/3) + cellValue)) {
                        return false;
                    }
                    tracker.add("box" + (i/3) + (j/3) + cellValue);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] board = {{"5","3",".",".","7",".",".",".","."}
                            ,{"6",".",".","1","9","5",".",".","."}
                            ,{".","9","8",".",".",".",".","6","."}
                            ,{"8",".",".",".","6",".",".",".","3"}
                            ,{"4",".",".","8",".","3",".",".","1"}
                            ,{"7",".",".",".","2",".",".",".","6"}
                            ,{".","6",".",".",".",".","2","8","."}
                            ,{".",".",".","4","1","9",".",".","5"}
                            ,{".",".",".",".","8",".",".","7","9"}};
        // must return true
        System.out.println(isValid(board));

        String[][] invalidBoard = {{"8", "3", ".", ".", "7", ".", ".", ".", "."}
                                , {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                                , {".", "9", "8", ".", ".", ".", ".", "6", "."}
                                , {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                                , {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                                , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                                , {".", "6", ".", ".", ".", ".", "2", "8", "."}
                                , {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                                , {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        // must return false
        System.out.println(isValid(invalidBoard));
    }
}
