import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(array[mid] > array[right]){
                left = mid + 1;
            }else if(array[mid] < array[mid]) {
                right = mid;
            }else{
                right--;
            }
        }
        return array[left];
    }
}
