class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for(char[] c:chessBoard) {
            Arrays.fill(c,'.');
        }
        backTracking(n,0,chessBoard);
        return ans;
    }
    public void backTracking(int n,int row,char[][] chessBoard) {
        if(row == n) {
            ans.add(Arrays2List(chessBoard));
            return;
        }
        for(int col = 0;col < n;col++) {
            if(isValid(row,col,n,chessBoard)) {
                chessBoard[row][col] = 'Q';
                backTracking(n,row + 1,chessBoard);
                chessBoard[row][col] = '.';
            }
        }
    }
    public List Arrays2List(char[][] chessBoard) {
        List<String> res = new ArrayList<>();
        for(char[] c:chessBoard) {
            res.add(String.copyValueOf(c));
        }
        return res;
    }
    public boolean isValid(int row,int col,int n,char[][] chessBoard) {
        for(int i = 0;i < row;i++) {
            if(chessBoard[i][col] == 'Q') {
                return false;
            }
        }
        for(int i = row - 1,j = col - 1;i >= 0 && j >= 0;i--,j--) {
            if(chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        for(int i = row - 1,j = col + 1;i >= 0 && j <= n - 1;i--,j++) {
            if(chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
