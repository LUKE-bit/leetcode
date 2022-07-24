//它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
import java.util.*;
public class Main {
    static int[][] path = {{1,0},{0,1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                arr[i][j] = in.nextInt();
            }
        }
        List<String> res = new ArrayList<>();
        backTracking(arr,0,0,res);
        for(String str:res){
            System.out.println(str);
        }
    }
    public static boolean backTracking(int[][] arr,int i,int j,List<String> res) {
        res.add("("+i+","+j+")");
        arr[i][j] = 1;
        if(i==arr.length-1&&j==arr[0].length-1){
            return true;
        }
        if (i + 1 < arr.length && arr[i + 1][j] == 0) {
            if (backTracking(arr, i + 1, j, res)) {
                return true;
            }
        }
        if (j + 1 < arr[0].length && arr[i][j + 1] == 0) {
            if (backTracking(arr, i, j + 1, res)) {
                return true;
            }
        }
        if (i - 1 > -1 && arr[i - 1][j] == 0) {
            if (backTracking(arr, i - 1, j, res)) {
                return true;
            }
        }
        if (j - 1 > -1 && arr[i][j - 1] == 0) {
            if (backTracking(arr, i, j - 1, res)) {
                return true;
            }
        }
        res.remove(res.size() - 1);
        arr[i][j] = 0;
        return false;
    }
}
