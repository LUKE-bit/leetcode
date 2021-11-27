class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) {
            return ans;
        }
        backTracking(nums,0);
        return ans;
    }
    public void backTracking(int[] nums,int beginI) {
        ans.add(new ArrayList<>(res));
        for(int i = beginI;i < nums.length;i++) {
            res.add(nums[i]);
            backTracking(nums,i + 1);
            res.remove(res.size() - 1);
        }
    }
}
