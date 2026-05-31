/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> rooms = new PriorityQueue<Interval>((a,b)->Integer.compare(a.end,b.end));
        Collections.sort(intervals, (a,b)->Integer.compare(a.start,b.start));

        for(Interval interval: intervals) {
            if(rooms.isEmpty() || (!rooms.isEmpty() && rooms.peek().end > interval.start)) {
                rooms.offer(new Interval(interval.start,interval.end));
            } else {
             Interval poll = rooms.poll();
             poll.end=interval.end;
             rooms.offer(poll);
            }
        }
        return rooms.size();
    }
}
