public class 3Sum {
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
            while (a[++i] < v && i < high) {}
            while (a[--j] > v) {}
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
    
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length < 3)
            return result;
        int i = 0;
        int j = num.length - 1;
        quickSort(num, i, j);
        while (num[i] <= 0 && num[j] >= 0 && j - i >= 2) {
            if (binarySearch(num, i + 1, j - 1))
        }
    }
}
