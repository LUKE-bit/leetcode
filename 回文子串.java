class Solution {
    public int countSubstrings(String s) {
        //dp定义:从开始位置i到结束位置j是否时回文串
        //递推:s[i] != s[j],false,否则j-i < 3,true,>则等于dp[i+1][j-1];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int j = 0;j < s.length();j++) {
            for(int i = 0;i <= j;i++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j - i < 3) dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }
        int result = 0;
        for(int j = 0;j < s.length();j++) {
            for(int i = 0;i <= j;i++) {
                if(dp[i][j]) result++;
            }
        }
        return result;
    }
}

//第二种解法:回文中心
class Solution {
    public int countSubstrings(String s) {
        //另一种解法:求回文中心
        int len = s.length();
        int result = 0;
        for(int i = 0;i < len;i++) {
            for(int j = 0;j <= 1;j++) {
                int l = i;
                int r = i+j;
                while(l >= 0 && r < len && s.charAt(l--) == s.charAt(r++)) result++;
            }
        }
        return result;
    }
}
