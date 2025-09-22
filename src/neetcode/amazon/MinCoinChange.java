package neetcode.amazon;

public class MinCoinChange {

    /**
     * e.g. If coins = {1, 2, 5} and S = 11
     * minCoins(11) = Math.min(minCoins(10), minCoins(9), minCoins(6)) + 1
     * In above, we solve 3(= number of denominations) sub-problems - use each denomination once to subtract
     * from target amount '11': i.e. 11-1=10, 11-2=9, 11-5=6.
     * Then we add 1 coin (initial selection) to minimum of 3 sub-problems
     *
     *
     *
     * Time complexity O(S^N) where S = amount and N = number of denominations
     * Space complexity O(S)
     *
     * @param coins
     * @param amount
     * @return
     */
    static int minChangeRecursive(int[] coins, int amount) {
        // base case
        if (amount == 0)
            return 0;

        int minCoins = Integer.MAX_VALUE;

        // Try each denomination
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int subResult = minChangeRecursive(coins, amount - coins[i]);
                // Check for INT_MAX to avoid overflow and see if result can be minimized
                if (subResult != Integer.MAX_VALUE && subResult + 1 < minCoins)
                    minCoins = subResult + 1;
            }
        }

        return minCoins;
    }

    /**
     * Time complexity O(S * N) where S = amount and N = number of denominations
     * Space complexity O(S)
     *
     * @param coins
     * @param amount
     * @return
     */
    static int minChangeDP(int[] coins, int amount) {
        if (amount <= 0)
            return 0;

        int[] dpTable = new int[amount + 1];
        for (int i = 1; i < dpTable.length; i++) {
            dpTable[i] = amount + 1;
        }
        // compute minimum number of coins required for amount 1...amount
        for (int i = 1; i < dpTable.length; i++) {
            // go through each denomination of coin for this amount 'i'
            for (int coin : coins) {
                if (coin <= i) {
                    dpTable[i] = Math.min(dpTable[i], dpTable[i - coin] + 1);
                }
            }
        }

        return dpTable[amount] != amount + 1 ? dpTable[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println("Amount 11, num coins " + minChangeRecursive(coins, 11));
        System.out.println("Amount 11, num coins " + minChangeDP(coins, 11));
    }
}
