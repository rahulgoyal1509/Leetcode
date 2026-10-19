class Solution {
    public int pathSum(int m, int n, int[][] grid, int[][] dp){
        if (m < 0 || n < 0) return Integer.MAX_VALUE;
        if (m == 0 && n == 0) return grid[m][n];

        if (dp[m][n] != -1) return dp[m][n];

        int val = Math.min(pathSum(m - 1, n, grid, dp), pathSum(m, n - 1, grid, dp));

        if (val == Integer.MAX_VALUE) return val;

        return dp[m][n] = grid[m][n] + val;
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        return pathSum(m - 1, n - 1, grid, dp);
    }
}