public class RemoveDupFromSortedArray2 {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int i = 0;
        int num = 1;
        for (int j = 1; j < A.length; j++) {
            if (A[j] == A[i]) {
                if (num < 2) {
                    A[++i] = A[j];
                    num++;
                }
            } else {
                A[++i] = A[j];
                num = 1;
            }
        }
        return i + 1;
    }
}
