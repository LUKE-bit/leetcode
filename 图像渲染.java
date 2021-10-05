class Solution {
    int dx[] = new int[]{1,0,-1,0};
    int dy[] = new int[]{0,1,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if(currColor == newColor) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = newColor;
        int n = image.length,m = image[0].length;
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0],y = cell[1];
            for(int i = 0;i < 4;i++) {
                int mx = x + dx[i],my = y + dy[i];
                if(mx >= 0 && mx < n && my >=0 && my < m  && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx,my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}
