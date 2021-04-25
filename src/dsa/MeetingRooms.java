package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.lintcode.com/problem/meeting-rooms-ii/
 */

public class MeetingRooms {
    /**
     * @param intervals: an array of meeting time intervals
     *
     * @return: the minimum number of conference rooms required
     */
    // [(0,30),(5,10),(15,20)]
    public static int minMeetingRooms(List<Interval> intervals) {
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

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) {
            return false;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(0, 30));
        list.add(new Interval(5, 10));
        list.add(new Interval(15, 20));
        minMeetingRooms(list);
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}