//给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段（ m 、 n 都是整数， n > 1 并且 m > 1 ， m <= n ），每段绳子的长度记为 k[1],...,k[m] 。请问 k[1]*k[2]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18 。

//数据范围： 2 \le n \le 602≤n≤60
//进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n)

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型 
     * @return int整型
     */
    public int cutRope (int n) {
        // write code here
        if(n <= 3){
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for(int i = 5;i <= n;i++) {
            for(int j = 1;j < i;j++) {
                dp[i] = Math.max(dp[i],j * dp[i - j]);
            }
        }
        return dp[n];
    }
}
