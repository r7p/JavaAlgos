package neetcode.arrays;

public class KokoEatingBananas {
    /**
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
     *
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
     * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
     *
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     *
     * Return the minimum speed (bananas/hour) that Koko has to eat such that she can eat all the bananas within h hours.
     *
     * Time complexity if O(nLogm) where n = piles.length, m = maximum number of bananas in a pile (i.e. maxSpeed)
     * Space complexity is O(1)
     *
     * @param piles
     * @param h
     * @return
     */
    static int minEatingSpeed(int[] piles, int h) {
        // minimum and maximum banana eating speed (per hour)
        int minSpeed = 1;
        int maxSpeed = 1;
        // assign maxSpeed = the largest pile of bananas per hour
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while (minSpeed < maxSpeed) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int avgSpeed = (minSpeed + maxSpeed) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent eating bananas in all poles by avgSpeed.
            // We will round up (i.e. ceiling) hourSpent as required by question
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / avgSpeed);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent == h) {
                return avgSpeed;
            } else if (hourSpent < h) {
                // banana eating speed was too much (> h), reduce maxSpeed to avgSpeed
                maxSpeed = avgSpeed;
            } else {
                // banana eating speed was slow to finish the piles in given 'h' hour.  Increase minSpeed
                minSpeed = avgSpeed + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return maxSpeed;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int hours = 8;
        System.out.println("Minimum speed required " + minEatingSpeed(piles, hours) + " bananas/hour");
        int[] piles2 = {30,11,23,4,20};
        hours = 5;
        System.out.println("Minimum speed required " + minEatingSpeed(piles2, hours) + " bananas/hour");
        hours = 6;
        System.out.println("Minimum speed required " + minEatingSpeed(piles2, hours) + " bananas/hour");
    }
}
