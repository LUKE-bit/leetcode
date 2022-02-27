class Solution {
    public int maxProfit(int[] prices) {
        //dp有四种状态：
        //买入股票的状态：今天买入股票，或者昨天买入股票没有操作
        //卖出股票的状态:昨天已经是卖出状态,或者前天卖出,冷冻一天,今天卖出
        //冷冻状态,共四种状态
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for(int i = 1;i < prices.length;i++) {
            dp[i][0] = Math.max(dp[i - 1][0],Math.max(dp[i - 1][3] - prices[i],dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];//达到今天卖出的状态,只能由昨天买入状态推导而来.
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][3],Math.max(dp[prices.length - 1][2],dp[prices.length - 1][1]));
    }
}
