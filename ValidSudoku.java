public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        for (int i = 0; i < 9; i++)
            if (!isValidRow(board, i, 0))
                return false;
        
        for (int j = 0; j < 9; j++)
            if (!isValidColumn(board, 0, j))
                return false;
                
        for (int i = 0; i < 9; i = i + 3)
            for (int j = 0; j < 9; j = j + 3)
                if (!isValidSquare(board, i, j))
                    return false;
                    
        return true;
    }
    
    private boolean isValidSquare(char[][] board, int i, int j) {
        int[] temp = new int[9];
        for (int ii = i; ii < i + 3; ii++)
            for (int jj = j; jj < j + 3; jj++) {
                if (board[ii][jj] == '.')
                    continue;
                int index = board[ii][jj] - '0';
                if (index < 1 || index > 9)
                    return false;
                temp[index - 1]++;
            }
        for (Integer e : temp) {
            if (e > 1)
                return false;
        }
        return true;
    }
    
    private boolean isValidColumn(char[][] board, int i, int j) {
        int[] temp = new int[9];
        for (int ii = i; ii < 9; ii++) {
                if (board[ii][j] == '.')
                    continue;
                int index = board[ii][j] - '0';
                if (index < 1 || index > 9)
                    return false;
                temp[index - 1]++;
            }
        for (Integer e : temp) {
            if (e > 1)
                return false;
        }
        return true;
    }
    
    private boolean isValidRow(char[][] board, int i, int j) {
        int[] temp = new int[9];
        for (int jj = j; jj < 9; jj++) {
                if (board[i][jj] == '.')
                    continue;
                int index = board[i][jj] - '0';
                if (index < 1 || index > 9)
                    return false;
                temp[index - 1]++;
            }
        for (Integer e : temp) {
            if (e > 1)
                return false;
        }
        return true;
    }
}
