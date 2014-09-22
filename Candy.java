public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int len = ratings.length;
        int res = 0;
        int[] cur = new int[len];
        cur[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1])
                cur[i] = cur[i-1] + 1;
            else
                cur[i] = 1;
        }
        
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && cur[i] <= cur[i+1])
                cur[i] = cur[i+1] + 1;
        }
        
        for (int e : cur)
            res += e;
        return res;
    }
}
