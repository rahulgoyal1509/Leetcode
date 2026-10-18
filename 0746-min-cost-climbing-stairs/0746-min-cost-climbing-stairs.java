class Solution {
    public int solve(int n, int[] cost, int[] dp){
        if (n <= 1) return 0;

        if (dp[n] != -1) return dp[n];

        return dp[n] = Math.min((cost[n - 2] + solve(n - 2, cost, dp)), cost[n - 1] + solve(n - 1, cost, dp));

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);

        return solve(n, cost, dp);
    }
}