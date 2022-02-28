class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp数组定义:i之前包括i的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result = 0;
        for(int i = 0;i < nums.length;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            if(dp[i] > result) result = dp[i];
        }
        return result;
    }
}
