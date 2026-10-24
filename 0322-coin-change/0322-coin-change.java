class Solution {
    int solve(int remaining, int[] coins, int[] dp) {
        if (remaining == 0) return 0;

        if (dp[remaining] != -1) return dp[remaining];

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin <= remaining) {
                int result = solve(remaining - coin, coins, dp);
                if (result != Integer.MAX_VALUE) minCoins = Math.min(minCoins, 1 + result);
            }
        }

        return dp[remaining] = minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int result = solve(amount, coins, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}