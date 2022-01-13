class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //这道题其实是一个01背包问题，因为strs相当于物品，每个字符串都是一个物品，每个物品都只有一个
        //而m，n相当于背包，只不过这个背包有两个维度而已，理解了题意，那这道题就可以开始做了
        //dp数组的定义，dp[i][j],表示最多有i个0，j个1的strs的子集最大长度
        //递推公式：定义0的个数numOf0，1的个数numOf1，dp[i][j] 由dp[i - numOf0][j - numOf1] + 1和
        //它本身比大小得来，这里的意思是，举个例子，循环拿物品，我拿了”10“，有1个0，1个1，我们之后的
        //dp都带上这个物品一起玩，把它的个数减掉求到的dp的值加上它本身的长度1，再和之前一比，谁大，那新的dp[i][j]就是谁，循环遍历strs，得到的dp[m][n]就是最长的子集
        //所以dp[i][j] = Math.max(dp[i][j],dp[i - numOf0][j - numOf1] + 1);
        //初始化：0即可
        //遍历顺序：
        int[][] dp = new int[m + 1][n + 1];
        for(String string:strs) {
            int numOf0 = 0;
            int numOf1 = 0;
            for(int i = 0;i < string.length();i++) {
                if(string.charAt(i)=='0') numOf0++;
                else numOf1++;
            }
            for(int i = m;i >= numOf0;i--) {
                for(int j = n;j >= numOf1;j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - numOf0][j - numOf1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
