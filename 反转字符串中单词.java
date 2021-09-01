class Solution {
    public String reverseWords(String s) {
        int left = 0,right = 0;
        char[] arr = s.toCharArray();
        while(right<=s.length()) {
            if( right == s.length() || s.charAt(right)==' ') {
                    reverse(left,right-1,arr);
                    left = right + 1;
                    right+=1;
                    continue;
            }
            right++;
        }
        return String.valueOf(arr);
    }
    public void reverse(int left,int right,char[] s) {
         while(left<right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }
}
