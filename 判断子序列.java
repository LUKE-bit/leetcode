class Solution {
    public boolean isSubsequence(String s, String t) {
        //dp定义:dp[i][j]为到i-1,j-1最长子序列的长度
        //递推:相等,dp[i][j] = dp[i-1][j-1] + 1;
        //不相等,dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 1;i <= s.length();i++) {
            for(int j = 1;j <= t.length();j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        if(dp[s.length()][t.length()] != s.length()) {
            return false;
        }
        return true;
    }
}
