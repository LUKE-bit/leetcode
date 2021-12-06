class Solution {
    public void solveSudoku(char[][] board) {
        backTracking(board);
    }
    public boolean backTracking(char[][] board) {
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] != '.' ) {
                    continue;
                }
                for(char c = '1';c <= '9';c++) {
                    if(isValid(i,j,c,board)) {
                        board[i][j] = c;
                        if(backTracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int row,int col,char val,char[][] board) {
        //检查行
        for(int i = 0;i < board[0].length;i++) {
            if(board[row][i] == val) {
                return false;
            }
        }
        //检查列
        for(int j = 0;j < board.length;j++) {
            if(board[j][col] == val) {
                return false;
            }
        }
        //检查九宫格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow;i < startRow + 3;i++) {
            for(int j = startCol;j < startCol + 3;j++) {
                if(board[i][j] == val) {
                    return false;
                }
            }
        }

        return  true;
    }
}
