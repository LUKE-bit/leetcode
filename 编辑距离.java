class Solution {
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示以下标i-1的word1,到下标j-1的word2,最短编辑距离
        //递推:word1[i]==word2[j] dp[i][j] = dp[i-1][j-1];
        //word1[i]!=word2[j],有三种情况,删增替
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 1;i <= word1.length();i++) dp[i][0] = i;
        for(int j = 1;j <= word2.length();j++) dp[0][j] = j;
        for(int i = 1;i <= word1.length();i++) {
            for(int j = 1;j <= word2.length();j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j] + 1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
