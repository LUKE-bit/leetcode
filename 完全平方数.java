class Solution {
    public int numSquares(int n) {
        //dp定义：dp[i] 总和为i的最少完全平方数的个数
        //递推公式：dp[j] = Math.min(dp[j],dp[j - i * i] + 1);
        //初始化：dp[0] = 0,其余最大
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int max = Integer.MAX_VALUE;
        for(int i = 1;i <= n;i++) {
            dp[i] = max;
        }
        for(int i = 1;i * i <= n;i++) {//物品
            for(int j = 0;j <= n;j++) {//背包容量
                if(j - i *i >= 0) {
                    dp[j] = Math.min(dp[j],dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
