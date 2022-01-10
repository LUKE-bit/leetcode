class Solution {
    public int numTrees(int n) {
        //dp数组的含义为n个节点组成的二叉搜索树的种树
        //假设n=3，以1为头节点，右子树的是n=2时的dp，左边是空树，以2为节点，左右子树分别是
        //n=1时二叉搜索树，以3为头节点，左边dp[2],右边dp[0];
        //递推公式 dp[i] += dp[j - 1] * dp[i - j];j从1到i
        //遍历从前到后
        int[] dp = new int[n + 1];
        dp[0] = 1;//因为要*，而且空树也算一棵二叉搜索树
        for(int i = 0;i <= n;i++) {
            for(int j = 1;j <= i;j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
