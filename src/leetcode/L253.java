package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L253 {
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        queue.offer(intervals[0][1]);
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }
}
