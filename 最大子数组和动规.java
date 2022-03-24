class Solution {
    public int maxSubArray(int[] nums) {
        //dp定义:i之前最大连续子数组和
        //递推:dp[i] = Math.max(nums[i],dp[i - 1] + nums[i]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for(int i = 1;i < nums.length;i++) {
            dp[i] = Math.max(nums[i],dp[i - 1] + nums[i]);
            if(dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
