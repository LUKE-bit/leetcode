class Solution {
    public boolean canPartition(int[] nums) {
        //dp[j]：背包容量为j，本体j指目标sum/2，dp[j]为最大可以组成j的自己总和
        //weight为nums[i],value为nums[i]
        //递推公式为dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) {
            return false;
        }
        int tar = sum / 2;
        int[] dp = new int[tar + 1];
        dp[0] = 0;
        for(int i = 0;i < nums.length;i++) {
            for(int j = tar;j >= nums[i];j--) {
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[tar] == tar; 
    }
}
