import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @param pattern string字符串 
     * @return bool布尔型
     请实现一个函数用来匹配包括'.'和'*'的正则表达式。
      1.模式中的字符'.'表示任意一个字符
      2.模式中的字符'*'表示它前面的字符可以出现任意次（包含0次）。
     */
    public boolean match (String str, String pattern) {
        // write code here
        int n1 = str.length();
        int n2 = pattern.length();
        boolean[][] dp = new boolean[n1+1][n2+1];
        for(int i = 0;i <= n1;i++){
            for(int j = 0;j <= n2;j++){
                if(j==0){
                    dp[i][j] = (i==0?true:false);
                }else{
                    if(pattern.charAt(j-1)!='*'){
                        if(i>0&&(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1)=='.')){
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }else{
                        if(i >= 1 && j >= 2 && (str.charAt(i-1) == pattern.charAt(j-2) || pattern.charAt(j-2) == '.')){
                            dp[i][j] = dp[i-1][j] || dp[i][j-2];
                        }else{
                            dp[i][j] = dp[i][j-2];
                        }
                    }
                }
            }
        }
        return dp[n1][n2];
    }
}
