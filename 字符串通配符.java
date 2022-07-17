

// 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
// 要求：
// 实现如下2个通配符：
// *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
// ？：匹配1个字符

// 注意：匹配时不区分大小写。
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String p=  scan.nextLine();
            String s=  scan.nextLine();
            System.out.println(isMatch(p.toUpperCase(),s.toUpperCase()));

        }
    }

    public static boolean isMatch(String p, String s) {
        int plen = p.length();
        int slen = s.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        // 字符串和模式串均为空，直接匹配上
        dp[0][0] = true;
        // 模式串为空，全都不匹配，j=0时全部为false
        // i=0时，只有在模式串为*的时候才能匹配
        for(int j = 1; j <= plen; j++){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = true;
            } else{
                break;
            }

        }
        for(int i = 1; i <= slen; i++){
            for(int j = 1; j <= plen; j++){
                if(p.charAt(j - 1) == '*'&& (isFitChar(s.charAt(i - 1))||dp[i][j - 1])){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if((p.charAt(j - 1) == '?' && isFitChar(s.charAt(i - 1)))|| p.charAt(j - 1) == s.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }

            }
        }
        return dp[slen][plen];
    }

    private static boolean isFitChar(char charAt) {
        if((charAt<='9'&&charAt>='0')||(charAt>='A'&&charAt<='Z')){
            return true;
        }
        return false;
    }

}



import java.io.*; 
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      String value;
      while ((value = bf.readLine()) != null) {
          String target = bf.readLine();
          value = value.toLowerCase(Locale.ROOT);
          target = target.toLowerCase(Locale.ROOT);
          String regx = value.replaceAll("\\*{2,}","\\*");
          regx = regx.replaceAll("\\?","[0-9a-z]{1}");
          regx = regx.replaceAll("\\*","[0-9a-z]{0,}");
          System.out.println(target.matches(regx));
    }
}
}
