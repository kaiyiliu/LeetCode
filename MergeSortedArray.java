public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null)
            return;
        for (int i = m - 1; i >= 0; i--)
            A[i+n] = A[i];
        int i = n;
        int j = 0;
        int index = 0;
        while (i < n + m && j < n)
            A[index++] = (A[i] < B[j]) ? A[i++] : B[j++];
        while (j < n)
            A[index++] = B[j++];
    }
}
