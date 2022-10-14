import java.util.*;

public class Solution {
    public String trans(String s, int n) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n;i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                char c = (char)(s.charAt(i) - 'a' + 'A');
                sb.append(c);
            }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                char c = (char)(s.charAt(i) - 'A' + 'a');
                sb.append(c);
            }else{
                sb.append(s.charAt(i));
            }
        }
        sb = sb.reverse();
        for(int i = 0;i < n;i++) {
            int j = i;
            while(j < n && sb.charAt(j) != ' '){
                j++;
            }
            String temp = sb.substring(i,j);
            StringBuilder sbb = new StringBuilder(temp);
            temp = sbb.reverse().toString();
            sb.replace(i,j,temp);
            i = j;
        }
        return sb.toString();
    }
}
