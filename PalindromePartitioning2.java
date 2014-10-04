public class PalindromePartitioning2 {
    // dp: cache isPalindrome
    
    public int minCut(String s) {
       int min = 0;  
        int len = s.length();  
        boolean[][] matrix = new boolean[len][len];  
        int cuts[] = new int[len+1];  
          
        if (s == null || s.length() == 0)  
            return min;  
          
        for (int i = 0; i <= len; i++){  
            cuts[i] = i - 1;  
        }  
          
        for (int j = 0; j < len; j++) {  
            char cur = s.charAt(j);
            for (int i = 0; i <= j; i++) {  
                if (cur == s.charAt(i) && (i > j - 2 || matrix[i+1][j-1]))  
                {
                    matrix[i][j] = true;  
                    cuts[j+1] = getMinValue(cuts[j+1], cuts[i] + 1);  
                }  
            }  
        }  
        return cuts[len];
    }  
      
    public int getMinValue(int a, int b){  
        return a > b ? b : a;  
    }  

}
