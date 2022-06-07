import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for(int i = 0;i < n;i++) {
            int res = 1;
            for(int j = 0;j < n;j++){
                if(j==i) continue;
                res *= A[j];
            }
            B[i] = res;
        }
        return B;
    }
}

//官方解法
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        //初始化数组B
        int[] B = new int[A.length];
        B[0] = 1;
        //先乘左边，从左到右
        for(int i = 1; i < A.length; i++)
            //每多一位由数组B左边的元素多乘一个前面A的元素
            B[i] = B[i - 1] * A[i - 1];
        int temp = 1;
        //再乘右边，从右到左
        for(int i = A.length - 1; i >= 0; i--){
            //temp为右边的累乘
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }
}
