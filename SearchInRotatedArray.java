public class SearchInRotatedArray {
    public int binarySearch(int[] A, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (high - low) / 2 + low;
        if (target > A[mid])
            return binarySearch(A, target, mid + 1, high);
        if (target < A[mid])
            return binarySearch(A, target, low, mid - 1);
        return mid;
    }
    
    public int search(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        if (A[0] == target)
            return 0;
        int i = 1;
        while (i < A.length) {
            if (A[i] == target)
                return i;
            if (A[i] < A[i - 1])
                return binarySearch(A, target, i, A.length - 1);
            i++;
        }
        return -1;
    }
}
