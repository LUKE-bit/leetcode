
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g" 。当从该字符流中读出前六个字符 “google" 时，第一个只出现一次的字符是"l"。

数据范围：字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，字符串中出现的字符一定在 ASCII 码内。
进阶：空间复杂度 O(n)\O(n)  ，时间复杂度 O(n) \O(n) 

后台会用以下方式调用 Insert 和 FirstAppearingOnce 函数
import java.util.*;
public class Solution {
    //Insert one char from stringstream
    StringBuilder sb = new StringBuilder();
    HashMap<Character,Integer> map = new HashMap<>();
    public void Insert(char ch)
    {
        sb.append(ch);
        map.put(ch,map.getOrDefault(ch,0)+1);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i = 0;i < sb.length();i++) {
            if(map.get(sb.charAt(i)) == 1) {
                return sb.charAt(i);
            }
        }
        return '#';
    }
}
