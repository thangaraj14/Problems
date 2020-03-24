package geeksforgeeks;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.lintcode.com/problem/meeting-rooms-ii/
 */

public class MeetingRoomsII {
    /**
     * @param intervals: an array of meeting time intervals
     *
     * @return: the minimum number of conference rooms required
     */
    // [(0,30),(5,10),(15,20)]
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return -1;
        }

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            if (queue.peek() <= temp.start) {
                queue.poll();
            }
            queue.offer(temp.end);
        }

        return queue.size();

    }
}
