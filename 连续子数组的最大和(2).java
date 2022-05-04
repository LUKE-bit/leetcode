import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
     * 
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
    public int[] FindGreatestSumOfSubArray (int[] array) {
        // write code here
        int left = 0,right = 0;
        int mleft = 0,mright = 0;
        int max = array[0];
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for(int i = 1;i < array.length;i++){
            right++;
            if(dp[i-1] >= 0){
                dp[i] = dp[i-1]+array[i]; 
            }else{
                dp[i] = array[i];
                left = right;
            }
            if(dp[i] > max || dp[i] == max && (right-left + 1) > (mright - mleft + 1)){
                max = dp[i];
                mleft = left;
                mright = right;
            }
        }
        int[] res = new int[mright - mleft + 1];
        for(int i = mleft;i <= mright;i++){
            res[i - mleft] = array[i];
        }
        return res;
    }
}
