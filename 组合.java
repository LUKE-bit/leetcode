class Solution {
   
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        if(k<=0 || n < k){
            return ans;
        }
        Deque<Integer> path = new ArrayDeque();
        dfs(n,k,1,ans,path);
        return ans;
    }

    public void dfs(int n,int k,int begin,List<List<Integer>> ans,Deque path) {
        if(path.size()==k) {
            ans.add(new ArrayList(path));
            return;
        }
        for(int i = begin;i <= n + 1 - (k-path.size());i++) {
            path.addLast(i);
            dfs(n,k,i+1,ans,path);
            path.removeLast();
        }
    }
}
