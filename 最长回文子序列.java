class Solution {
    public int longestPalindromeSubseq(String s) {
        //dp数组定义:dp[i][j]表示下标i到j的最长的回文子序列的长度
        //递推:s[i]==s[j],dp[i][j] = dp[i + 1][j - 1] + 2;
        //不等于:dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
        //初始化:i,j相等时无法计算,所以初始化为1,其他为0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0;i < len;i++) dp[i][i] = 1;

        for(int i = len - 1;i >= 0;i--) {
            for(int j = i + 1;j < len;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
