import java.util.*;
// 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
// 我们把一个字符串编码成一串数字，再考虑逆向编译成字符串。
// 由于没有分隔符，数字编码成字母可能有多种编译结果，例如 11 既可以看做是两个 'a' 也可以看做是一个 'k' 。但 10 只可能是 'j' ，因为 0 不能编译成任何结果。
// 现在给一串数字，返回有多少种可能的译码结果

// 数据范围：字符串长度满足 0 < n \le 900<n≤90
// 进阶：空间复杂度 O(n)，时间复杂度 O(n)

public class Solution {
    /**
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve (String nums) {
        // write code here
        //dp定义:到i位置可能的编译结果
        if(nums == "0") return 0;
        if(nums=="10" || nums == "20") return 1;
        for(int i = 1;i < nums.length();i++) {
            if(nums.charAt(i) == '0') {
                if(nums.charAt(i-1) !='1' && nums.charAt(i-1) != '2') return 0;
            }
        }
        int[] dp = new int[nums.length()+1];
        Arrays.fill(dp,1);
        for(int i = 2;i <= nums.length();i++) {
            if((nums.charAt(i-2) == '1' && nums.charAt(i-1)!='0') || (nums.charAt(i-2)=='2' && nums.charAt(i-1)>'0' && nums.charAt(i-1) < '7')) {
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.length()];
    }
}
