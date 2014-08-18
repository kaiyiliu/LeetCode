public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        if (S == null)
            return null;
        Arrays.sort(S);
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        result.add(new LinkedList<Integer>());
        for (int i = 0; i < S.length; i++) {
            List<List<Integer>> temp = new LinkedList<List<Integer>>();
            for (List<Integer> oldList : result) {
                List<Integer> newList = new LinkedList<Integer>(oldList);
                newList.add(S[i]);
                temp.add(newList);
            }
            result.addAll(temp);
        }
        return result;
    }
}
