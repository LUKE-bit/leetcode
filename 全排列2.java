class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums,used);
        return ans;
    }
    public void backTracking(int[] nums,boolean[] used) {
        if(res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(i > 0 && nums[i] == nums[i - 1] && used[i-1] == false) {
                continue;
            } 
            if(used[i] == false) {
                used[i] = true;
                res.add(nums[i]);
                backTracking(nums,used);
                used[i] = false;
                res.remove(res.size() - 1);
            }
            
        }
    }
}
