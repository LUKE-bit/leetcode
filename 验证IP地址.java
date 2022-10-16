import java.util.*;


public class Solution {
    /**
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve (String IP) {
        // write code here
        return IsIPv4(IP) ? "IPv4" : (IsIPv6(IP) ? "IPv6" : "Neither");
    }
    public boolean IsIPv4(String IP) {
        String[] arr = IP.split("\\.",-1);
        if (arr.length != 4) {
            return false;
        }
        for (String str : arr) {
            if (str.length() > 1 && str.charAt(0) == '0') {
                return false;
            }
            try {
                int val = Integer.parseInt(str);
                if (!(val >= 0 && val <= 255)) {
                    return false;
                }
            }catch(NumberFormatException ex) {
                return false;
            }

        }
        return true;
    }
    public boolean IsIPv6(String IP) {
        String[] arr = IP.split(":",-1);
        if (arr.length != 8) {
            return false;
        }
        for (String str : arr) {
            if (str.length() > 4 || str.length() == 0) {
                return false;
            }
            try {
                int val = Integer.parseInt(str, 16);
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }
}
