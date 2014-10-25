/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        List<Interval> res = new ArrayList<Interval>();
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        
        // locate the new interval's start, append previouds,
        // and update the new start
        while (i < intervals.size() && newStart > intervals.get(i).end) {
            res.add(intervals.get(i));
            i++;
        }
        if (i < intervals.size())
            newStart = Math.min(newStart, intervals.get(i).start);
        
        // locate the new interval's end, update the new end.
        // Notice if the new interval's end is smaller than current ith's start
        while (i + 1 < intervals.size() && newEnd >= intervals.get(i + 1).start) {
            i++;
        }
        if (i < intervals.size() && newEnd >= intervals.get(i).start)
            newEnd = Math.max(newEnd, intervals.get(i).end);
        
        // Insert the new interval
        res.add(new Interval(newStart, newEnd));
        
        // Move to the next interval if needed
        if (i < intervals.size() && newEnd >= intervals.get(i).start)
            i++;
         
        // Append the rest intervlas  
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        
        return res;
    }
}
