public class Gas Station {
    // check the validation from index 0, if check all circle valid, true.
    // if not valid in one place, check starting form that place + 1.
    // if check starting the full circle, false
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length)
            return -1;
        int N = gas.length;
        int i = 0;
        while (true) {
            int nextIndex = isValid(i, gas, cost, N);
            if (nextIndex >= N)
                break;
            if (nextIndex == i)
                return i;
            i = nextIndex;
        }
        return -1;
    }
    
    private int isValid(int i, int[] gas, int[] cost, int N) {
        int hasGas = 0;
        for (int j = 0; j < N; j++) {
            int index = (i + j) % N;
            hasGas += (gas[index] - cost[index]);
            if (hasGas < 0)
                return i + j + 1;
        }
        return i;
    }
}
