import java.util.*;


public class Solution {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        int[][] dp = new int[str1.length()+1][str2.length()+1];//0-i-1
        int max = 0;
        int right = 0;
        for(int i = 0;i < str1.length();i++) {
            for(int j = 0;j < str2.length();j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(dp[i+1][j+1] > max) {
                        max = dp[i+1][j+1];
                        right = i;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return str1.substring(right - max+1,right+1);
    }
}
