import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();
        int cnt = 2;
        int count = 0;
        for(char c = 'A';c <= 'Y';c++) {
            if(c=='S') {
                map.put(c,7);
                continue;
            }
            map.put(c,cnt);
            count++;
            if(count==3){
                cnt++;
                count = 0;
            }
        }
        map.put('Z',9);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine();
            String[] strs = new String[n];
            String[] tar = new String[n];
            for(int i = 0;i < n;i++) {
                strs[i] = in.next();
            }
            for(int i = 0;i < n;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < strs[i].length();j++) {
                    if(Character.isDigit(strs[i].charAt(j))) sb.append(strs[i].charAt(j));
                    else if(strs[i].charAt(j) == '-') continue;
                    else{
                        sb.append(map.get(strs[i].charAt(j)));
                    }
                }
                String ans = sb.toString();
                ans = ans.substring(0,3) + "-" + ans.substring(3); 
                tar[i] = ans;
            }
            Arrays.sort(tar);
            for(int i = 0;i < n;i++) {
                if(i!=0){
                    if(tar[i].equals(tar[i-1])) continue;
                }
                System.out.println(tar[i]);
            }
            System.out.println();
        }
    }
}
