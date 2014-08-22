public class 3SumClosest {
    public void quickSort(int[] a, int low, int high) {
        if (low >= high)
            return;
        int pivot = partition(a, low, high);
        quickSort(a, low, pivot - 1);
        quickSort(a, pivot + 1, high);
    }
    
    public int partition(int[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = a[low];
        while (true) {
            while (a[++i] <= v && i < high) {}
            while (a[--j] >= v && j > low) {}
            if (i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }
    
    public void swap(int[] a, int i, int j) {
        if (i == j)
            return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public int binarySearch(int[] num, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (high - low) / 2 + low;
        if (target < num[mid])
            return binarySearch(num, target, low, mid - 1);
        if (target > num[mid])
            return binarySearch(num, target, mid + 1, high);
        return mid;
    }
    
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3)
            return Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE / 2;
        quickSort(num, 0, num.length - 1);
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum < target) {
                    left++;
                    while (left < right && num[left] == num[left - 1])
                        left++;
                } else if (sum > target) {
                    right--;
                    while (left < right && num[right] == num[right + 1])
                        right--;
                } else {
                    return sum;
                }
                closest = (Math.abs(sum - target) < Math.abs(closest - target)) ? sum : closest;
            }
        }
        return closest;
    }
}
