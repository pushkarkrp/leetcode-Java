class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int result = Integer.MIN_VALUE;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, (a,b) -> a[1] - b[1]);
        for (int[] interval : intervals) {
            if(!minHeap.isEmpty() && minHeap.peek()[1] <= interval[0]) {
                minHeap.poll();
            }
            minHeap.add(interval);
            result = Math.max(result, minHeap.size());
        }
        return result;
    }
    
}