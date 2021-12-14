class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i < k;i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j = 0;j < nums.length;j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            nums[index] = -nums[index];
        }
        for(int i = 0;i < nums.length;i++) {
            count += nums[i];
        }
        return count;
    }
}
