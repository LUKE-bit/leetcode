class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //dp数组定义:dp[i][j]为num1下标为i-1和nums2下标j-1的最长子数组长度
        //初始化:dp[i][0]与dp[0][j]无意义,但要初始化为0
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;
        for(int i = 1;i <= nums1.length;i++) {
            for(int j = 1;j <= nums2.length;j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if(dp[i][j] > result) result = dp[i][j];
            }
        }
        return result;
    }
}
