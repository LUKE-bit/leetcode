class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracking(candidates,target,0,0,res,used);
        return ans;
    }
    public void backTracking(int[] candidates,int target,int beginI,int sum,List<Integer> res,boolean[] used) {
        if(sum == target) {
            ans.add(new ArrayList(res));
            return;
        }
        for(int i = beginI;i < candidates.length && sum + candidates[i] <= target;i++) {
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            res.add(candidates[i]);
            used[i] = true;
            sum+=candidates[i];
            backTracking(candidates,target,i+1,sum,res,used);
            sum-=candidates[i];
            used[i] = false;
            res.remove(res.size() - 1);
        }
    }
}
