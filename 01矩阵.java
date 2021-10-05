class Solution {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] arr = new int[n][m];
        boolean[][] path = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(mat[i][j]==0) {
                    queue.offer(new int[]{i,j});
                    path[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            for(int d = 0;d < 4;d++) {
                int x = cell[0] + dir[d][0];
                int y = cell[1] + dir[d][1];
                if(x>=0&&x<n&&y>=0&&y<m&&!path[x][y]) {
                    arr[x][y] = arr[cell[0]][cell[1]] + 1;
                    queue.offer(new int[]{x,y});
                    path[x][y] = true;
                }
            }
        }
        return arr;
    }
}
