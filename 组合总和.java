class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> res = new ArrayList<>();
        backTracking(res,candidates,0,target,0);
        return ans;
    }
    public void backTracking(List<Integer> res,int[] candidates,int sum,int target,int beginI) {
        if(sum == target) {
            ans.add(new ArrayList<>(res));
            return;
        }
       
        for(int i = beginI;i < candidates.length;i++) {
            if(sum > target) {break;}
            sum+=candidates[i];
            res.add(candidates[i]);
            backTracking(res,candidates,sum,target,i);
            sum-=candidates[i];
            res.remove(res.size() - 1);
        }
    }
}
