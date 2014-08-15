public class Permutation1 {
    public void doPerm(LinkedList<List<Integer>> result, int index, int[] num) {
        if (index == num.length - 1) {
            List<Integer> list= new LinkedList<Integer>();
            for (int element : num)
                list.add(element);
            result.add(list);
        }
        for (int j = index; j <= num.length - 1; j++) {
            swap(index, j, num);
            doPerm(result, index + 1, num);
            swap(index, j, num);
        }
    }
    
    public void swap(int i, int j, int[] num) {
        if (i == j)
            return;
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public List<List<Integer>> permute(int[] num) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null)
            return result;
        doPerm(result, 0, num);
        return result;
    }
}
