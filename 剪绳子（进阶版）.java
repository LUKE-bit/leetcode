// 给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段（ m 、 n 都是整数， n > 1 并且 m > 1 ， m <= n ），每段绳子的长度记为 k[1],...,k[m] 。请问 k[1]*k[2]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18 。

// 由于答案过大，请对 998244353 取模。

// 数据范围：2\leq n \leq 10^{14}2≤n≤10 
// 14
 
// 进阶：空间复杂度 O(1)O(1) ， 时间复杂度 O(logn)O(logn)

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param number long长整型 
     * @return long长整型
     */
    private long mod = 998244353;
    public long cutRope (long number) {
        // write code here
        if(number <= 3){
            return number - 1;
        }
        if(number % 3 == 0) {
            return Pow(3,number / 3);
        }else if(number % 3 == 1) {
            return fast(Pow(3,number / 3 - 1),4);
        }else {
            return fast(Pow(3,number / 3),2);
        }
    }
    long Pow(long x,long y) {
        long res = 1;
        while(y != 0) {
            if((y & 1L) != 0) {
                res = fast(res,x);
            }
            x = fast(x,x);
            y = y >> 1;
        }
        return res;
    }
    long fast(long x,long y){
        long res = 0;
        x %= mod;
        y %= mod;
        while(y != 0) {
            if((y&1L) != 0){
                res += x;
                if(res > mod){
                    res -= mod;
                }
            }
            y = y >> 1;
            x = x << 1;
            if(x >= mod){
                x -= mod;
            }
        }
        return res;
    }
}
