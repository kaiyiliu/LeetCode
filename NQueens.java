import java.util.*;

public class NQueens {
    public LinkedList<String[]> a;
    public int[] row;
    
    public boolean isAllowed(int k, int l) {
        for (int i = 0; i <= k - 1; i++) {
            if (row[i] == l || Math.abs(k-i) == Math.abs(l-row[i]))
                return false;
        }
        return true;
    }
    
    public void writeToList(int n) {
        String[] solution = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(n);
            for (int j = 0; j < n; j++) {
                if (row[i] == j)
                    sb.append("Q");
                else
                    sb.append(".");
            }
            solution[i] = sb.toString();
        }
        a.add(solution);
    }
    
    public void NQueens(int k, int n) {
        for (int l = 0; l < n; l++) {
            if (isAllowed(k, l)) {
                row[k] = l;
                if (k == n - 1) {
                    writeToList(n);
                } else {
                    NQueens(k+1, n);
                }
            }
        }
    }
    
    public List<String[]> solveNQueens(int n) {
        a = new LinkedList<String[]>();
        row = new int[n];
        NQueens(0, n);
        return a;
        
    }
    
    public static void main(String[] args) {
        NQueens s = new NQueens();
        
        System.out.println( ((LinkedList<String[]>) s.solveNQueens(4)).getFirst()[0]);
    }
}
