public class FirstMissingPositive {
    public boolean swap(int[] A, int i, int j) {
        if (i == j || A[i] == A[j])
            return false;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return true;
    }
    public int firstMissingPositive(int[] A) {
        if (A == null)
            return 1;
        for (int i = 0; i < A.length; i++)
            while (A[i] > 0 && A[i] <= A.length && swap(A, i, A[i]-1)) {}
        for (int i = 0; i < A.length; i++)
            if (A[i] != i + 1)
                return i + 1;
        return A.length + 1;
    }
}
