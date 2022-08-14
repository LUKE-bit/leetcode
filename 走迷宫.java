// 输入包含多组数据。
// 每组数据包含一个10*10，由“#”和“.”组成的迷宫。其中“#”代表墙；“.”代表通路。
// 入口在第一行第二列；出口在最后一行第九列。
// 从任意一个“.”点都能一步走到上下左右四个方向的“.”点。
// 对应每组数据，输出从入口到出口最短需要几步。
import java.util.Scanner;
public class Main {
    static int[][] direction = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            char[][] board = new char[10][10];
            int[][] chess = new int[10][10];
            for(int i = 0;i < 10;i++) {
                String line = in.nextLine();
                for(int j = 0;j < 10;j++) {
                    board[i][j] = line.charAt(j);
                    chess[i][j] = Integer.MAX_VALUE;
                }
            }
            chess[0][1] = 0;
            dfs(0,1,board,chess);
            System.out.println(chess[9][8]);
        }
    }
    public static void dfs(int x,int y,char[][] board,int[][] chess) {
        for(int i = 0; i < 4; i++){
            int xx = x + direction[i][0];
            int yy = y + direction[i][1];
            if(xx >= 0 && xx < 10 && yy >= 0 && yy < 10 
              && board[xx][yy] == '.' && chess[xx][yy] > chess[x][y]+1){
                chess[xx][yy] = chess[x][y] + 1;
                dfs(xx, yy, board, chess);
            }
        }
    }
}
