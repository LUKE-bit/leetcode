class Solution {
    boolean[] memory;
    public boolean wordBreak(String s, List<String> wordDict) {
        //这道字符串拆分可以联想到回溯法暴力拆分，但是有可能超时，所以我们这里使用记忆化搜索
        Set<String> set = new HashSet<>(wordDict);
        this.memory = new boolean[s.length()];
        return backTracking(s,set,0);
    }
    public boolean backTracking(String s,Set<String>set,int startIndex) {
        if(s.length() == 0) return true;
        if(memory[startIndex]) return false;
        for(int i = 0;i < s.length();i++) {
            if(set.contains(s.substring(0,i + 1))) {
                if(backTracking(s.substring(i + 1),set,startIndex + i + 1)) {
                    return true;
                }
            }
        }
        memory[startIndex] = true;
        return false;
    }
}


//动态规划
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp数组定义，长度为i，是否可以拆分
        //递推公式：如果dp[j]是true且j到i的字串再字典里出现过，则dp[i]为true
        //初始化：dp[0] = true;这里没有实际意义，单纯为了状态转移方程
        //遍历顺序，物品和背包哪个在外面都可以,这里选用背包在外部
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for(int i = 1;i <= s.length();i++) {
            for(int j = 0;j < i;j++) {
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
