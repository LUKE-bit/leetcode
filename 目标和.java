class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //这道题和之前的不太一样，乍一看可以拿组合总和问题一样，想尝试回溯法
        //发现超时，于是我们可以用动态规划，这时我们要考虑dp数组的定义是什么，
        //我们假设加法的和为x，那减法的和就是sum-x，可以推出x-（sum-x） = target
        //举个例子，以示例1为例，tar=3，加法和为2的话，一减，减法和就是1，所以x要减（sum-x）才是target
        //这里要注意，不是加，还有就是nums都要参与运算，不是取几个构造也要注意
        //可以推出x = （sum+target）/2;x为背包容量，所以dp的定义为填满容量为x的背包有几种方法
        //此时有人考虑到x会不会向下取整，对的，所以如果（sum + target）%2！=0，返回0
        //递推公式：举个例子，dp[4] 有几个，我们首先要拿到一个数比如我们拿到nums[0]=1，那么我们只
        //需求dp[3]即可，dp[3]有几个，dp[4]由他们加上1得来，再拿一个数为2，dp[4]再加上dp[1]的个数即可
        //所以递推公式为：dp[j] += dp[j - nums[i]];
        //初始化：dp都由dp[0]推导而来，dp[0]必须为1，不然递归都是0，很好理解，填满容量为0的背包
        //有两种方法，就是放0件物品
        //遍历顺序先遍历物品，背包容量大到小
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i < n;i++) {sum += nums[i];}
        int bag = (sum + target) / 2;
        if(Math.abs(target) > sum) {return 0;}
        if((sum + target) % 2 ==1){return 0;}
        int[] dp = new int[bag + 1];
        dp[0] = 1;
        for(int i = 0;i < n;i++) {
            for(int j = bag;j >= nums[i];j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bag];
    }
}
