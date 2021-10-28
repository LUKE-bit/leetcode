class Solution {
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int top = -1;
        for(int i = 0;i < arr.length;i++) {
            if(top == -1 || arr[top] != arr[i]) {
                arr[++top] = arr[i];
            }else {
                top--;
            }
        }
        return String.valueOf(arr,0,top + 1);
    }
}
