/**
 * Recursive Backtracking example
 * Place n queens on n x n chess board such that they do not attack each other.
 * Queen attacks in all 4 direction and diagnolly.
 */
public class EightQueen {

    private static boolean queensHelper(Board board, int column) {
        if (column > 7) {
            //print board
            board.print();
            return true;
        } else {
            for (int row = 0; row < board.size; row++) {
                if (board.isSafeHere(row, column)) {
                    //choose
                    board.place(row, column);
                    //explore
                    boolean finished = queensHelper(board, column + 1);
                    if (finished) {
                        return true;
                    }
                    //un choose
                    board.remove(row, column);
                }
            }
        }
        return false;
    }

    /**
     * (0, 0) based square chess board
     *
     */

    static class Board {
        final int[][] board;
        final int size;
        Board(int size) {
            this.board = new int[size][size];
            this.size = size;
        }

        void place(int row, int column) {
            board[row][column] = 1;
        }

        void remove(int row, int column) {
            board[row][column] = 0;
        }

        boolean isSafeHere(int row, int column) {
            for(int i = 0; i < size; i++) {
                if (board[row][i] == 1) {
                    return false;
                }
            }
            for(int j = 0; j < size; j++) {
                if (board[j][column] == 1) {
                    return false;
                }
            }
            // Check diagonal down and right
            for (int i = row, j = column; i < size && j < size; i++, j++)
                if (board[i][j] == 1)
                    return false;

            // Check diagonal up and left
            for (int i=row, j=column; i >=0 && j >=0 ; i--, j--)
                if (board[i][j] == 1)
                    return false;

            // Check diagonal up and right
            for (int i = row, j = column; i >=0 && j < size; i--, j++)
                if (board[i][j] == 1)
                    return false;

            // Check diagonal down and left
            for (int i = row, j = column; i < size && j >=0 ; i++, j--)
                if (board[i][j] == 1)
                    return false;

            // Must be safe
            return true;
        }

        void print() {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    System.out.printf("%4d", board[row][col]);
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        queensHelper(new Board(8), 0);
    }
}
