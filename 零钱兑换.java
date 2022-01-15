class Solution {
    public int coinChange(int[] coins, int amount) {
        //凑成总金额的最小硬币总数，可以尝试动态规划
        //dp数组定义：凑成金额i最少的硬币个数为dp[i]
        //dp[j]由dp[j - coins[i]]得来，所以凑成总金额只需再加一枚硬币即可，
        //即dp[j] = dp[j - coins[i]] + 1,所以dp[j]要在其中找最小的，
        //递推公式：dp[j] = Math.min(dp[j - coins[i]] + 1);
        //初始化：dp[0] = 0，其余的要初始化为最大值，否则会在最小值比较时被初始值覆盖
        //遍历顺序：无所谓，都不影响最少的硬币数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        for(int i = 1;i < dp.length;i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i < coins.length;i++) {
            for(int j = coins[i];j <= amount;j++) {
                if(dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
