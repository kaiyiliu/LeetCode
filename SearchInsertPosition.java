public class Solution {
    public int search(int[] A, int target, int low, int high) {
        if (low > high)
            return low;
        int mid = (high - low) / 2 + low;
        if (target > A[mid])
            return search(A, target, mid + 1, high);
        else if (target < A[mid])
            return search(A, target, low, mid - 1);
        else
            return mid;
    }
    public int searchInsert(int[] A, int target) {
        if (A == null)
            return 0;
        return search(A, target, 0, A.length - 1);
    }
}
