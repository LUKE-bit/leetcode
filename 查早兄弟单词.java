import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        String[] words = new String[n];
        for(int i = 0;i < n;i++) {
            words[i] = input[i+1];
        }
        String x = input[input.length - 2];
        int k = Integer.parseInt(input[input.length-1]);
        List<String> brothers = new ArrayList<>();
        int count = 0;
        for(int i= 0;i < n;i++) {
            if(words[i].equals(x)){
                continue;
            }
            if(brother(words[i],x)){
                count++;
                brothers.add(words[i]);
            }
        }
        System.out.println(count);
        Collections.sort(brothers);
        if(brothers.size() > k && brothers.get(k-1)!=null){
            System.out.println(brothers.get(k-1));
        }
    }
    public static boolean brother(String word,String x) {
        char[] a = word.toCharArray();
        char[] b = x.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.toString(a).equals(Arrays.toString(b));
    }
}
