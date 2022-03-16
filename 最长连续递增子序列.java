class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //dp数组定义:到i为止连续递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result = 0;
        int max = 1;
        for(int i = 1;i < nums.length;i++) {
            if(nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i],dp[i - 1] + 1);
                result = dp[i];
                max = Math.max(result,max);
            }else {
                result = 0;
            }
        }
        return max;
    }
}
