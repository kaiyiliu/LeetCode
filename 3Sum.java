public class Solution {
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
    
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
        if (num == null || num.length < 3)
            return result;
        int i = 0;
        int j = num.length - 1;
        quickSort(num, i, j);
        if (num[num.length - 1] < 0)
            return result;
        for (; i < num.length && num[i] <= 0; i++, j = num.length - 1) {
            if (i != 0 && num[i] == num[i - 1])
                continue;
            for (; j >= 0 && num[j] >=0; j--) {
                if (j != num.length - 1 && num[j] == num[j + 1])
                    continue;
                int mid = binarySearch(num, -num[i] - num[j], i + 1, j - 1);
                if (mid != -1)
                    // hs.add(Arrays.asList(num[i], num[mid], num[j]));
                    result.add(Arrays.asList(num[i], num[mid], num[j]));
            }
        }
        // for (List<Integer> element : hs)
        //     result.add(element);
        return result;
    }
}
