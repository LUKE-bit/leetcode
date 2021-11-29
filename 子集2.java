class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0) {
            ans.add(res);
            return ans;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTracking(nums,0);
        return ans;
    }
    public void backTracking(int[] nums,int beginI) {
        ans.add(new ArrayList<>(res));
        if(beginI >= nums.length) {
            return;
        }
        for(int i = beginI;i < nums.length;i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            res.add(nums[i]);
            backTracking(nums,i + 1);
            res.remove(res.size() - 1);
            used[i] = false;
        }
    }
}
