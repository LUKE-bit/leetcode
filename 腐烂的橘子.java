class Solution {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer,Integer> depth = new HashMap<>();
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j]==2) {
                    queue.offer(new int[]{i,j});
                    depth.put(i*m+j,0);
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            for(int i = 0;i < 4;i++) {
                int x = cell[0] + dir[i][0];
                int y = cell[1] + dir[i][1];
                if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==1) {
                    grid[x][y] = 2;
                    queue.offer(new int[]{x,y});
                    depth.put(x*m+y,depth.get(cell[0]*m+cell[1])+1);
                    ans = depth.get(x*m+y);
                }
            }
            
        }
        for(int[] k:grid){
            for(int v:k) {
                if(v==1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
