public class WordSearch {
    private boolean helper(int i, int j, char[][] board, int cur, String word) {
        if (cur == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] != word.charAt(cur))
            return false;
        board[i][j] = '#';
        boolean isValid =  helper(i - 1, j, board, cur + 1, word) || helper(i + 1, j, board, cur + 1, word)
                        || helper(i, j - 1, board, cur + 1, word) || helper(i, j + 1, board, cur + 1, word);
        board[i][j] = word.charAt(cur);
        return isValid;
    }
    
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            return false;
        if (word.length() == 0)
            return true;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (helper(i, j, board, 0, word))
                    return true;
        return false;
    }
}
