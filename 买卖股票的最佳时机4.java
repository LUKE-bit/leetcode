class Solution {
    public int maxProfit(int k, int[] prices) {
        //dp数组定义；第i天状态为j时，所得利润的最大值
        //j为0为不操作，1为第一次买入，2为第一次卖出...奇数买入，偶数卖出
        if(prices.length == 0) {
            return  0;
        }
        int[][] dp = new int[prices.length][2 * k + 1];
        for(int j = 1;j < 2 * k;j+=2) {
            dp[0][j] = -prices[0];
        }
        for(int i = 1;i < prices.length;i++) {
            for(int j = 0;j < 2 * k - 1;j+=2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1],dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2],dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
