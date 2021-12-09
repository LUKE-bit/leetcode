class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0;i < nums.length;i++) {
            count+=nums[i];
            if(count > result) {
                result = count;
            }
            if(count <= 0) {
                count = 0;
            }
        }
        return result;
    }
}
//贪心的地方在于只要count < 0 ，就说明它会拖累整体，count重新计数。
