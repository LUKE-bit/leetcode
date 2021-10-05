class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i]==0) {
                count++;
            }
        }
        int k = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i]==0) {
                k++;
                if(k==(count+1)) {
                    break;
                }
                for(int j = i;j < nums.length - 1;j++) {
                    nums[j] = nums[j+1];
                }
                nums[nums.length - 1] = 0;
                i = -1;
            }
        }
    }
}
//答案
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

