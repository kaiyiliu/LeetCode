public class CombinationSum {
    private void helper(int start, int[] candidates, int target, int sum, List<Integer> list, List<List<Integer>> result) {
        if (sum > target || start >= candidates.length)
            return;
        if (sum == target) {
            result.add(new LinkedList(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(i, candidates, target, sum + candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (candidates == null)
            return result;
        List<Integer> list = new LinkedList<Integer>();
        Arrays.sort(candidates);
        helper(0, candidates, target, 0, list, result);
        return result;
    }
}
