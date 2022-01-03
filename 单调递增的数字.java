class Solution {
    public int monotoneIncreasingDigits(int n) {
        String[] str = (n + "").split("");
        int start = str.length;
        for(int i = str.length - 1;i >= 1;i--) {
            if(Integer.parseInt(str[i - 1]) > Integer.parseInt(str[i])) {
                str[i-1] = (Integer.parseInt(str[i - 1])-1) + "";
                start = i;
            }
        }
        for(int i = start;i < str.length;i++) {
            str[i] = "9";
        }
        return Integer.parseInt(String.join("",str));
    }
}


//速度更快
class Solution {
    public int monotoneIncreasingDigits(int n) {
        if (n==0)return 0;
        char[] chars= Integer.toString(n).toCharArray();
        int start=Integer.MAX_VALUE;//start初始值设为最大值，这是为了防止当数字本身是单调递增时，没有一位数字需要改成9的情况
        for (int i=chars.length-1;i>0;i--){
            if (chars[i]<chars[i-1]){
                chars[i-1]--;
                start=i;
            }
        }
        StringBuilder res=new StringBuilder();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='0'&&i==0)continue;//防止出现09这样的情况
            if (i>=start){
                res.append('9');
            }else res.append(chars[i]);
        }
        return Integer.parseInt(res.toString());
    }
}
