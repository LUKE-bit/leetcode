// 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,
// 要求将其中所有的可能组合列出来

// 输入描述:
// 每个测试输入包含2个整数,n和m

// 输出描述:
// 按每个组合的字典序排列输出,每行输出一种组合
import java.util.*;
public class Main {
    static List<ArrayList<Integer>> ans = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static int num = 1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            assemble(1,n,m);
            for(ArrayList<Integer> list : ans){
                for(int i = 0;i < list.size()-1;i++){
                    System.out.print(list.get(i)+" ");
                }
                System.out.println(list.get(list.size()-1));
            }
        }
    }
    public static void assemble(int index,int n,int m){
        if(m == 0){
            ans.add(new ArrayList(list));
        }else{
            for(int i = index;i <= n && i <= m;i++) {
                list.add(i);
                assemble(i+1,n,m-i);
                list.remove(list.size()-1);
            }
        }
    }
}
