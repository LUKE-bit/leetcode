class Solution {
    public int combinationSum4(int[] nums, int target) {
        //这是一道求组合个数的动规题
        //dp定义dp[j] 为凑成target j的元素组合的个数
        //nums里的数可以取无数个，所以是完全背包
        //递推公式：dp[j] += dp[j - nums[i]];
        //初始化：dp[0] = 1;
        //遍历顺序：因为排列顺序不同被当作不同组合，所以是求排列数，所以背包容量放在外面遍历
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int j = 0;j <= target;j++) {
            for(int i = 0;i < nums.length;i++) {
                if(j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
