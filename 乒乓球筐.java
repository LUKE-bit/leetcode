import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String A = in.next();
            String B = in.next();
            Map<Character,Integer> map1 = new HashMap<>();
            Map<Character,Integer> map2 = new HashMap<>();
            for(int i = 0;i < A.length();i++) {
                map1.put(A.charAt(i),1 + map1.getOrDefault(A.charAt(i),0));
            }
            for(int i = 0;i < B.length();i++) {
                map2.put(B.charAt(i),1 + map2.getOrDefault(B.charAt(i),0));
            }
            Boolean flag = false;
            for(int i = 0;i < B.length();i++) {
                if(!map1.containsKey(B.charAt(i))){
                    flag = true;
                    break;
                }
                if(map1.get(B.charAt(i)) < map2.get(B.charAt(i))) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
