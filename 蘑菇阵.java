// 现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。现在A想要拜访B，由于她只想去B的家，
// 所以每次她只会走(i,j+1)或(i+1,j)这样的路线，在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),
// 问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
import java.util.*;
public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            double[][] arr = new double[n+1][m+1];
            for(int i = 1;i <= k;i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = -1;
            }
            arr[1][1] = 1;
            for(int i = 1;i <= n;i++) {
                for(int j = 1;j <= m;j++) {
                    if(arr[i][j]!=-1){
                        if(arr[i-1][j]!=-1){
                            arr[i][j] += j == m ? arr[i-1][j] : arr[i-1][j] / 2;
                        }
                        if(arr[i][j-1]!=-1){
                            arr[i][j] += i == n ? arr[i][j-1] : arr[i][j-1] / 2;
                        }
                    }
                }
            }
            System.out.printf("%.2f\n",arr[n][m]);   
        }
    }
}
