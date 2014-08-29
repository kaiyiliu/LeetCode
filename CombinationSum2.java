public class CombinationSum2 {
    private void helper(int start, int[] candidates, int target, int sum, List<Integer> list, List<List<Integer>> result) {
        if (sum > target)
            return;
        if (sum == target) {
            result.add(new LinkedList(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            helper(i + 1, candidates, target, sum + candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null)
            return result;
        List<Integer> list = new LinkedList<Integer>();
        Arrays.sort(num);
        helper(0, num, target, 0, list, result);
        return result;
    }
}
