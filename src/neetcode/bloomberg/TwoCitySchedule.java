package neetcode.bloomberg;

import java.util.Arrays;

public class TwoCitySchedule {

    static int findMinimumCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));

        int total = 0;
        // first half goes to city A
        for (int i = 0; i < costs.length / 2; i++) {
            total += costs[i][0];
        }
        // last half goes to city B
        for (int i = costs.length / 2; i < costs.length; i++) {
            total += costs[i][1];
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(findMinimumCost(costs));
    }
}
