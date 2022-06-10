import java.util.*;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0 || numbers == null){
            return "";
        }
        String[] nums = new String[numbers.length];
        for(int i = 0;i < numbers.length;i++){
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums,new Comparator<String>(){
            public int compare(String s1,String s2){
                return (s1+s2).compareTo(s2+s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < nums.length;i++){
            sb.append(nums[i]);
        }
        return String.valueOf(sb);
    }
}
