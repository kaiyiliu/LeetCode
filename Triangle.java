public class Triangle {
    // be very careful about the array implementation,
    // like binary tree but not exactly
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return Integer.MAX_VALUE;
        int i = 0;
        int N = triangle.size();
        int[] A =  new int[(N * N + N) / 2];
        int result = Integer.MAX_VALUE;
        for (List<Integer> list : triangle) {
            int len = list.size();
            if (len == 1) {
                A[i++] = list.get(0);
                continue;
            }
            int start = i;
            int end = i + len - 1;
            A[start] = A[start - len + 1] + list.get(0);
            A[end] = A[end - len] + list.get(len - 1);
            for (i = start + 1; i < end; i++)
                A[i] = Math.min(A[i - len + 1], A[i - len]) + list.get(i - start);
            i = end + 1;
        }
        for (int j = i - 1; j >= i - N; j--)
            result = Math.min(result, A[j]);
        return result;
    }
}
