public class MinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        int low = 0;
        int high = num.length - 1;
        int mid;
        
        while (low < high) {
            mid = low + (high - low) / 2;
            if (num[mid] > num[mid+1])
                return num[mid+1];
            if (num[mid] > num[low])
                low = mid + 1;
            else
                high = mid;
        }
        return num[0];
    }
}
