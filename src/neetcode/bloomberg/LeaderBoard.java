package neetcode.bloomberg;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeaderBoard {
    private final Map<Integer, Integer> scores = new HashMap<>();

    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }

    public void reset(int playerId) {
        scores.put(playerId, 0);
    }

    public int top(int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> thisEntry: scores.entrySet()) {
            queue.offer(thisEntry.getValue());
            if (queue.size() > k) {
                queue.poll();
            }
        }

        // add all top scores
        int total = 0;
        while (!queue.isEmpty()) {
            total += queue.poll();
        }
        return total;
    }

    public static void main(String[] args) {
        LeaderBoard leaderboard = new LeaderBoard ();
        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        int topOne = leaderboard.top(1);// returns 73;
        System.out.println(topOne);
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        int topThree = leaderboard.top(3);// returns 141 = 51 + 51 + 39;
        System.out.println(topThree);

    }
}
