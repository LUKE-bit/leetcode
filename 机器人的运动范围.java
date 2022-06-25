import java.util.*;
public class Solution {
    int count = 0;
    private int cnt(int n){
        int sum = 0;
        while(n!=0){
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
    private void dfs(int threshold,int i,int j,boolean[][] flag,int rows,int cols) {
        if(i < 0 || i >= rows || j<0 || j>=cols ||flag[i][j]==true)
            return;
        if(cnt(i) + cnt(j) > threshold){
            return;
        }
        count++;
        flag[i][j] = true;
        dfs(threshold,i+1,j,flag,rows,cols);
        dfs(threshold,i-1,j,flag,rows,cols);
        dfs(threshold,i,j+1,flag,rows,cols);
        dfs(threshold,i,j-1,flag,rows,cols);
    }
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        dfs(threshold,0,0,flag,rows,cols);
        return count;
    }
}
