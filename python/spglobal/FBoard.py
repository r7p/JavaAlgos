

class FBoard:

    def __init__(self):
        # construct and initialize the board
        self.__board = [['.' for col in range(8)] for row in range(8)]

        # put 4 o's pieces
        self.__board[5][7] = 'o'
        self.__board[6][6] = 'o'
        self.__board[7][5] = 'o'
        self.__board[7][7] = 'o'
        # current position of all o's pieces
        self.__o_pieces = [(5, 7), (6, 6), (7, 5), (7, 7)]

        # put 1 x's piece
        self.__board[0][0] = 'x'
        # current position of x's piece
        self.__x_piece = (0, 0)

        # initial game state
        self.__game_state = "UNFINISHED"

    def move_x(self, row, col):
        if not self._is_game_over() and self._is_x_move_allowed(row, col):
            # remove x piece from its current position on board
            self.__board[self.__x_piece[0]][self.__x_piece[1]] = '.'

            # update x's current position
            self.__x_piece = (row, col)
            self.__board[self.__x_piece[0]][self.__x_piece[1]] = 'x'

            print("Moved x piece to (" + str(row) + ", " + str(col) + ")")
            if row == 7 and col == 7:
                # Game over
                self.__game_state = "X_WON"
                print("Game Over: X won")
            return True
        else:
            return False

    def move_o(self, row_from, col_from, row_to, col_to):
        # from co-ordinate should hold o's piece
        o_pieces = [cord for cord in self.__o_pieces if cord[0] == row_from and cord[1] == col_from]
        if not self._is_game_over() and o_pieces and self._is_o_move_allowed(row_from, col_from, row_to, col_to):
            # remove o piece from its current position on board and update it new position
            self.__board[row_from][col_from] = '.'
            self.__board[row_to][col_to] = 'o'

            # update o's current pieces position
            remaining_pieces = [cord for cord in self.__o_pieces if cord[0] != row_from and cord[1] != col_from]
            remaining_pieces.append((row_to, col_to))
            self.__o_pieces = remaining_pieces

            print("Moved o piece from (" + str(row_from) + ", " + str(col_from) + ") -> (" + str(row_to) + ", " + str(col_to) + ")")
            if not self._does_x_have_move_left():
                # Game over
                self.__game_state = "O_WON"
                print("Game Over: O won")
            return True
        else:
            return False

    def get_game_state(self):
        return self.__game_state

    def print_board(self):
        print()
        print('\n'.join([' '.join([elem for elem in row]) for row in self.__board]))

    def _is_game_over(self):
        return self.__game_state == 'X_WON' or self.__game_state == 'O_WON'

    def _is_x_move_allowed(self, row, col):
        # is this move obstructed by o's pieces?
        o_pieces = [cord for cord in self.__o_pieces if cord[0] == row and cord[1] == col]
        if o_pieces:
            return False

        # x is allowed to move one square diagonally in any direction
        # possible combinations to apply to its co-ordinate are (-1, -1) (1, 1) (1, -1) and (-1, 1)
        cur_row = self.__x_piece[0]
        cur_col = self.__x_piece[1]
        possible_moves = [(cur_row, cur_col), (cur_row - 1, cur_col - 1), (cur_row + 1, cur_col + 1),
                          (cur_row + 1, cur_col - 1), (cur_row - 1, cur_col + 1)]

        # filter out co-ordinates that falls outside the board - they must be between 0 - 7 (both included)
        legal_moves = [cord for cord in possible_moves if 0 <= cord[0] < 8 and 0 <= cord[1] < 8]
        move = [cord for cord in legal_moves if cord[0] == row and cord[1] == col]
        if move:
            return True
        else:
            return False

    def _is_o_move_allowed(self, row_from, col_from, row, col):
        # is this move obstructed by other occupied pieces, including o's and x's?
        o_pieces = [cord for cord in self.__o_pieces if cord[0] == row and cord[1] == col]
        if o_pieces or (self.__x_piece[0] == row and self.__x_piece[1] == col):
            return False

        # o is allowed to move one square diagonally in any direction, except both row and col cannot increase
        # possible combinations to apply to its co-ordinate are (-1, -1) (1, -1) and (-1, 1)
        possible_moves = [(row_from - 1, col_from - 1), (row_from + 1, col_from - 1), (row_from - 1, col_from + 1)]

        # filter out co-ordinates that falls outside the board - they must be between 0 - 7 (both included)
        legal_moves = [cord for cord in possible_moves if 0 <= cord[0] < 8 and 0 <= cord[1] < 8]
        move = [cord for cord in legal_moves if cord[0] == row and cord[1] == col]
        if move:
            return True
        else:
            return False

    def _does_x_have_move_left(self):
        # x's possible moves
        cur_row = self.__x_piece[0]
        cur_col = self.__x_piece[1]
        possible_moves = [(cur_row - 1, cur_col - 1), (cur_row + 1, cur_col + 1),
                          (cur_row + 1, cur_col - 1), (cur_row - 1, cur_col + 1)]
        x_legal_moves = set([cord for cord in possible_moves if 0 <= cord[0] < 8 and 0 <= cord[1] < 8])
        if x_legal_moves and x_legal_moves.issubset(set(self.__o_pieces)):
            print("x has no moves left")
            return False
        return True


if __name__ == '__main__':
    board = FBoard()
    board.move_x(1, 1)
    board.move_x(1, 0)
    board.move_x(0, 1)
    board.move_x(0, 2)
    board.move_x(1, 2)
    board.move_x(1, 3)
    board.move_x(2, 2)
    board.move_o(6, 6, 5, 5)
    board.move_o(5, 5, 4, 4)
    board.move_o(4, 4, 3, 3)
    board.move_x(3, 3)
    board.move_o(3, 3, 2, 2)
    board.move_o(2, 2, 3, 3)
    board.print_board()
