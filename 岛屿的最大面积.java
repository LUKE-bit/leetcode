class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[0].length;j++) {
                ans = Math.max(ans,dfs(grid,i,j));
            }
        }
        return ans;
    }
    public int dfs(int[][] grid,int x,int y) {
        if(x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y]!=1) {
            return 0;
        }
        grid[x][y] = 0;
        int dx[] = new int[]{1,0,-1,0};
        int dy[] = new int[]{0,1,0,-1};
        int ans = 1;
        for(int i = 0;i < 4;i++) {
            int mx = x + dx[i],my = y + dy[i];
            ans += dfs(grid,mx,my);
        }
        return ans;
    }
}
