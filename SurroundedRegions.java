public class SurroundedRegions {
    public void fill(char[][] board, int i, int j, int M, int N) {
        LinkedList<List<Integer>> q = new LinkedList<List<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>(2);
        a.add(i);
        a.add(j);
        q.add(a);
        while (!q.isEmpty()) {
            List<Integer> cur = q.pop();
            int k = cur.get(0);
            int l = cur.get(1);
            if (k < 0 || k >= M || l < 0 || l >= N || board[k][l] != 'O')
                continue;
            board[k][l] = '!';
            q.add(Arrays.asList(k + 1, l));
            q.add(Arrays.asList(k - 1, l));
            q.add(Arrays.asList(k, l + 1));
            q.add(Arrays.asList(k, l - 1));
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int M = board.length;
        int N = board[0].length;
        for (int j = 0; j < N; j++) {
            if (board[0][j] == 'O')
                fill(board, 0, j, M, N);
            if (board[M-1][j] == 'O')
                fill(board, M-1, j, M, N);
        }
        for (int i = 1; i < M - 1; i++) {
            if (board[i][0] == 'O')
                fill(board, i, 0, M, N);
            if (board[i][N-1] == 'O')
                fill(board, i, N-1, M, N);
        }
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '!')
                    board[i][j] = 'O';
            }
    }
}
