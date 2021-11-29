class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrackint(nums,0);
        return ans;
    }
    public void backTrackint(int[] nums,int beginI) {
        if(res.size() > 1) {
            ans.add(new ArrayList<>(res));
        }
        int[] used = new int[201];
        for(int i = beginI;i < nums.length;i++) {
            if(!res.isEmpty() && nums[i] < res.get(res.size() - 1) || (used[nums[i] + 100] == 1) ){
                continue;
            }
            used[nums[i] + 100] = 1;
            res.add(nums[i]);
            backTrackint(nums,i+1);
            res.remove(res.size() - 1);
        }
    }
}
