class Solution {
    public int checkPath(int m, int n, int[][] obstacleGrid, int[][] dp){
        if (m < 0 || n < 0) return 0;
        if (obstacleGrid[m][n] == 1) return 0;

        if (m == 0 && n == 0) return 1;

        if (dp[m][n] != -1) return dp[m][n];

        return dp[m][n] = checkPath(m - 1, n, obstacleGrid, dp) + checkPath(m, n - 1, obstacleGrid,dp);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        return checkPath(m - 1, n - 1, obstacleGrid, dp);
    }
}