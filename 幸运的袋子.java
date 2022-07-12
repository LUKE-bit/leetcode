// 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
// 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
// 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ball = new int[n];
        for(int i = 0;i < n;i++) {
            ball[i] = sc.nextInt();
        }
        Arrays.sort(ball);
        int count = findCount(ball,0,0,1);
        System.out.print(count);
    }
    public static int findCount(int[] ball,int index,int sum,int multi) {
        int count = 0;
        for(int i = index;i < ball.length;i++) {
            sum += ball[i];
            multi *= ball[i];
            if(sum > multi) {
                count += 1 + findCount(ball,i+1,sum,multi);
            }else if(ball[index] == 1) {
                count += findCount(ball,i+1,sum,multi);
            }else{
                break;
            }
            sum -= ball[i];
            multi /= ball[i];
            while(i < ball.length-1 && ball[i]==ball[i+1]){
                i++;
            }
        }
        return count;
    }
}
