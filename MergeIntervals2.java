/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals2 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return res;
        for (Interval e : intervals)
            res = insert(res, e);
        return res;
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        
        boolean isInserted = false;
        for (Interval i : intervals) {
            if (isInserted || newInterval.start > i.end)
                res.add(i);
            else if (newInterval.end < i.start) {
                res.add(newInterval);
                res.add(i);
                isInserted = true;
            } else
                newInterval = new Interval(Math.min(newInterval.start, i.start), Math.max(newInterval.end, i.end));
        }
        if (!isInserted)
            res.add(newInterval);
        
        return res;
    }
}
