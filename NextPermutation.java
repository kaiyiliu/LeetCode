public class NextPermutation {
    private void sort(int low, int high, int[] num) {
        if (low >= high)
            return;
        int j = partition(low, high, num);
        sort(low, j - 1, num);
        sort(j + 1, high, num);
    }
    
    private int partition(int low, int high, int[] num) {
        int i = low;
        int j = high + 1;
        int value = num[low];
        while (true) {
            while (num[++i] < value)
                if (i == high)
                    break;
            while (num[--j] > value) {
            }
            if (i >= j)
                break;
            swap(i, j, num);
        }
        swap(low, j, num);
        return j;
    }
    
    private void swap(int i, int j, int[] num) {
        if (i == j)
            return;
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0)
            return;
        int len = num.length;
        int i = len - 1;
        for (; i > 0; i--) {
            if (num[i - 1] < num[i])
                break;
        }
        sort(i, len - 1, num);
        if (i == 0)
            return;
        int j = i;
        for (; j < len; j++) {
            if (num[j] > num[i - 1])
                break;
        }
        swap(i - 1, j, num);
    }
}
