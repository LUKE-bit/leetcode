import java.util.*;

// 给定一个由 '0' 和 '1' 组成的2维矩阵，返回该矩阵中最大的由 '1' 组成的正方形的面积。输入的矩阵是字符形式而非数字形式。

// 数据范围：矩阵的长宽满足 0 \le n \le 200≤n≤20,矩阵中的元素属于 {'1','0'}
// 进阶：空间复杂度 O(n^2)O(n 2) ， 时间复杂度 O(n^2)O(n 2)
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 最大正方形
     * @param matrix char字符型二维数组 
     * @return int整型
     */
    public int solve (char[][] matrix) {
        // write code here
        //dp定义：到i，j位置，最大正方形边长
        //递推: dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
        if(matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxSide = 0;
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
