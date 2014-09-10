/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;
        
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();  // slope and count
            int dup = 0;
            Point a = points[i];
            // check if the rest points are enough
            if (points.length - i <= max)
                break;
            for (int j = i + 1; j < points.length; j++) {
                Point b = points[j];
                // check duplicate
                if (a.x == b.x && a.y == b.y) {
                    dup++;
                    continue;
                }
                // check infinite slop
                double slope = (a.x == b.x) ? Integer.MAX_VALUE : 0.0 + (double) (a.y - b.y) / (double) (a.x - b.x);
                if (hm.containsKey(slope))
                    hm.put(slope, hm.get(slope) + 1);
                else
                    hm.put(slope, 2);
            }
            if (hm.isEmpty())
                return Math.max(max, dup + 1);        // if all points are duplicated, no need to continue
            for (Integer temp : hm.values())
                if (temp + dup > max)
                    max = temp + dup;
        }
        return max;
    }
}
