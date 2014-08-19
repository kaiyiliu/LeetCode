public class SearchForRange {
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
    
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if (A == null)
            return result;
        int index = binarySearch(A, target, 0, A.length - 1);
        if (index == -1)
            return result;
        int i;
        for (i = index - 1; i >=0; i--) {
            if (A[i] != target)
                break;
        }
        result[0] = i + 1;
        for (i = index + 1; i < A.length; i++) {
            if (A[i] != target)
                break;
        }
        result[1] = i - 1;
        return result;
    }
}
