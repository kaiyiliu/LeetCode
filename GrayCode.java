public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<Integer>();
        if (n < 0)
            return result;
        
        result.add(0);
        
        for (int k = 0; k < n; k++) {
            int oldSize = result.size();
            int val = 1 << k;
            for (int i = oldSize - 1; i >= 0; i--)
                result.add(result.get(i) + val);
        }
        
        return result;
    }
}
