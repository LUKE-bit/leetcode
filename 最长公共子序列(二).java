import java.util.*;


public class Solution {
    /**
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
        // write code here
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 == 0 || len2 == 0) return "-1";
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0;i < len1 + 1;i++) {
            for(int j = 0;j < len2+1;j++) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                    continue;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int s1l = len1,s2l = len2;
        while(s1l != 0 && s2l != 0) {
            if(s1.charAt(s1l-1) == s2.charAt(s2l-1)) {
                sb.append(s1.charAt(s1l-1));
                s1l--;
                s2l--;
            }else{
                if(dp[s1l-1][s2l] > dp[s1l][s2l-1]){
                    s1l--;
                }else{
                    s2l--;
                }
            }
        }
        if(sb.length()==0){
            return "-1";
        }
        return sb.reverse().toString();
    }
}
