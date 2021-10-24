class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int first = 0;first < nums.length - 3;first++) {
            if(first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            for(int second = first + 1;second < nums.length - 2;second++) {
                if(second > first + 1 && nums[second] == nums[second-1]) {
                    continue;
                }
                int left = second + 1,right = nums.length - 1;
                int goal = target - nums[first] - nums[second];
                while(left < right) {
                    if(nums[left] + nums[right] == goal) {
                        ans.add(new ArrayList(Arrays.asList(nums[first],nums[second],nums[left],nums[right])));
                        left++;right--;
                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    }else if(nums[left] + nums[right] > goal) {
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
