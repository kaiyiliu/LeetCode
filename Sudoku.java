public class Sudoku {
    private boolean helper(int i, int j, char[][] board, List<HashSet<Character>> row, List<HashSet<Character>> col, List<HashSet<Character>> squ) {
        if (i == 9)
            return true;
        if (j == 9)
            return helper(i + 1, 0, board, row, col, squ);
        if (board[i][j] != '.')
            return helper(i, j + 1, board, row, col, squ);
        int index = i / 3 * 3 + j / 3;
        for (int n = 1; n <= 9; n++) {
            char cur = (char) (n + '0');
            if (!row.get(i).contains(cur) && !col.get(j).contains(cur) && !squ.get(index).contains(cur)) {
                board[i][j] = cur;
                row.get(i).add(cur);
                col.get(j).add(cur);
                squ.get(index).add(cur);
                if (helper(i, j + 1, board, row, col, squ))
                    return true;
                board[i][j] = '.';
                row.get(i).remove(cur);
                col.get(j).remove(cur);
                squ.get(index).remove(cur);
            }
        }
        return false;    
    }
    
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;
        ArrayList<HashSet<Character>> row = new ArrayList<HashSet<Character>>(9);
        ArrayList<HashSet<Character>> col = new ArrayList<HashSet<Character>>(9);
        ArrayList<HashSet<Character>> squ = new ArrayList<HashSet<Character>>(9);
        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<Character>());
            col.add(new HashSet<Character>());
            squ.add(new HashSet<Character>());
        }
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    int index = i / 3 * 3 + j / 3;
                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    squ.get(index).add(board[i][j]);
                }
        helper(0, 0, board, row, col, squ);
    }
}
