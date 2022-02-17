//贪心
class Solution {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0;i < prices.length;i++) {
            low = Math.min(low,prices[i]);
            result = Math.max(result,prices[i] - low);
        }
        return result;
    }
}
//动态规划
class Solution {
    public int maxProfit(int[] prices) {
        //dp[i][0]表示持有股票所得的最大金额
        //dp[i][1]表示不持有股票所得的最大金额
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1;i < prices.length;i++) {
            dp[i][0] = Math.max(dp[i - 1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],prices[i] + dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }
}
