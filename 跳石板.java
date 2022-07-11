// 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
// 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
// 例如：
// N = 4，M = 24：
// 4->6->8->12->18->24
// 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] step = new int[m+1];//到m所需最小步数
        Arrays.fill(step,Integer.MAX_VALUE);
        step[n] = 0;
        for(int i = n;i <= m;i++) {
            if(step[i] == Integer.MAX_VALUE){
                continue;
            }
            for(int j = 2;(j*j) <= i;j++) {
                if(i%j==0){
                    if(i+j <= m){
                        step[i+j] = Math.min(step[i]+1,step[i+j]);
                    }
                    if(i+(i/j) <= m){
                        step[i+(i/j)] = Math.min(step[i]+1,step[i+(i/j)]);
                    }
                }
            }
        }
        if(step[m]==Integer.MAX_VALUE){
            step[m] = -1;
        }
        System.out.print(step[m]);
    }
}
