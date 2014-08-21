public class SortColor2 {
    public boolean goSwap(int[] A, int i, int[] pointer) {
        if (pointer[1] <= i)
            pointer[1] = i + 1;
        for (; pointer[1] < A.length; pointer[1]++) {
            if (A[pointer[1]] == pointer[0]) {
                A[pointer[1]++] = A[i];
                A[i] = pointer[0];
                return true;
            }
        }
        return false;
    }
    
    public void sortColors(int[] A) {
        if (A == null || A.length == 0)
            return;
        int[] pointer = {0, 0};         // pointer[0] is the color, pointer[1] is the fast pointer
        for (int i = 0; i < A.length; i++) {
            if (pointer[0] > 2)
                break;
            if (A[i] > pointer[0]) {
                while (A[i] > pointer[0] && !goSwap(A, i, pointer)) {
                    pointer[0]++;
                    pointer[1] = i + 1;
                }
            }
        }
    }
}
