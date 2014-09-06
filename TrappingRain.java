public class TrappingRain {
    public int trap(int[] A) {
        if (A == null || A.length <= 1)
            return 0;
        int volume = 0;
        int start = 0;
        while (start + 1 < A.length && A[start] <= A[start + 1])
            start++;
        if (start + 1 >= A.length)
            return volume;
        int end = start + 1;
        while (true) {
            // the end initially must be lower than start
            int nextEnd = end;
            while (end < A.length) {
                if (A[end] > A[nextEnd])
                    nextEnd = end;
                if (A[end] > A[start])
                    break;
                end++;
            }
            if (nextEnd >= A.length)
                break;
            int bar = Math.min(A[start], A[nextEnd]);
            for (int i = start + 1; i < nextEnd; i++)
                volume += bar - A[i];
            start = nextEnd;
            end = start + 1;
        }
        return volume;
    }
}
