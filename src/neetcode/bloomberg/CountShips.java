package neetcode.bloomberg;

public class CountShips {
    static int apiCallCount = 0;
    static boolean hasShips(int[] bottomLeft, int[] topRight) {
        apiCallCount++;
        // ships = [[1,1],[2,2],[3,3],[5,5]]
        if (bottomLeft[0] <= 1 && topRight[0] >= 1 && bottomLeft[1] <= 1 && topRight[1] >= 1) {
            return true;
        }
        if (bottomLeft[0] <= 2 && topRight[0] >= 2 && bottomLeft[1] <= 2 && topRight[1] >= 2) {
            return true;
        }
        if (bottomLeft[0] <= 3 && topRight[0] >= 3 && bottomLeft[1] <= 3 && topRight[1] >= 3) {
            return true;
        }
        if (bottomLeft[0] <= 5 && topRight[0] >= 5 && bottomLeft[1] <= 5 && topRight[1] >= 5) {
            return true;
        }
        return false;
    }


    static int countShips(int[] bottomLeft, int[] topRight) {

        if (bottomLeft[0] > topRight[0] || bottomLeft[1] > topRight[1]) {
            return 0;
        }

        // drop this rectangle area if it doesn't have any ships
        if (!hasShips(bottomLeft, topRight)) {
            return 0;
        }

        // if bottom left and top right converged, means it has a ship
        if (bottomLeft[0] == topRight[0] && bottomLeft[1] == topRight[1]) {
            return 1;
        }

        int midX = (bottomLeft[0] + topRight[0]) / 2;
        int midY = (bottomLeft[1] + topRight[1]) / 2;

        return countShips(new int[]{bottomLeft[0], midY + 1}, new int[]{midX, topRight[1]}) +
                countShips(new int[]{midX + 1, midY + 1}, new int[]{topRight[0], topRight[1]}) +
                countShips(new int[]{bottomLeft[0], bottomLeft[1]}, new int[]{midX, midY}) +
                countShips(new int[]{midX + 1, bottomLeft[1]}, new int[]{topRight[0], midY});
    }

    public static void main(String[] args) {
        int numOfShips = countShips(new int[]{0, 0}, new int[]{1000, 1000});
        System.out.println("Number of ships " + numOfShips + "; API calls " + apiCallCount);
    }
}

