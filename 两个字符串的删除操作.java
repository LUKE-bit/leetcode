class Solution {
    public int minDistance(String word1, String word2) {
        //这道题本质就是找word1,word2的相同子序列的长度,然后两个中短的一减就行了
        //dp定义:dp[i][j]表示i到后和j到后子序列的长度
        //递推:word1[i] == word2[j]时,dp[i][j] = dp[i+1][j+1] + 1;
        //不一样,dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = word1.length() - 1;i >= 0;i--) {
            char w1 = word1.charAt(i);
            for(int j = word2.length() - 1;j >= 0;j--) {
                char w2 = word2.charAt(j);
                if(w1 == w2) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return word1.length() + word2.length() - dp[0][0] * 2;
    }
}
