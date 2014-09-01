public class PermutationSequence {
    private String helper(int i, char[] a, int[] count) {
        if (i == a.length - 1)
            if (--count[0] == 0)
                return new String(a);
            else return null;
        for (int j = i; j < a.length; j++) {
            for (int k = j; k > i; k--)
                swap(k, k - 1, a);
            String result = helper(i + 1, a, count);
            if (result != null)
                return result;
            for (int k = i; k < j; k++)   // reverse swap
                swap(k, k + 1, a);
        }
        return null;
    }
    
    private void swap(int i, int j, char[] a) {
        if (i == j)
            return;
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public String getPermutation(int n, int k) {
        if (n < 1 || k < 1)
            return null;
        char[] a = new char[n];
        int[] count = {k};
        for (int i = 0; i < n; i++)
            a[i] = (char) (i + 1 + '0');
        return helper(0, a, count);
    }
}
