import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串 
     * @param version2 string字符串 
     * @return int整型
     */
    public int compare (String version1, String version2) {
        // write code here
        int n1 = version1.length();
        int n2 = version2.length();
        int i = 0;
        int j = 0;
        while(i < n1 || j < n2) {
            long num1 = 0;
            while(i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++;
            long num2 = 0;
            while(j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;
            if(num1 > num2) {
                return 1;
            }else if(num2 > num1) {
                return -1;
            }
        }
        return 0;
    }
}
///////////////////
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串 
     * @param version2 string字符串 
     * @return int整型
     */
    public int compare (String version1, String version2) {
        // write code here
        int n1 = version1.length();
        int n2 = version2.length();
        int i = 0;
        int j = 0;
        while(i < n1 || j < n2) {
            long num1 = 0;
            while(i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++;
            long num2 = 0;
            while(j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;
            if(num1 > num2) {
                return 1;
            }else if(num2 > num1) {
                return -1;
            }
        }
        return 0;
    }
}
