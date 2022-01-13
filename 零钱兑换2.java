class Solution {
    public int change(int amount, int[] coins) {
        //dp数组定义，首先物品是不同面额的硬币，背包是总金额，dp[j]为总金额为j时不同的硬币组合数
        //这道题不是一道纯完全背包问题，它不是要凑成总金额，而是要求凑成总金额的组合数的个数，
        //递推公式：dp[j] += dp[j - coins[i]];这里的递推公式我之前的博客有写过
        //初始化：dp[0] = 1,不然累加全是0；
        //遍历顺序，先遍历物品，再遍历背包容量，不然算的是排列数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0;i < coins.length;i++) {
            for(int j = coins[i];j <= amount;j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
