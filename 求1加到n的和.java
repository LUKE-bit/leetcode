// 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
// 数据范围： 0 < n <= 200
// 进阶： 空间复杂度 O(1) ，时间复杂度 O(n)
import java.util.*;
public class Solution {
    public int Sum_Solution(int n) {
        boolean flag = (n>1) && ((n+=Sum_Solution(n-1)) > 0);
        return n;
    }
    
}

return ((int)pow(n,2)+n) >> 1;
