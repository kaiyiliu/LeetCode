public class RemoveDupFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int i = 0;
        int j = 1;
        while (j < A.length) {
            if (A[i] != A[j])
                A[++i] = A[j];
            j++;
        }
        return i + 1;
    }
}
