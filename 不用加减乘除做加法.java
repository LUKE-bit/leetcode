// 位运算中两数进行异或运算可以提供两数加和后二进制非进位信息，位运算中的两数进行与运算的结果可以提供两数加和后的二进制进位信息。
// 因此我们将两数与运算的结果进行循环左移一位，并在下一轮循环中继续将移位后的进位结果和非进位结果求和，重复此过程，直到不再产生进位为止
import java.util.*;
public class Solution {
    public int Add(int num1,int num2) {
        int add = num1;
        int sum = num2;
        while(add!=0) {
            int temp = add ^ sum;
            add = (sum&add) << 1;
            sum = temp;
        }
        return sum;
    }
}
