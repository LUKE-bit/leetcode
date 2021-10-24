class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for(int first = 0;first < nums.length - 2;first++) {
            if(nums[first] > 0) {
                break;
            }
            if(first > 0 && nums[first] == nums[first - 1]) {continue;}
            int target = -nums[first];
            int left = first + 1,right = nums.length - 1;
            while(left < right) {
                if(nums[left] + nums[right] == target) {
                    ans.add(new ArrayList(Arrays.asList(nums[first],nums[left],nums[right])));
                    left++;right--;
                    while(left < right && nums[left] == nums[left - 1]) {left++;}
                    while(left < right && nums[right] == nums[right+1]) {right--;}
                }else if(nums[left] + nums[right] > target) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return ans;
    }
}
