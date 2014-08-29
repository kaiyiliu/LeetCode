public class Combinations {
    // notice that getLast() is not List's method
    
    private void helper(List<List<Integer>> result, List<Integer> list, int cur, int k, int n) {
        if (cur > k) {
            result.add(new LinkedList(list));     // critical
            return;
        }
        int last;
        if (list.isEmpty())
            last = 0;
        else
            last = list.get(list.size() - 1);
        for (int i = last + 1; i <= n - k + cur; i++) {
            list.add(i);
            helper(result, list, cur + 1, k, n);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (n <= 0 || k <= 0 || k > n)
            return result;
        List<Integer> list = new LinkedList<Integer>();
        helper(result, list, 1, k, n);
        return result;
    }
}
