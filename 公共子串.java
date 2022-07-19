import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int n = a.length();
        int m = b.length();
        if(n==0 || m==0)System.out.print(0);
        int max = 0;
        for(int i = 1;i <= n;i++) {
            int count = 0;
            if(n-i+1 < max){
                break;
            }
            for(int j = 1,k=i;j <= m && k<=n;j++) {
                if(a.charAt(k-1) == b.charAt(j-1)) {
                    count++;
                    k++;
                    if(count > max) {
                        max = count;
                    }
                }else{
                    k = i;
                    j=j-count;//注意,j也要回溯,这里卡了好久
                    count = 0;
                }
            }
        }
        System.out.print(max);
    }
}


////////////////
链接：https://www.nowcoder.com/questionTerminal/98dc82c094e043ccb7e0570e5342dd1b?orderByHotValue=0&done=0&pos=26&mutiTagIds=578_579&onlyReference=false
来源：牛客网

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String str1 = "";
        String str2 = "";
        while(sc.hasNext()){
            str1 = sc.next();
            str2 = sc.next();
            System.out.println(getCommonStrLength(str1, str2));
        }
    }
 
    public static int getCommonStrLength(String str1, String str2){
         
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
         
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                dp[i][j] = 0;
            }
        }
         
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;   //区别在这儿        
                }
            }
        }
         
        int max = 0;
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(max < dp[i][j])
                    max = dp[i][j];
            }
        }
         
        return max;
    }
}
