import java.util.*;

public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int cycle = (Math.min(n,m)-1)/2+1;
        int[] steps = new int[n*m];
        int cnt = 0;
        for(int i = 0;i < cycle;i++) {
            for(int k = i;k<m-i;k++) steps[cnt++] = mat[i][k];
            for(int j=i+1;j<n-i;j++) steps[cnt++] = mat[j][m-i-1];
            for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) steps[cnt++] = mat[n-i-1][k];
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) steps[cnt++] = mat[j][i];
        }
        return steps;
    }
}
