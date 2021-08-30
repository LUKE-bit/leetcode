class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int n = nums.length;
        int pos = n - 1;
        int left = 0,right = n - 1; 
        while(left<=right) {
            if(nums[left]*nums[left]>nums[right]*nums[right]) {
                arr[pos] = nums[left]*nums[left];
                left++;
            }else{
                arr[pos] = nums[right]*nums[right];
                right--;
            }
            pos--;
        }
        return arr;
    }
}
