class Solution {
    public int findPath(int m, int n, int[][] dp){
        if (m == 0 || n == 0) return 1;

        if (dp[m][n] != -1) return dp[m][n];

        return dp[m][n] = findPath(m - 1, n, dp) + findPath(m, n - 1, dp);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        return findPath(m - 1, n - 1, dp);
    }
}