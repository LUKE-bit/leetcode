class Solution {
    public int integerBreak(int n) {
        //dp数组含义为i的最大乘积
        //dp[i] = Math.max(dp[i],Math.max(j * (i-j),j * dp[i-j])),j从1遍历到i-1
        //j * （i-j）的含义是两个数相乘，j * dp[i-j]则拆成了两个数以上的数乘积的最大值
        int[] dp = new int[n + 1];
        //0,1无意义，不初始化
        dp[2] = 1;
        for(int i = 3;i <= n;i++) {
            for(int j = 1;j < i - 1;j++) {
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),j * dp[i-j]));
            }
        }
        return dp[n];
    }
}
