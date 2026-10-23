class Solution {
    int maxSize = 0;

    int solve(int m, int n,char[][] matrix, int[][] dp){
        if (m >= matrix.length || n >= matrix[0].length) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        int right = solve(m, n + 1, matrix, dp);
        int down = solve(m + 1, n, matrix, dp);
        int diagonal = solve(m + 1, n + 1, matrix, dp);

        if (matrix[m][n] == '0') {
            dp[m][n] = 0;
        }
        else {
            dp[m][n] = 1 + Math.min(
                right, Math.min(down, diagonal)
            );
        }

        maxSize = Math.max(maxSize, dp[m][n]);
        return dp[m][n];
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        solve(0, 0, matrix, dp);
        return maxSize * maxSize;
    }
}