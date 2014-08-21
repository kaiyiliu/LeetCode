public class SortColor {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0)
            return;
        int[] temp = new int[3];
        for (int e : A)
            temp[e]++;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            while (temp[j] == 0)
                j++;
            A[i] = j;
            temp[j]--;
        }
    }
}
