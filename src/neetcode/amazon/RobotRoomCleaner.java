package neetcode.amazon;


import java.util.*;

public class RobotRoomCleaner {
    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();
        void turnRight();

        // Clean the current cell.
        void clean();
    }

    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    Set<String> visited = new HashSet<>();
    Robot robot;

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    /**
     *
     *
     * @param row
     * @param col
     * @param startDirection  Direction from which this backtracking should start from
     */
    private void backtrack(int row, int col, int startDirection) {
        // could've done visited.add(x + "," + y) to avoid using 'Tuple' object
        visited.add(row + "," + col);
        robot.clean();
        // move the robot in clockwise direction : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            // we want backtrack call to continue in previous direction (startDirection), i.e. move robot in straight
            // line until it encounter obstacle or already visited cell.
            int newDirection = (startDirection + i) % 4;
            int newRow = row + directions[newDirection][0];
            int newCol = col + directions[newDirection][1];

            if (!visited.contains(newRow + "," + newCol) && robot.move()) {
                backtrack(newRow, newCol, newDirection);
                goBack();
            }
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    public static void main(String[] args) {
        RobotRoomCleaner cleaner = new RobotRoomCleaner();
        Robot robot = new iRobot();
        cleaner.cleanRoom(robot);
        System.out.println("Room is cleaned");
    }

    static class iRobot implements Robot {
        // starting position of robot; robot can start at any point in matrix
        int row = 0, col = 0;
        // starting direction of robot - 'up' (index of array 'directions' below)
        int curDirection = 0;

        // 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        // assume 5 x 8 matrix with following obstacles
        Set<String> obstacles = new HashSet<>(
                Arrays.asList("2,1", "3,0", "3,1", "3,2", "3,4", "3,5", "3,6", "3,7", "0,5", "1,5"));

        // non-functional
        int numMoves = 0;

        @Override
        public boolean move() {
            int newRow = row + directions[curDirection][0];
            int newCol = col + directions[curDirection][1];
            if (isValidMove(newRow, newCol)) {
                row = newRow;
                col = newCol;
                System.out.println("Moved to (" + row + ", " + col + ")");
                numMoves++;
                return true;
            }
            return false;
        }

        @Override
        public void turnLeft() {
            // turning left from current direction
            curDirection = (curDirection + 3) % 4;
        }

        @Override
        public void turnRight() {
            curDirection = (curDirection + 1) % 4;
        }

        @Override
        public void clean() {
            System.out.println("Cleaned (" + row + ", " + col + ")");
        }

        private boolean isValidMove(int newRow, int newCol) {
            // make sure new row & col is within bound of our 5 x 8 matrix
            if (newRow >=0 && newRow <= 4 && newCol >=0 && newCol <= 7) {
                // check if it is not impeded by an obstacle
                return !obstacles.contains(newRow + "," + newCol);
            }
            return false;
        }
    }


}
