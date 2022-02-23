class Solution {
    public int maxProfit(int[] prices) {
        //每一天有五种状态，
        //0代表没有操作，1代表第一次买入，2代表第一次卖出，3代表第二次买入，4代表第二次卖出
        //dp数组的定义为第i天所处状态所得利润最大值
        int[][] dp = new int[prices.length][5];
        //dp初始化，dp[0][1] = -prices[0],dp[0][2] = 0,dp[0][3]第二次买入该初始化多少呢？
        //就相当于你在第一天买了又卖了，所以再买就是-prices[0],dp[0][4] = 0
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for(int i = 1;i < prices.length;i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3],dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4],dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}
