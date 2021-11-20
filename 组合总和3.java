class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        backtraverse(sum,n,k,1,ans,stack);
        return ans;
    }
    public void backtraverse(int sum,int n,int k,int startIndex,List<List<Integer>> ans,Stack<Integer> stack) {
        if(stack.size() == k) {
            if(sum == n) {
                ans.add(new ArrayList<Integer>(stack));
            }
            return;
        }
        if(sum > n) {
            return;
        }
        for(int i = startIndex;i <= 9;i++) {
            sum+=i;
            stack.push(i);
            backtraverse(sum,n,k,i+1,ans,stack);
            sum-=i;
            stack.pop();
        }
    }
}
