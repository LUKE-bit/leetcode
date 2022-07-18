import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        //判断两个字符串谁长谁短
        if (str1.length() <= str2.length()) {
            longString(str1, str2);
        } else {
            longString(str2, str1);
        }
    }
    
    public static void longString(String str1,String str2){
        char[]arr1 = str1.toCharArray();
        char[]arr2 = str2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        //定义最大长度maxLen ，开始下标start
        int maxLen = 0;//最长子串的长度
        int start = 0;//最长子串的起始位置
        int[][] maxSubLen = new int[len1+1][len2+1];
        for(int i = 1;i<=len1;i++){
            for(int j =1;j<=len2;j++){
                //如果第i个字符与第j个字符相等，则进行累加
                if(arr1[i-1] == arr2[j-1]){
                    maxSubLen[i][j] = maxSubLen[i-1][j-1]+1;
                    //更新
                    if(maxLen < maxSubLen[i][j]){
                        maxLen = maxSubLen[i][j];
                        start = i - maxLen;
                    }
                }
            }
        }
        System.out.println(str1.substring(start,start+maxLen));
        
    }
}
//////////////////////
//常规思路
import java.util.*;
public class Main{
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            //判断两个字符串谁长谁短
            if (str1.length() <= str2.length()) {
                longString(str1, str2);
            } else {
                longString(str2, str1);
            }
        }
    
    public static void longString(String str1,String str2){
        //定义最大长度maxLen ，开始下标start
        int maxLen = 0;
        int start = 0;
        for(int i = 0;i<str1.length();i++){
            if(str1.length()-i-1 <= maxLen){
                break;
            } 
            for(int j =i,k=str1.length(); k>j ;k--){
                String subStr = str1.substring(i,k);
                if(str2.contains(subStr) && maxLen<subStr.length()){
                    maxLen = subStr.length();
                    start = j;
                    break;
                }
            }
        }
        System.out.println(str1.substring(start,start+maxLen));
        
    }
}
