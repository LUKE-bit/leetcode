package algorithm;

import java.util.Scanner;

public class MaxKProduct {

    public static int findMaxK(int[][] dp,int I,int n,int k){
        //划分问题，可以想到用dp求最大乘积
        //dp含义：前i位分成j段得到的最大乘积
        //递推公式：
        // 如果i < j,不可能分成,dp[i][j]=0
        // 如果j = 1,分成1段,那dp[i][j] = connect(1,i)
        // 如果j > 1 && j <= i dp[i][j] = Math.max(dp[t][j-1] * connect(t+1,i)) 这个t表示从0到i-1,
        // 初始化:dp[0][j] = 0,dp[i][0] = 1;
        // 遍历顺序:由递推公式可知dp由前几位推出,所以需要从前往后遍历

        for (int i = 1;i <= n;i++){
            dp[i][1] = connect(I,1,i);
        }
        for(int i = 2;i <= n;i++) {
            for (int j = 2;j <= i && j <= k;j++) {
                for (int t = 1;t <= i-1;t++) {
                    dp[i][j] = Math.max(dp[i][j],dp[t][j-1] * connect(I,t+1,i));
                }
            }
        }
        return dp[n][k];
    }
    public static int connect(int I,int begin,int end) {
        if (begin > end){
            return 0;
        }
        char[] num = String.valueOf(I).toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = begin;i <= end;i++){
            sb.append(num[i-1]);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void printProductMatrix(int[][] dp,int I,int n,int k){
        System.out.println("生成的整数分段矩阵为");
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= n;j++){
                System.out.print(connect(I,i,j) + " ");
            }
            System.out.println();
        }
        System.out.println("生成的分段乘积矩阵为");
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= k;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int I = sc.nextInt();
        int k = sc.nextInt();
        int n = String.valueOf(I).length();
        int[][] dp = new int[n+1][k+1];
        System.out.println(findMaxK(dp,I,n,k));
        printProductMatrix(dp,I,n,k);
    }
}
