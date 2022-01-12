class Solution {
    public int lastStoneWeightII(int[] stones) {
        //这道题意思其实就是把这堆石头分成尽可能相同的两堆，用大的减小的就是最小的石头重量
        //那么dp定义为：放入容量（重量）为j的背包中，背包的最大重量
        //递推公式：dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
        //初始化：stone的最大重量为30 * 100 ，那一半就是15000，dp开这么大就够了
        //重量都是正整数，所以初始化为0即可
        int[] dp = new int[150000];
        dp[0] = 0;
        int sum = 0;
        for(int i = 0;i < stones.length;i++) {sum += stones[i];}
        int tar = sum / 2;
        for(int i = 0;i < stones.length;i++) {
            for(int j = tar;j >= stones[i];j--) {
                dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }
      
        //tar向下取整，所以重量小于一半，dp[tar] < sum - dp[tar]
        return (sum - dp[tar]) - dp[tar]; 
    }
}
