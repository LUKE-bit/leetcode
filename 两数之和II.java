class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 1,right = 1;
        for(int i = 1;i <= numbers.length - 1;i++) {
            for(int j = i + 1;j <= numbers.length;j++) {
                if(numbers[i-1] + numbers[j-1] == target) {
                    left = i;
                    right = j;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
}

//答案
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/liang-shu-zhi-he-ii-shu-ru-you-xu-shu-zu-by-leet-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
