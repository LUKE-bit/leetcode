class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        if(nums.length == 1) return nums[0];
        int money1 = robbery(nums,0,nums.length - 2);
        int money2 = robbery(nums,1,nums.length - 1);
        return money1 > money2 ? money1 : money2;
    }
    public int robbery(int[] nums,int start,int end) {
        if(start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start],nums[start + 1]);
        for(int i = start + 2;i <= end;i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2],dp[i - 1]);
        }
        return dp[end];
    }
}
