class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];//dp数组为到（i，j）的路径条数
        //dp[i][j] = dp[i-1][j] + dp[i][j-1];
        for(int i = 0;i < m && obstacleGrid[i][0] == 0;i++) dp[i][0] = 1;
        for(int j = 0;j < n && obstacleGrid[0][j] == 0;j++) dp[0][j] = 1;

        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
