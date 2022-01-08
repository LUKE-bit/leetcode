class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];//dp数组为到（m，n）路径的个数
        //递推公式dp[i][j] = dp[i][j-1] + dp[i-1][j];
        for(int j = 0;j < n;j++) {
            dp[0][j] = 1;
        }
        for(int i = 0;i < m;i++) {
            dp[i][0] = 1;
        }
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
