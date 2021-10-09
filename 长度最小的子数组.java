class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int length = nums.length;
        int[] ans = new int[length];
        for(int i = 0;i < length;i++) {
            int j = i;
            for(;j < length;j++) {
                sum+=nums[j];
                if(sum >= target) {
                    ans[i]= j - i + 1;
                    sum = 0;
                    break;
                }
            }
            if(j==length) {
                sum = 0;
                ans[i] = 1000000;
            }
        }
        Arrays.sort(ans);
        if(ans[0] == 1000000) {
            return 0;
        }
        return ans[0];
    }
}


class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
