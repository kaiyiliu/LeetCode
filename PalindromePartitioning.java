public class PalindromePartitioning {
    // add a new list into the result list
    
    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                break;
            i++;
            j--;
        }
        if (i >= j)
            return true;
        return false;
    }
    
    private void helper(int n, String s, List<String> list, List<List<String>> result) {
        if (n == s.length()) {
            result.add(new LinkedList(list));
            return;
        }
        for (int j = n; j < s.length(); j++) {
            if (isPalindrome(n, j, s)) {
                list.add(s.substring(n, j + 1));
                helper(j + 1, s, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<List<String>>();
        if (s == null || s.length() == 0)
            return result;
        List<String> list = new LinkedList<String>();
        helper(0, s, list, result);
        return result;
    }
}
