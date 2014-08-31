public class SqrtX {
    public int sqrt(int x) {
        if (x < 0)
            return -1;
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        double x0 = x / 2.0;
        double x1 = x0 - (x0 * x0 - x) / (2.0 * x0);
        while ((int) x0 != (int) x1) {
            x0 = x1;
            x1 = x0 - (x0 * x0 - x) / (2.0 * x0);
        }
        return (int) x0;
    }
}
