/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return res;
        
        // sort the list accoring the the start
        Collections.sort(intervals, new IntervalsComparator());
            
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            int left = cur.start;
            int right = cur.end;
            
            while (i + 1 < intervals.size() && right >= intervals.get(i + 1).start) {
                right = Math.max(right, intervals.get(i + 1).end);
                i++;
            }
            res.add(new Interval(left, right));
        }
        return res;
    }
}

class IntervalsComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}
    
    // private void sortList(int left, int right, List<Interval> intervals) {
    //     if (left >= right)
    //         return;
    //     int i = partition(left, right, intervals);
    //     sortList(left, i - 1, intervals);
    //     sortList(i + 1, right, intervals);
    // }
    
    // private int partition(int left, int right, List<Interval> intervals) {
    //     int i = left;
    //     int j = right - 1;
    //     int val = intervals.get(right).start;
    //     while (true) {
    //         while (intervals.get(i).start < val)
    //             i++;
    //         while (j > i && intervals.get(j).start > val);
    //             j--;
    //         if (i >= j)
    //             break;
    //         swap(i, j, intervals);
    //     }
    //     swap(i, right, intervals);
    //     return i;
    // }
    
    // private void swap(int i, int j, List<Interval> intervals) {
    //     if (i == j)
    //         return;
    //     Interval temp = new Interval(intervals.get(i).start, intervals.get(i).end);
    //     intervals.set(i, intervals.get(j));
    //     intervals.set(j, temp);
    // }
