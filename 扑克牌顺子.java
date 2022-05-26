import java.util.*;
public class Solution {
    public boolean IsContinuous(int [] numbers) {
        Arrays.sort(numbers);
        int count = 0;
        int count0 = 0;
        for(int i = 0;i < numbers.length - 1;i++){
            if(numbers[i] != 0){
                if(numbers[i] == numbers[i+1]) {
                    return false;
                }
                count += numbers[i+1] - numbers[i] - 1;
            }else if(numbers[i] == 0){
                count0++;
            }
        }
        if(count0 == 4){
            return true;
        }
        if(count0 == count || count == 0){
            return true;
        }
        return false;
    }
}
