class Solution {
    public int numDistinct(String s, String t) {
        //dp数组定义:dp[i][j]表示s[i]到之后包含t[j]到最后的个数
        int[][] dp = new int[s.length()+1][t.length()+1];
        if(s.length() < t.length()) return 0;
        for(int i = 0;i <= s.length();i++) {
            dp[i][t.length()] = 1;
        }
        for(int i = s.length() - 1;i >= 0;i--) {
            char sc = s.charAt(i);
            for(int j = t.length() - 1;j >= 0;j--) {
                char tc = t.charAt(j);
                if(sc == tc) {
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
