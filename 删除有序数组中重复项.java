class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0,fast = 0;
        while(fast < nums.length) {
            if(nums[fast]!=nums[slow]) {
                nums[++slow] = nums[fast];
                continue;
            }
            fast++;
        }
        return slow + 1;
    }
}
