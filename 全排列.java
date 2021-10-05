class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        for(int num: nums) {
            output.add(num);
        }
        backtrace(output,n,ans,0);
        return ans;   
    }
    public void backtrace(List<Integer> output,int n,List<List<Integer>> res,int first) {
        if(first==n) {
            res.add(new ArrayList<Integer>(output));
        }
        for(int i = first;i < n;i++) {
            Collections.swap(output,first,i);
            backtrace(output,n,res,first+1);
            Collections.swap(output,first,i);
        }
    }
}
