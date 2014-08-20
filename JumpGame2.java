public class JumpGame2 {
    public int jump(int[] A) {
        int i = 0;
        int step = 0;
        while (i < A.length - 1) {
            int next = i + A[i];
            if (next >= A.length - 1) {
                next = A.length - 1;
            } else {
                int max = next;
                for (int j = i + 1; j <= i + A[i]; j++) {
                    if (j + A[j] > max) {
                        max = j + A[j];
                        next = j;
                    }
                }
            }
            i = next;
            step++;
        }
        return step;
    }
}
